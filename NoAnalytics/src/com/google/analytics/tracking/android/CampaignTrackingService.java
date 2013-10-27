package com.google.analytics.tracking.android;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

public class CampaignTrackingService extends IntentService {

	private static final String DEFAULT_NAME = "com.google.analytics.tracking.android.CampaignTrackingService";

	public CampaignTrackingService() {
		this(DEFAULT_NAME);
	}

	public CampaignTrackingService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
	}

	public void processIntent(Context context, Intent intent) {

	}
}
