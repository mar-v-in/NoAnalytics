package com.google.analytics.tracking.android;

public abstract class ServiceManager {
	@Deprecated
	abstract void dispatchLocalHits();

	@Deprecated
	abstract void setForceLocalDispatch();

	@Deprecated
	abstract void setLocalDispatchPeriod(int dispatchPeriodInSeconds);
}
