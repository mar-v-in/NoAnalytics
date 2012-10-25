package com.google.android.apps.analytics;

interface Dispatcher {
	public static interface Callbacks {

		public abstract void hitDispatched(long l);

		public abstract void dispatchFinished();
	}

	public abstract void dispatchHits(Hit ahit[]);

	public abstract void init(Callbacks callbacks);

	public abstract void stop();

	public abstract void setDryRun(boolean flag);

	public abstract boolean isDryRun();
}