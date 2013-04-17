package com.google.analytics.tracking.android;

public interface ExceptionParser {
	public abstract String getDescription(String s, Throwable throwable);
}
