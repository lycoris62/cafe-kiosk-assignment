package app.menu;

import app.util.InputUtil;

/**
 * 메뉴 관련 요청을 처리하는 객체
 */
public class MenuController {

	private final MenuView menuView;

	public MenuController(MenuView menuView) {
		this.menuView = menuView;
	}

	/**
	 * 메인 화면을 출력하고 메뉴 번호를 입력 받는 메서드
	 */
	public int getMenuNumber() {
		menuView.showMainMenuMessage();

		return InputUtil.readMenuNumber();
	}

	/**
	 * 특정 카테고리의 상품 메뉴 화면을 출력하고 상품 번호를 입력 받는 메서드
	 * @param categoryNumber
	 */
	public int getProductNumber(int categoryNumber) {
		menuView.showCategoryMenuMessage(categoryNumber);

		return InputUtil.readProductNumber(categoryNumber);
	}
}
