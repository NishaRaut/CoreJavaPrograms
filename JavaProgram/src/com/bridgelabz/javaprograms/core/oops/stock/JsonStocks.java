package com.bridgelabz.javaprograms.core.oops.stock;

import java.util.List;

import com.bridgelabz.javaprograms.core.oops.Stock;

public class JsonStocks {
	private String JsonObjName;
	private List<Stock> stocks;

	public String getJsonObjName() {
		return JsonObjName;
	}
	public void setJsonObjName(String jsonObjName) {
		JsonObjName = jsonObjName;
	}
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
}
