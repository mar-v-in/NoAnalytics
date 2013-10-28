package com.google.analytics.tracking.android;

import java.util.HashMap;
import java.util.Map;

public class MapBuilder {

	private Map<String, String> map = new HashMap<String, String>();

	public Map<String,String> build() {
		return map;
	}

	public static MapBuilder createAppView() {
		return new MapBuilder();
	}

	public static MapBuilder createEvent(String category, String action, String label,
										 Long value) {
		return new MapBuilder();
	}

	public static MapBuilder createException(String exceptionDescription, Boolean fatal) {
		return new MapBuilder();
	}

	public static MapBuilder createItem(String transactionId, String name, String sku,
										String category, Double price, Long quantity,
										String currencyCode) {
		return new MapBuilder();
	}

	public static MapBuilder createSocial(String network, String action, String target) {
		return new MapBuilder();
	}

	public static MapBuilder createTiming(String category, Long intervalInMilliseconds,
										  String name, String label) {
		return new MapBuilder();
	}

	public static MapBuilder createTransaction(String transactionId, String affiliation,
											   Double revenue, Double tax,
											   Double shipping, String currencyCode) {
		return new MapBuilder();
	}

	public String get(String paramName) {
		return map.get(paramName);
	}

	public MapBuilder set(String paramName, String paramValue) {
		map.put(paramName, paramValue);
		return this;
	}

	public MapBuilder setAll(Map<String, String> params) {
		map.putAll(params);
		return this;
	}

	public MapBuilder setCampaignParamsFromUrl(String utmParams) {
		return this;
	}
}
