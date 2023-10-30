package app.menu;

import java.util.Arrays;
import java.util.stream.Collectors;

import app.domain.Category;

public class MenuView {

	private static final String initMessage = """
		  
		"오십이도에 오신걸 환영합니다."
		아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.
		""";

	public void showMainMenuMessage() {
		System.out.println(initMessage);
		System.out.println("[ 오십이도 MENU ]");
		System.out.println(getCategoryView());
		System.out.printf("%d. %-20s | %-20s\n", Category.size() + 1, "Order", "장바구니를 확인 후 주문합니다.");
		System.out.printf(String.format("%d. %-20s | %-20s\n", Category.size() + 2, "Cancel", "진행중인 주문을 취소합니다."));
	}

	private String getCategoryView() {
		return Arrays.stream(Category.values())
			.map(category -> category.toString() + "\n")
			.collect(Collectors.joining());
	}

	public void showCategoryMenuMessage(int categoryNumber) {
		System.out.println(initMessage);
		System.out.printf(String.format("[ %s MENU ]\n", Category.getCategoryName(categoryNumber)));
		System.out.println(getProductView(categoryNumber));
	}

	private String getProductView(int categoryNumber) {
		return Category.getCategoryItems(categoryNumber)
			.stream()
			.map(product -> product.toString() + "\n")
			.collect(Collectors.joining());
	}
}
