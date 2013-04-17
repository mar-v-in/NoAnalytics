package com.google.analytics.tracking.android;

import java.util.Map;

interface TrackerHandler {
	public void closeTracker(Tracker tracker);

	public void sendHit(Map<String, String> map);
}
