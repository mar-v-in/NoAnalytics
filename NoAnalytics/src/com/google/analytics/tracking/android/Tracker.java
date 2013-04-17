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

	private static String microsToCurrencyString(long currencyInMicros) {
		return new DecimalFormat("0.######", new DecimalFormatSymbols(Locale.US))
				.format((double) currencyInMicros / 1000000D);
	}

	public void setStartSession(boolean startSession) {

	}

	public void setAppName(String appName) {
		map.put("appName", appName);
	}

	public void setAppVersion(String appVersion) {
		map.put("appVersion", appVersion);
	}

	public void setAppScreen(String appScreen) {
		map.put("description", appScreen);
	}

	@Deprecated
	public void trackView() {
		sendView();
	}

	public void sendView() {

	}

	@Deprecated
	public void trackView(String appScreen) {
		sendView(appScreen);
	}

	public void sendView(String appScreen) {
		setAppScreen(appScreen);
	}

	@Deprecated
	public void trackEvent(String category, String action, String label, Long value) {
		sendEvent(category, action, label, value);
	}

	public void sendEvent(String category, String action, String label, Long value) {

	}

	@Deprecated
	public void trackTransaction(Transaction transaction) {
		sendTransaction(transaction);
	}

	public void sendTransaction(Transaction transaction) {

	}

	@Deprecated
	public void trackException(String description, boolean fatal) {
		sendException(description, fatal);
	}

	public void sendException(String description, boolean fatal) {

	}

	@Deprecated
	public void trackException(String threadName, Throwable exception, boolean fatal) {
		sendException(threadName, exception, fatal);
	}

	public void sendException(String threadName, Throwable exception, boolean fatal) {
		if (exceptionParser != null) {
			// Make sure own ExceptionParser is used.
			sendException(exceptionParser.getDescription(threadName, exception), fatal);
		}
	}

	@Deprecated
	public void trackTiming(String category, long intervalInMilliseconds, String name, String label) {
		sendTiming(category, intervalInMilliseconds, name, label);
	}

	public void sendTiming(String category, long intervalInMilliseconds, String name, String label) {

	}

	@Deprecated
	public void trackSocial(String network, String action, String target) {
		sendSocial(network, action, target);
	}

	public void sendSocial(String network, String action, String target) {

	}

	public void close() {

	}

	public void send(String hitType, Map params) {
		map.putAll(params);
	}

	public String get(String key) {
		return map.get(key);
	}

	public void set(String key, String value) {
		map.put(key, value);
	}

	public String getTrackingId() {
		return map.get("trackingId");
	}

	public void setAnonymizeIp(boolean anonymizeIp) {
		map.put("anonymizeIp", Boolean.toString(anonymizeIp));
	}

	public boolean isAnonymizeIpEnabled() {
		return Utils.safeParseBoolean(map.get("anonymizeIp"));
	}

	public double getSampleRate() {
		return Utils.safeParseDouble(map.get("sampleRate"));
	}

	public void setSampleRate(double sampleRate) {
		map.put("sampleRate", Double.toString(sampleRate));
	}

	public boolean isUseSecure() {
		return Utils.safeParseBoolean(map.get("anonymizeIp"));
	}

	public void setUseSecure(boolean useSecure) {
		map.put("useSecure", Boolean.toString(useSecure));
	}

	public void setReferrer(String referrer) {
		map.put("referrer", referrer);
	}

	public void setCampaign(String campaign) {
		map.put("campaign", campaign);
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

	public void setCustomDimension(int index, String value) {

	}

	public void setCustomMetric(int index, Long value) {

	}

	public void setCustomDimensionsAndMetrics(Map<Integer, String> dimensions, Map<Integer, Long> metrics) {

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

	public Map<String, String> constructException(String exceptionDescription, boolean fatal) {
		Map<String, String> exception = new HashMap<String, String>();
		exception.put("exDescription", exceptionDescription);
		exception.put("exFatal", Boolean.toString(fatal));
		return exception;
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

	public Map<String, String> constructTiming(String category, long intervalInMilliseconds, String name,
											   String label) {
		Map<String, String> timing = new HashMap<String, String>();
		timing.put("timingCategory", category);
		timing.put("timingValue", Long.toString(intervalInMilliseconds));
		timing.put("timingVar", name);
		timing.put("timingLabel", label);
		return timing;
	}

	public Map constructSocial(String network, String action, String target) {
		Map<String, String> social = new HashMap<String, String>();
		social.put("socialNetwork", network);
		social.put("socialAction", action);
		social.put("socialTarget", target);
		return social;
	}

	public void setThrottlingEnabled(boolean throttlingEnabled) {

	}
}
