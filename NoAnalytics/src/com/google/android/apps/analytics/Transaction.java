package com.google.android.apps.analytics;

public class Transaction {

	public static class Builder {
		public Builder(String orderId, double totalCost) {
		}

		public Builder setStoreName(String s) {
			return this;
		}

		public Builder setTotalTax(double d) {
			return this;
		}

		public Builder setShippingCost(double d) {
			return this;
		}

		public Transaction build() {
			return new Transaction();
		}
	}

}
