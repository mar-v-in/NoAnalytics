package com.google.analytics.tracking.android;

public interface ExceptionParser {
	String getDescription(String threadName, Throwable t);
}
