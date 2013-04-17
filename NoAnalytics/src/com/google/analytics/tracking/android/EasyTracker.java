package com.google.analytics.tracking.android;

import android.app.Activity;
import android.content.Context;

public class EasyTracker {
	private static EasyTracker instance;
	private Tracker tracker = new Tracker();

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
