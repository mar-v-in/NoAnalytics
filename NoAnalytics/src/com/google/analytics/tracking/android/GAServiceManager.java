package com.google.analytics.tracking.android;

public class GAServiceManager extends ServiceManager {

	private static GAServiceManager instance;

	public static synchronized GAServiceManager getInstance() {
		if (instance == null) {
			instance = new GAServiceManager();
		}
		return instance;
	}

	@Override
	public void dispatchLocalHits() {
	}

	@Override
	public void setForceLocalDispatch() {
	}

	@Override
	public void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
	}
}
