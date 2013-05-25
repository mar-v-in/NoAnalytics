package com.google.analytics.tracking.android;

public interface Analytics {

	public boolean debugEnabled();
	public Tracker getDefaultTracker();
	public Tracker getTracker(String trackingId);
	public void requestAppOptOut(Analytics.AppOptOutCallback callback);
	public void setAppOptOut(boolean optOut);
	public void setDebug(boolean debug);
	public void setDefaultTracker(Tracker tracker);

	public static interface AppOptOutCallback {
		public void reportAppOptOut(boolean optOut);
	}

}
