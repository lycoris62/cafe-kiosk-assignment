package app.menu;

import app.util.InputUtil;

public class MenuController {

	private final MenuView menuView;

	public MenuController(MenuView menuView) {
		this.menuView = menuView;
	}

	public int getMenuNumber() {
		menuView.showMainMenuMessage();

		return InputUtil.readMenuNumber();
	}

	public int getProductNumber(int categoryNumber) {
		menuView.showCategoryMenuMessage(categoryNumber);

		return InputUtil.readProductNumber(categoryNumber);
	}
}
