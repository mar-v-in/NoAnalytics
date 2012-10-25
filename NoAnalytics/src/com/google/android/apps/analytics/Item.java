package com.google.android.apps.analytics;

public class Item {

	public static class Builder {
		public Builder(String orderId, String itemSKU, double itemPrice,
				long itemCount) {

		}

		public Builder setItemName(String s) {
			return this;
		}

		public Builder setItemCategory(String s) {
			return this;
		}

		public Item build() {
			return new Item();
		}
	}

}
