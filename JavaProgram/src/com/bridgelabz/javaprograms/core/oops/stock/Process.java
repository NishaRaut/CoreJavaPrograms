package com.bridgelabz.javaprograms.core.oops.stock;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bridgelabz.javaprograms.core.oops.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Process {
	ObjectMapper mapper = new ObjectMapper();
    
	public String sellShares(String stockAccName, String companyName, int numOfShares, double sellingPrice) {
		String result = null;
		Date date = null;
		List<StockAccount> allStockAccounts = getAllStockAccounts();
		StockAccount stockAccount = allStockAccounts.stream().filter(s -> s.getName().equals(stockAccName)).findFirst()
				.get();
		List<CompanyShare> shares = stockAccount.getCompanyShares();
		CompanyShare stockToSell = shares.stream().filter(s -> s.getName().equals(companyName)).findFirst().get();
		if (numOfShares > stockToSell.getNumberOfShares()) {
			result = "Expected number of shares not available...!";
			return result;
		}
		date = new Date(System.currentTimeMillis());//transaction date
		if (stockToSell.getNumberOfShares() == numOfShares)// sell and remove from list
		{ 
			shares.remove(stockToSell);
		} else {// deduct the number of shares from the stock
			stockToSell.setNumberOfShares(stockToSell.getNumberOfShares() - numOfShares);
			stockToSell.setTransactionDate(date);
		}
		// update the company stock and stock list
		List<Stock> stocks = getAllStocks();
		Stock stockToUpdate = stocks.stream().filter(s -> s.getName().equals(companyName)).findFirst().get();
		stockToUpdate.setNumberOfShares(stockToUpdate.getNumberOfShares() + numOfShares);
		// update to StocksList
		updateStocks(stocks);
		// update to the StockAccounts
		updateStockAccounts(allStockAccounts);
		Transaction tr = new Transaction();
		tr.setStockAccountName(stockAccName);
		tr.setStockName(companyName);
		tr.setTransactionDate(date);
		tr.setType(2);
		addTransaction(tr);
		return result = "SUCCESS";
	}

	@SuppressWarnings("unlikely-arg-type")
	public String buyShares(String stockAccName, String companyName, int numOfShares) {
		String result = null;
		List<Stock> stocks = getAllStocks();
		Stock stockToBuy = stocks.stream().filter(s -> s.getName().equals(companyName)).findFirst().get();
		if (numOfShares > stockToBuy.getNumberOfShares()) {
			result = "Expected number of shares not available...!";
			return result;
		}
		double amount = numOfShares * stockToBuy.getPrice();
		List<StockAccount> stockAccounts = getAllStockAccounts();
		StockAccount buyer = stockAccounts.stream().filter(sa -> sa.getName().equals(stockAccName)).findFirst().get();
		if (buyer.getBalance() < amount) {
			result = "Account Doesn't Have Sufficient balance to buy..!";
			return result;
		}
		// now can buy the stocks
		buyer.buy(amount, companyName);
		List<CompanyShare> buyerStocksList = buyer.getCompanyShares();
		// update the existing company share of the buyer
		if (buyerStocksList.stream().filter(s -> s.equals(companyName)).findFirst().isPresent()) {
			CompanyShare oldShare = buyerStocksList.stream().filter(s -> s.equals(companyName)).findFirst().get();
			oldShare.setNumberOfShares(oldShare.getNumberOfShares() + numOfShares);
		}
		// add a new company share to the buyer stock list
		else {
			CompanyShare share = new CompanyShare();
			share.setName(companyName);
			share.setNumberOfShares(numOfShares);
			Date date = new Date(System.currentTimeMillis());
			share.setTransactionDate(date);
			buyerStocksList.add(share);
		}
		// update the company stock and stock list
		stockToBuy.setNumberOfShares(stockToBuy.getNumberOfShares() - numOfShares);
		// update to StocksList
		updateStocks(stocks);
		// update to the StockAccounts
		updateStockAccounts(stockAccounts);
		Date date = new Date(System.currentTimeMillis());
		Transaction tr = new Transaction();
		tr.setStockAccountName(stockAccName);
		tr.setStockName(companyName);
		tr.setTransactionDate(date);
		tr.setType(1);
		addTransaction(tr);
		return result = "SUCCESS";
	}

	public List<StockAccount> getAllStockAccounts() {
		File file = new File("resource/stock/stockAccounts.json");
		List<StockAccount> stocAccounts = null;
		try {
			JsonAccounts jsonData = mapper.readValue(file, JsonAccounts.class);
			stocAccounts = jsonData.getStockAccounts();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stocAccounts;
	}

	/**
	 * creates a new StockAccount
	 * 
	 * @param name    name of the account holder
	 * @param balance initial balance
	 * @return SUCCESS if account created else some error message
	 */
	public String addStockAccount(String name, Double balance) {
		String result = "SUCCESS";// variable to return result of the function

		StockAccount newAccount = new StockAccount();
		newAccount.setName(name);
		newAccount.setBalance(balance);
		newAccount.setCompanyShares(new ArrayList<CompanyShare>());

		// get previous data from the file
		JsonAccounts jsonData = null;
		List<StockAccount> stockAccounts = null;

		File file = new File("resource/stock/stockAccounts.json");
		try {
			if (file.length() == 0) {// empty file
				stockAccounts = new ArrayList<>();
				jsonData = new JsonAccounts();
				jsonData.setNameForJson("StockAccounts");
				jsonData.setStockAccounts(stockAccounts);
			} else {
				jsonData = mapper.readValue(file, JsonAccounts.class);
				stockAccounts = jsonData.getStockAccounts();
			}
			stockAccounts.add(newAccount);
			// write back to the file
			mapper.writeValue(file, jsonData);
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	/**
	 * create a new Stock
	 * 
	 * @param name           name of the company
	 * @param numberOfShares no. of shares
	 * @param price          price of each share
	 * @return SUCCESS if account created else some error message
	 */
	public String addStock(String name, int numberOfShares, double price) {

		String result = "SUCCESS";// variable to return result of the function

		Stock newStock = new Stock();
		newStock.setName(name);
		newStock.setNumberOfShares(numberOfShares);
		newStock.setPrice(price);
		newStock.setSymbol(name.charAt(0) + "" + name.charAt(name.length() - 1));

		// get previous data from the file
		JsonStocks jsonData = null;
		List<Stock> stocks = null;
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("resource/stock/stocks2.json");
		try {
			if (file.length() == 0) {// empty file
				stocks = new ArrayList<>();
				jsonData = new JsonStocks();
				jsonData.setJsonObjName("stocks");
				jsonData.setStocks(stocks);
			} else {
				jsonData = mapper.readValue(file, JsonStocks.class);
				stocks = jsonData.getStocks();
			}
			stocks.add(newStock);
			// write back to the file
			mapper.writeValue(file, jsonData);
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	public String isStockAccountExists(String stockAccountName) {
		String result;
		File file = new File("resource/stock/stockAccounts.json");
		try {
			JsonAccounts jsonData = mapper.readValue(file, JsonAccounts.class);
			if (jsonData == null)
				result = "false";
			else if (jsonData.getStockAccounts().stream().filter(a -> a.getName().equals(stockAccountName.trim()))
					.findFirst().isPresent())
				result = "true";
			else
				result = "false";
		} catch (IOException e) {
			e.printStackTrace();
			result = e.getMessage();
		}
		return result;
	}

	/**
	 * chesks the stocks are there are not
	 * 
	 * @return true if stocks are there else false
	 */
	public boolean areStocksExist() {
		File file = new File("resource/stock/stocks2.json");
		if (file.length() == 0)
			return false;
		else
			return true;
	}

	/**
	 * prints all the available stocks
	 */
	public void printStocks() {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("resource/stock/stocks2.json");
		try {
			JsonStocks jsonData = mapper.readValue(file, JsonStocks.class);
			System.out.println("Stock Name \t Shares \t Price");
			System.out.println("----------------------------------------------------------");
			for (Stock s : jsonData.getStocks()) {
				System.out.println(s.getName() + "\t " + s.getNumberOfShares() + "\t " + s.getPrice());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * checks a stock account has the stocks or not
	 * 
	 * @param stockAccountName name of the StockAccount
	 * @return true or false
	 */
	public boolean isStockAccountHasStocks(String stockAccountName) {
		JsonAccounts jsonData = null;
		List<StockAccount> stockAccounts = null;
		boolean result = false;
		File file = new File("resource/stock/stockAccounts.json");
		try {
			jsonData = mapper.readValue(file, JsonAccounts.class);
			stockAccounts = jsonData.getStockAccounts();
			if (stockAccounts.size() == 0)
				result = false;
			else
				result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Stock> getAllStocks() {
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("resource/stock/stocks2.json");
		List<Stock> stocks = null;
		try {
			JsonStocks jsonData = mapper.readValue(file, JsonStocks.class);
			stocks = jsonData.getStocks();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stocks;
	}

	public void updateStocks(List<Stock> stocks) {
		File file = new File("resource/stock/stocks2.json");
		JsonStocks jsonData = new JsonStocks();
		jsonData.setJsonObjName("stocks");
		jsonData.setStocks(stocks);
		try {
			mapper.writeValue(file, jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateStockAccounts(List<StockAccount> stockAccounts) {
		File file = new File("resource/stock/stockAccounts.json");
		JsonAccounts jsonData = new JsonAccounts();
		jsonData.setNameForJson("StockAccounts");
		jsonData.setStockAccounts(stockAccounts);
		try {
			mapper.writeValue(file, jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printStocksOfStockAccount(String stockAccountName) {
		StockAccount stockAccount = getAllStockAccounts().stream().filter(s -> s.getName().equals(stockAccountName))
				.findFirst().get();
		List<CompanyShare> shares = stockAccount.getCompanyShares();
		System.out.println("Name \t\t No.of Stocks");
		System.out.println("---------------------------------------------------------");
		for (CompanyShare cs : shares) {
			System.out.println(cs.getName() + "\t\t" + cs.getNumberOfShares());
		}
	}
	
	public void addTransaction(Transaction transaction) {
		List<Transaction> transactions = getAllTransactiosn();
		if(transactions == null) {
			transactions = new ArrayList<Transaction>();
		}
		transactions.add(transaction);
		//write to the transactions file
		TransactionList transList = new TransactionList();
		transList.setTransactions(transactions);
		ObjectMapper mapper = new ObjectMapper();
		File file = new File("resource/stock/transactions.json");
		try {
			mapper.writeValue(file, transList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Transaction> getAllTransactiosn(){
		File file = new File("resource/stock/transactions.json");
		if(!file.exists() || file.length() == 0) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		TransactionList transactions = null;
		try {
			transactions = mapper.readValue(file, TransactionList.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transactions.getTransactions();
	}
	
	public void printTransactions() {
		List<Transaction> allTransactions = getAllTransactiosn();
		System.out.println("Transactions Details...");
		System.out.println("-----------------------------------------------------------");
		System.out.println("StockAccountName \t StockName \t Date \t Transaction_Type");
		System.out.println("------------------------------------------------------------");
		if(allTransactions == null || allTransactions.size() == 0)
			System.out.println("No transactions happened yet...!");
		else {
			for(Transaction tr : allTransactions) {
				System.out.println(tr.getStockAccountName()+"\t"+tr.getStockName()+"\t"+tr.getTransactionDate()+"\t"+tr.getType());
			}
		}
	}
}
