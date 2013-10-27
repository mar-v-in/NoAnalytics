package com.google.analytics.tracking.android;

import android.content.Context;

import java.util.Collection;

public class StandardExceptionParser implements ExceptionParser {

	public StandardExceptionParser(Context context, Collection<String> additionalPackages) {

	}

	@Override
	public String getDescription(String threadName, Throwable t) {
		return threadName;
	}

	public void setIncludedPackages(Context context, Collection<String> additionalPackages) {

	}
}
