package com.google.analytics.tracking.android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Tracker {
	private Map<String, String> map = new HashMap<String, String>();
	private ExceptionParser exceptionParser;
	private TrackerHandler handler;
	private String name;

	Tracker() {

	}

	Tracker(String trackingId, TrackerHandler handler) {
		map.put("trackingId", trackingId);
		map.put("sampleRate", Integer.toString(100));
		map.put("useSecure", Boolean.toString(true));
		this.handler = handler;
	}

	Tracker(String name, String trackingId, TrackerHandler handler) {
		this(trackingId, handler);
		this.name = name;
	}

	private static String microsToCurrencyString(long currencyInMicros) {
		return new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US))
				.format((double) currencyInMicros / 1000000D);
	}

	public void close() {
		if (handler != null) {
			handler.closeTracker(this);
		}
	}

	public Map<String, String> constructEvent(String category, String action, String label, Long value) {
		Map<String, String> event = new HashMap<String, String>();
		event.put("eventCategory", category);
		event.put("eventAction", action);
		event.put("eventLabel", label);
		if (value != null)
			event.put("eventValue", Long.toString(value.longValue()));
		return event;
	}

	public Map<String, String> constructException(String exceptionDescription, boolean fatal) {
		Map<String, String> exception = new HashMap<String, String>();
		exception.put("exDescription", exceptionDescription);
		exception.put("exFatal", Boolean.toString(fatal));
		return exception;
	}

	private Map<String, String> constructItem(Transaction.Item transactionItem, Transaction transaction) {
		Map<String, String> item = new HashMap<String, String>();
		item.put("transactionId", transaction.getTransactionId());
		item.put("currencyCode", transaction.getCurrencyCode());
		item.put("itemCode", transactionItem.getSKU());
		item.put("itemName", transactionItem.getName());
		item.put("itemCategory", transactionItem.getCategory());
		item.put("itemPrice", microsToCurrencyString(transactionItem.getPriceInMicros()));
		item.put("itemQuantity", Long.toString(transactionItem.getQuantity()));
		return item;
	}

	public Map<String, String> constructRawException(String threadName, Throwable exception, boolean fatal)
			throws IOException {
		Map<String, String> except = new HashMap<String, String>();
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		ObjectOutputStream stream = new ObjectOutputStream(byteStream);
		stream.writeObject(exception);
		stream.close();
		except.put("rawException", Utils.hexEncode(byteStream.toByteArray()));
		if (threadName != null)
			except.put("exceptionThreadName", threadName);
		except.put("exFatal", Boolean.toString(fatal));
		return except;
	}

	public Map constructSocial(String network, String action, String target) {
		Map<String, String> social = new HashMap<String, String>();
		social.put("socialNetwork", network);
		social.put("socialAction", action);
		social.put("socialTarget", target);
		return social;
	}

	public Map<String, String> constructTiming(String category, long intervalInMilliseconds, String name,
											   String label) {
		Map<String, String> timing = new HashMap<String, String>();
		timing.put("timingCategory", category);
		timing.put("timingValue", Long.toString(intervalInMilliseconds));
		timing.put("timingVar", name);
		timing.put("timingLabel", label);
		return timing;
	}

	public Map<String, String> constructTransaction(Transaction transaction) {
		Map<String, String> trans = new HashMap<String, String>();
		trans.put("transactionId", transaction.getTransactionId());
		trans.put("transactionAffiliation", transaction.getAffiliation());
		trans.put("transactionShipping", microsToCurrencyString(transaction.getShippingCostInMicros()));
		trans.put("transactionTax", microsToCurrencyString(transaction.getTotalTaxInMicros()));
		trans.put("transactionTotal", microsToCurrencyString(transaction.getTotalCostInMicros()));
		trans.put("currencyCode", transaction.getCurrencyCode());
		return trans;
	}

	public String get(String key) {
		return map.get(key);
	}

	public String getAppId() {
		return map.get("appId");
	}

	public void setAppId(String appId) {
		map.put("appId", appId);
	}

	public String getAppInstallerId() {
		return map.get("appInstallerId");
	}

	public void setAppInstallerId(String appInstallerId) {
		map.put("appInstallerId", appInstallerId);
	}

	public ExceptionParser getExceptionParser() {
		return exceptionParser;
	}

	public void setExceptionParser(ExceptionParser exceptionParser) {
		this.exceptionParser = exceptionParser;
	}

	public String getName() {
		return name;
	}

	public double getSampleRate() {
		return Utils.safeParseDouble(map.get("sampleRate"));
	}

	public void setSampleRate(double sampleRate) {
		map.put("sampleRate", Double.toString(sampleRate));
	}

	public String getTrackingId() {
		return map.get("trackingId");
	}

	private void internalSend(String hitType, Map<String, String> params) {
		if (params != null) {
			map.putAll(params);
		}
		map.put("hitType", hitType);

		// Clone the map
		Map<String, String> map = new HashMap<String, String>();
		map.putAll(this.map);
		if (handler != null) {
			handler.sendHit(map);
		}
	}

	public boolean isAnonymizeIpEnabled() {
		return Utils.safeParseBoolean(map.get("anonymizeIp"));
	}

	public boolean isUseSecure() {
		return Utils.safeParseBoolean(map.get("anonymizeIp"));
	}

	public void setUseSecure(boolean useSecure) {
		map.put("useSecure", Boolean.toString(useSecure));
	}

	public void send(String hitType, Map<String, String> params) {
		internalSend(hitType, params);
	}

	public void send(Map<String, String> params) {

	}

	public void sendEvent(String category, String action, String label, Long value) {
		internalSend("event", constructEvent(category, action, label, value));
	}

	public void sendException(String description, boolean fatal) {
		internalSend("exception", constructException(description, fatal));
	}

	public void sendException(String threadName, Throwable exception, boolean fatal) {
		if (exceptionParser != null) {
			sendException(exceptionParser.getDescription(threadName, exception), fatal);
		} else {
			try {
				internalSend("exception", constructRawException(threadName, exception, fatal));
			} catch (IOException e) {
				sendException("Unknown Exception", fatal);
			}
		}
	}

	public void sendSocial(String network, String action, String target) {
		internalSend("social", constructSocial(network, action, target));
	}

	public void sendTiming(String category, long intervalInMilliseconds, String name, String label) {
		internalSend("timing", constructTiming(category, intervalInMilliseconds, name, label));
	}

	public void sendTransaction(Transaction transaction) {
		internalSend("tran", constructTransaction(transaction));
		for (Transaction.Item item : transaction.getItems()) {
			internalSend("item", constructItem(item, transaction));
		}
	}

	public void sendView() {
		internalSend("appview", null);
	}

	public void sendView(String appScreen) {
		setAppScreen(appScreen);
		internalSend("appview", null);
	}

	public void set(String key, String value) {
		map.put(key, value);
	}

	public void setAnonymizeIp(boolean anonymizeIp) {
		map.put("anonymizeIp", Boolean.toString(anonymizeIp));
	}

	public void setAppName(String appName) {
		map.put("appName", appName);
	}

	public void setAppScreen(String appScreen) {
		map.put("description", appScreen);
	}

	public void setAppVersion(String appVersion) {
		map.put("appVersion", appVersion);
	}

	public void setCampaign(String campaign) {
		map.put("campaign", campaign);
	}

	public void setCustomDimension(int index, String value) {

	}

	public void setCustomDimensionsAndMetrics(Map<Integer, String> dimensions, Map<Integer, Long> metrics) {

	}

	public void setCustomMetric(int index, Long value) {

	}

	public void setReferrer(String referrer) {
		map.put("referrer", referrer);
	}

	public void setStartSession(boolean startSession) {

	}

	public void setThrottlingEnabled(boolean throttlingEnabled) {

	}

	@Deprecated
	public void trackEvent(String category, String action, String label, Long value) {
		sendEvent(category, action, label, value);
	}

	@Deprecated
	public void trackException(String description, boolean fatal) {
		sendException(description, fatal);
	}

	@Deprecated
	public void trackException(String threadName, Throwable exception, boolean fatal) {
		sendException(threadName, exception, fatal);
	}

	@Deprecated
	public void trackSocial(String network, String action, String target) {
		sendSocial(network, action, target);
	}

	@Deprecated
	public void trackTiming(String category, long intervalInMilliseconds, String name, String label) {
		sendTiming(category, intervalInMilliseconds, name, label);
	}

	@Deprecated
	public void trackTransaction(Transaction transaction) {
		sendTransaction(transaction);
	}

	@Deprecated
	public void trackView() {
		sendView();
	}

	@Deprecated
	public void trackView(String appScreen) {
		sendView(appScreen);
	}
}
