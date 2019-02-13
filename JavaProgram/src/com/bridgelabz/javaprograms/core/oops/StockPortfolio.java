package com.bridgelabz.javaprograms.core.oops;
import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.javaprograms.core.util.Utility;

public class StockPortfolio {
	private List<Stock> stocks;
	/**
	 * gives the number of stocks
	 * @return total number of stocks in the share market
	 */
	public double getTotalStocks() {
		long totalStocks = 0L;
		for (int i = 0; i < stocks.size(); i++) {
			totalStocks += stocks.get(i).getNumberOfShares();
		}
		return totalStocks;
	}

	/**
	 * gives total stock value of all the stocks in the share market
	 * @return total stock value of all the stocks
	 */
	public double getTotalStockValue() {
		long totalStockValue = 0L;
		for (int i = 0; i < stocks.size(); i++) {
			totalStockValue += stocks.get(i).getPrice() * stocks.get(i).getNumberOfShares();
		}
		return totalStockValue;
	}

	/**
	 * get all the stocks
	 * @return list of stocks
	 */
	public List<Stock> getStocks() {
		return stocks;
	}

	/**
	 * set the stocks
	 * @param stocks list of stocks
	 */
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	/**
	 * Testing the StockPortfolio class
	 * @param args
	 */
	public static void main(String[] args) {
		List<Stock> stocks =  new ArrayList<>();
		
		System.out.println("Enter the number of stocks...!");
		int numOfStocks = Utility.getPositiveInt();
		//get the 'numOfStocks' stocks details
		int count = 1;
		while(count <= numOfStocks) {
			System.out.println("Enter the Stock Name...!");
			String name = Utility.getString();
			System.out.println("Enter number of shares...!");
			int  numOfShares = Utility.getPositiveInt();
			System.out.println("Enter the share price...!");
			double price = Utility.getDouble();
			Stock stock = new Stock();
			stock.setName(name);
			stock.setNumberOfShares(numOfShares);
			stock.setPrice(price);
			stocks.add(stock);
			count++;
		}

		StockPortfolio portfolio = new StockPortfolio();
		portfolio.setStocks(stocks);
		//Print the stock portfolio
		System.out.println("SL No \t Name\t\t Total_Stocks \t Share_Price \t Stock_Value");
		System.out.println("=================================================================================");
		count = 1;
		for(Stock s : portfolio.getStocks()) {
        	System.out.println(count+"\t "+s.getName()+"\t\t\t"+s.getNumberOfShares()+"   \t"+s.getPrice()+"  \t\t"+s.getPrice()*s.getNumberOfShares());
        }
		System.out.println("\n Total Stock Value = "+portfolio.getTotalStockValue());
	}
}
