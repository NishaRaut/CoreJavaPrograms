package com.bridgelabz.designpatterns.behavioral.visitor;

public class DmartCheckoutCounter {

	public static void main(String[] args) {
		ItemElement[] items = new ItemElement[] { new Book(20, "1234"), new Book(100, "5678"),
				new Fruit(10, 2, "Banana"), new Fruit(5, 5, "Apple") };

		int total = calculatePrice(items);
		System.out.println("Total Cost = " + total);
	}

	/**
	 * Computing the bill of each item to be paid
	 * @param items list of items bought
	 * @return total amount to be paid
	 */
	private static int calculatePrice(ItemElement[] items) {
		ShoppingCartVisitor visitor = new DmartShoppingCartVisitor();
		int sum = 0;
		for (ItemElement item : items) {
			sum = sum + item.accept(visitor);
		}
		return sum;
	}
}
