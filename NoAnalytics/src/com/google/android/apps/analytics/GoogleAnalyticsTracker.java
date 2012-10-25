package com.google.android.apps.analytics;

import android.content.Context;

public class GoogleAnalyticsTracker {
	public static final String PRODUCT = "GoogleAnalytics";
	public static final String VERSION = "1.4.2";
	public static final String WIRE_VERSION = "4.8.1ma";
	public static final String LOG_TAG = "GoogleAnalyticsTracker";
	private static GoogleAnalyticsTracker instance = new GoogleAnalyticsTracker();
	private boolean dryRun = true;
	private boolean debug = false;
	private boolean anonymizeIp = false;
	private int sampleRate = 100;

	public static GoogleAnalyticsTracker getInstance() {
		return instance;
	}

	public void start(String s, int i, Context context) {
		// NOTHING
	}

	public void startNewSession(String s, int i, Context context) {
		// NOTHING
	}

	public void start(String s, Context context) {
		// NOTHING
	}

	public void startNewSession(String s, Context context) {
		// NOTHING
	}

	public void setProductVersion(String userAgentProduct,
			String userAgentVersion) {
	}

	public void trackEvent(String category, String action, String s2, int i) {
		// NOTHING
	}

	public void trackPageView(String s) {
		// NOTHING
	}

	public void setDispatchPeriod(int i) {
		// NOTHING
	}

	public void stopSession() {
		// NOTHING
	}

	public void stop() {
		// NOTHING
	}

	public boolean setCustomVar(int i, String s, String s1, int j) {
		return true;
	}

	public boolean setCustomVar(int i, String s, String s1) {
		return true;
	}

	public String getVisitorCustomVar(int i) {
		return null;
	}

	public boolean dispatch() {
		return false;
	}

	public void addTransaction(Transaction transaction) {
		// NOTHING
	}

	public void addItem(Item item) {
		// NOTHING
	}

	public void trackTransactions() {
		// NOTHING
	}

	public void clearTransactions() {
		// NOTHING
	}

	public void setAnonymizeIp(boolean flag) {
		anonymizeIp = flag;
	}

	public boolean getAnonymizeIp() {
		return anonymizeIp;
	}

	public void setUseServerTime(boolean flag) {
	}

	public void setSampleRate(int i) {
		sampleRate = i;
	}

	public int getSampleRate() {
		return sampleRate;
	}

	public boolean setReferrer(String s) {
		return true;
	}

	public void setDebug(boolean flag) {
		debug = flag;
	}

	public boolean getDebug() {
		return debug;
	}

	public void setDryRun(boolean flag) {
		dryRun = flag;
	}

	public boolean isDryRun() {
		return dryRun;
	}

	public boolean setDispatcher(Dispatcher dispatcher) {
		return true;
	}
}
