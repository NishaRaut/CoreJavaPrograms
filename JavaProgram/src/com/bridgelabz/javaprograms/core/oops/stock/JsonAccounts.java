package com.bridgelabz.javaprograms.core.oops.stock;

import java.util.List;

public class JsonAccounts {
	private String nameForJson;
	private List<StockAccount> stockAccounts;
	
	public String getNameForJson() {
		return nameForJson;
	}

	public void setNameForJson(String nameForJson) {
		this.nameForJson = nameForJson;
	}

	public void setStockAccounts(List<StockAccount> accounts) {
		this.stockAccounts = accounts;
	}

	public List<StockAccount> getStockAccounts() {
		return this.stockAccounts;
	}
}
