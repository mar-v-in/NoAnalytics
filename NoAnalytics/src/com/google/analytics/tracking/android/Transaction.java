package com.google.analytics.tracking.android;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Transaction {
	private final String transactionId;
	private final String affiliation;
	private final long totalCostInMicros;
	private final long totalTaxInMicros;
	private final long shippingCostInMicros;
	private final String currencyCode;
	private final Map<String, Item> items;

	private Transaction(Builder builder) {
		transactionId = builder.transactionId;
		totalCostInMicros = builder.totalCostInMicros;
		affiliation = builder.affiliation;
		totalTaxInMicros = builder.totalTaxInMicros;
		shippingCostInMicros = builder.shippingCostInMicros;
		currencyCode = builder.currencyCode;
		items = new HashMap<String, Item>();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public long getTotalCostInMicros() {
		return totalCostInMicros;
	}

	public long getTotalTaxInMicros() {
		return totalTaxInMicros;
	}

	public long getShippingCostInMicros() {
		return shippingCostInMicros;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void addItem(Item item) {
		items.put(item.getSKU(), item);
	}

	public List<Item> getItems() {
		return new ArrayList(items.values());
	}

	public static final class Item {
		private final String SKU;
		private final String name;
		private final String category;
		private final long priceInMicros;
		private final long quantity;

		private Item(Builder builder) {
			SKU = builder.SKU;
			priceInMicros = builder.priceInMicros;
			quantity = builder.quantity;
			name = builder.name;
			category = builder.category;
		}

		public String getSKU() {
			return SKU;
		}

		public String getName() {
			return name;
		}

		public String getCategory() {
			return category;
		}

		public long getPriceInMicros() {
			return priceInMicros;
		}

		public long getQuantity() {
			return quantity;
		}

		public static final class Builder {

			private final String SKU;
			private final long priceInMicros;
			private final long quantity;
			private final String name;
			private String category;

			public Builder(String SKU, String name, long priceInMicros, long quantity) {
				category = null;
				this.SKU = SKU;
				this.name = name;
				this.priceInMicros = priceInMicros;
				this.quantity = quantity;
			}

			public Builder setProductCategory(String productCategory) {
				category = productCategory;
				return this;
			}

			public Item build() {
				return new Item(this);
			}
		}

	}

	public static final class Builder {

		private final String transactionId;
		private final long totalCostInMicros;
		private String affiliation;
		private long totalTaxInMicros;
		private long shippingCostInMicros;
		private String currencyCode;

		public Builder(String transactionId, long totalCostInMicros) {
			affiliation = null;
			totalTaxInMicros = 0L;
			shippingCostInMicros = 0L;
			currencyCode = null;
			this.transactionId = transactionId;
			this.totalCostInMicros = totalCostInMicros;
		}

		public Builder setAffiliation(String affiliation) {
			this.affiliation = affiliation;
			return this;
		}

		public Builder setTotalTaxInMicros(long totalTaxInMicros) {
			this.totalTaxInMicros = totalTaxInMicros;
			return this;
		}

		public Builder setShippingCostInMicros(long shippingCostInMicros) {
			this.shippingCostInMicros = shippingCostInMicros;
			return this;
		}

		public Builder setCurrencyCode(String currencyCode) {
			this.currencyCode = currencyCode;
			return this;
		}

		public Transaction build() {
			return new Transaction(this);
		}
	}
}
