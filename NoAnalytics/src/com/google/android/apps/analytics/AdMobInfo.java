package com.google.android.apps.analytics;

import java.util.Random;

public class AdMobInfo {
	public static AdMobInfo getInstance() {
		return instance;
	}

	public String getJoinId() {
		return null;
	}

	public int generateAdHitId() {
		adHitId = random.nextInt();
		return getAdHitId();
	}

	public void setAdHidId(int i) {
		adHitId = i;
	}

	public int getAdHitId() {
		return adHitId;
	}

	private int adHitId = generateAdHitId();
	private Random random = new Random();
	private static final AdMobInfo instance = new AdMobInfo();
}
