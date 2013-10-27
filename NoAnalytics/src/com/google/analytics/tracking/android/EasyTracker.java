package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;

import java.util.Map;

public class EasyTracker extends Tracker {
	private static final String NO_TRACKING_ID = "12345678";
	private static EasyTracker instance;
	private Tracker tracker = GoogleAnalytics.getInstance(null).getTracker(NO_TRACKING_ID);

	public static EasyTracker getInstance() {
		if (instance == null)
			instance = new EasyTracker();
		return instance;
	}

	public static EasyTracker getInstance(Context context) {
		if (instance == null)
			instance = new EasyTracker();
		return instance;
	}

	public static Tracker getTracker() {
		return getInstance().tracker;
	}

	public static void setResourcePackageName(String resourcePackageName) {

	}

	public void activityStart(Activity activity) {

	}

	public void activityStop(Activity activity) {

	}

	public void dispatch() {

	}

	@Deprecated
	public void dispatchLocalHits() {

	}

	public void send(Map<String, String> params) {

	}

	public void setContext(Context ctx) {

	}
}
