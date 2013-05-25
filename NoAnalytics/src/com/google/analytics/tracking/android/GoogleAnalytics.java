package com.google.analytics.tracking.android;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class GoogleAnalytics implements TrackerHandler, Analytics {
	private static GoogleAnalytics instance;
	private boolean debug = false;
	private Map<String, Tracker> trackers = new HashMap<String, Tracker>();
	private Tracker defaultTracker;

	private GoogleAnalytics(Context context) {
		//To change body of created methods use File | Settings | File Templates.
	}

	public static GoogleAnalytics getInstance(Context context) {
		synchronized (GoogleAnalytics.class) {
			if (instance == null) {
				instance = new GoogleAnalytics(context);
			}
			return instance;
		}
	}

	@Override
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public boolean isDebugEnabled() {
		return debug;
	}

	@Override
	public boolean debugEnabled() {
		return isDebugEnabled();
	}

	@Override
	public synchronized Tracker getTracker(String trackingId) {
		if (!trackers.containsKey(trackingId)) {
			Tracker tracker = new Tracker(trackingId, this);
			trackers.put(trackingId, tracker);
			if (defaultTracker == null) {
				setDefaultTracker(tracker);
			}
			return tracker;
		}
		return trackers.get(trackingId);
	}

	@Override
	public void closeTracker(Tracker tracker) {
	}

	@Override
	public void sendHit(Map map) {
	}

	@Override
	public void requestAppOptOut(Analytics.AppOptOutCallback callback)
	{
	}

	@Override
	public void setDefaultTracker(Tracker tracker)
	{
		defaultTracker = tracker;
	}

	@Override
	public Tracker getDefaultTracker()
	{
		return defaultTracker;
	}

	@Override
	public void setAppOptOut(boolean optOut)
	{
	}

}
