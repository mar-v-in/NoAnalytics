package com.google.analytics.tracking.android;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

public class GoogleAnalytics implements TrackerHandler {
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

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public boolean isDebugEnabled() {
		return debug;
	}

	public synchronized Tracker getTracker(String trackingId) {
		if (!trackers.containsKey(trackingId)) {
			Tracker tracker = new Tracker(trackingId, this);
			trackers.put(trackingId, tracker);
			if (defaultTracker == null) {
				defaultTracker = tracker;
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
}
