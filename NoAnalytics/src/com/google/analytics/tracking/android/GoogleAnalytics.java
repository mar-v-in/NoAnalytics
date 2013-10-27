package com.google.analytics.tracking.android;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class GoogleAnalytics implements TrackerHandler, Analytics {
	private static final String TAG = "GoogleAnalytics";

	private static GoogleAnalytics instance;
	private boolean debug = false;
	private boolean dryRun = false;
	private Map<String, Tracker> trackers = new HashMap<String, Tracker>();
	private Tracker defaultTracker;
	private boolean optOut = false;

	private GoogleAnalytics(Context context) {
	}

	public static synchronized GoogleAnalytics getInstance(Context context) {
		if (instance == null) {
			instance = new GoogleAnalytics(context);
		}
		return instance;
	}

	@Override
	public void closeTracker(Tracker tracker) {
	}

	public void closeTracker(String name) {

	}

	@Override
	public boolean debugEnabled() {
		return isDebugEnabled();
	}

	public boolean getAppOptOut() {
		return optOut;
	}

	@Override
	public void setAppOptOut(boolean optOut) {
		this.optOut = optOut;
	}

	@Override
	public Tracker getDefaultTracker() {
		return defaultTracker;
	}

	@Override
	public void setDefaultTracker(Tracker tracker) {
		defaultTracker = tracker;
	}

	@Override
	public synchronized Tracker getTracker(String trackingId) {
		if (!trackers.containsKey(trackingId)) {
			Tracker tracker = new Tracker(trackingId, this);
			trackers.put(trackingId, tracker);
			if (defaultTracker == null) {
				defaultTracker = tracker;
			}
		}
		return trackers.get(trackingId);
	}

	public Tracker getTracker(String name, String trackingId) {
		if (!trackers.containsKey(trackingId)) {
			Tracker tracker = new Tracker(name, trackingId, this);
			trackers.put(trackingId, tracker);
			if (defaultTracker == null) {
				defaultTracker = tracker;
			}
		}
		return trackers.get(trackingId);
	}

	public boolean isDebugEnabled() {
		return debug;
	}

	public boolean isDryRunEnabled() {
		return dryRun;
	}

	@Override
	public void requestAppOptOut(AppOptOutCallback callback) {
	}

	@Override
	public void sendHit(Map map) {
	}

	@Override
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public void setDryRun(boolean dryRun) {
		this.dryRun = dryRun;
	}

	public Logger getLogger() {
		return DEFAULT_LOGGER;
	}

	public static Logger getDefaultLogger() {
		return DEFAULT_LOGGER;
	}

	private static Logger DEFAULT_LOGGER = new Logger() {
		private LogLevel level = LogLevel.VERBOSE;

		@Override
		public void verbose(String message) {
			Log.v(TAG, message);
		}

		@Override
		public void info(String message) {
			Log.i(TAG, message);
		}

		@Override
		public void warn(String message) {
			Log.w(TAG, message);
		}

		@Override
		public void error(String message) {
			Log.e(TAG, message);
		}

		@Override
		public void error(Exception exception) {
			Log.e(TAG, exception.toString());
		}

		@Override
		public void setLogLevel(LogLevel level) {
			this.level = level;
		}

		@Override
		public LogLevel getLogLevel() {
			return level;
		}
	};

}
