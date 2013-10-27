package com.google.analytics.tracking.android;

public class Log {
	public static void e(String msg) {
		GoogleAnalytics.getDefaultLogger().error(msg);
	}

	public static void e(Exception e) {
		GoogleAnalytics.getDefaultLogger().error(e);
	}

	public static void i(String msg) {
		GoogleAnalytics.getDefaultLogger().info(msg);
	}

	public static void v(String msg) {
		GoogleAnalytics.getDefaultLogger().verbose(msg);
	}

	public static void w(String msg) {
		GoogleAnalytics.getDefaultLogger().warn(msg);
	}

	public static boolean isVerbose() {
		return GoogleAnalytics.getDefaultLogger().getLogLevel() == Logger.LogLevel.VERBOSE;
	}
}
