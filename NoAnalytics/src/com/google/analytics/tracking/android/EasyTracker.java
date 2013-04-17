package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;

public class EasyTracker {
	// TODO: We should read applications real trackingId, else it could cause problems...

	private static final String NO_TRACKING_ID = "12345678";
	private static EasyTracker instance;
	private Tracker tracker = GoogleAnalytics.getInstance(null).getTracker(NO_TRACKING_ID);

	public static EasyTracker getInstance() {
		if (instance == null)
			instance = new EasyTracker();
		return instance;
	}

	public static Tracker getTracker() {
		return getInstance().tracker;
	}

	public void setContext(Context ctx) {

	}

	public void activityStart(Activity activity) {

	}

	public void activityStop(Activity activity) {

	}

	public void dispatch() {

	}
}
