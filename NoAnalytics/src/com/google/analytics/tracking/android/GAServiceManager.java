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
	void dispatchLocalHits() {
	}

	@Override
	void setForceLocalDispatch() {
	}

	@Override
	void setLocalDispatchPeriod(int dispatchPeriodInSeconds) {
	}
}
