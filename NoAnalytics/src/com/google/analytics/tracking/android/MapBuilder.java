package com.google.analytics.tracking.android;

public class MapBuilder {
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
		return paramName;
	}

	public MapBuilder set(String paramName, String paramValue) {
		return this;
	}

	public MapBuilder setAll(java.util.Map<String, String> params) {
		return this;
	}

	public MapBuilder setCampaignParamsFromUrl(String utmParams) {
		return this;
	}
}
