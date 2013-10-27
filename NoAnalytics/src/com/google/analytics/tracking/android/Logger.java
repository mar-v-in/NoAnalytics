package com.google.analytics.tracking.android;

import android.util.Log;

public interface Logger {
	public enum LogLevel {
		VERBOSE, INFO, WARNING, ERROR
	}
	void verbose(String message);
	void info(String message);
	void warn(String message);
	void error(String message);
	void error(Exception exception);
	void setLogLevel(LogLevel level);
	LogLevel getLogLevel();
}
