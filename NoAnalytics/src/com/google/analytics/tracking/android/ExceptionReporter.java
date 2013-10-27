package com.google.analytics.tracking.android;

import android.content.Context;

public class ExceptionReporter implements Thread.UncaughtExceptionHandler {

	private ExceptionParser exceptionParser;

	public ExceptionReporter(Tracker tracker, ServiceManager serviceManager,
							 Thread.UncaughtExceptionHandler originalHandler, Context context) {

	}

	public ExceptionParser getExceptionParser() {
		if (exceptionParser == null) {
			exceptionParser = new ExceptionParser() {
				@Override
				public String getDescription(String threadName, Throwable t) {
					return threadName;
				}
			};
		}
		return exceptionParser;
	}

	public void setExceptionParser(ExceptionParser exceptionParser) {
		this.exceptionParser = exceptionParser;
	}

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {

	}
}
