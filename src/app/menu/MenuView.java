package app.menu;

import java.util.Arrays;

import app.domain.Category;
import app.domain.Product;

public class MenuView {

	private static final int ORDER_NUMBER = Category.size() + 1;
	private static final int ORDER_CANCEL_NUMBER = Category.size() + 2;

	private static final String initMessage = """
		  
		"오십이도에 오신걸 환영합니다."
		아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.
		""";

	public void showMainMenuMessage() {
		System.out.println(initMessage);
		System.out.println("[ 오십이도 MENU ]");
		showAllCategory();
		System.out.printf("%d. %-20s | %-20s\n", ORDER_NUMBER, "Order", "장바구니를 확인 후 주문합니다.");
		System.out.printf(String.format("%d. %-20s | %-20s\n", ORDER_CANCEL_NUMBER, "Cancel", "진행중인 주문을 취소합니다."));
	}

	private void showAllCategory() {
		Arrays.stream(Category.values())
			.map(Category::toString)
			.forEach(System.out::println);
	}

	public void showCategoryMenuMessage(int categoryNumber) {
		System.out.println(initMessage);
		System.out.printf(String.format("[ %s MENU ]\n", Category.getCategoryName(categoryNumber)));
		showProductsInCategory(categoryNumber);
	}

	private void showProductsInCategory(int categoryNumber) {
		Category.getCategoryItems(categoryNumber)
			.stream()
			.map(Product::toString)
			.forEach(System.out::println);
	}
}
