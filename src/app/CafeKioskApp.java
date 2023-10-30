package app;

import app.domain.Category;
import app.menu.MenuController;
import app.menu.MenuView;
import app.order.Cart;
import app.order.OrderController;
import app.order.OrderView;
import app.order.SalesRecord;

public final class CafeKioskApp { // 상속 불가능

	// 메뉴 담당 컨트롤러
	private static final MenuController menuController = new MenuController(new MenuView());
	// 주문 담당 컨트롤러
	private static final OrderController orderController = new OrderController(new OrderView(), new Cart(), new SalesRecord());

	private static final int SALES_RECORD_NUMBER = 0;
	private static final int MENU_START_NUMBER = 1;
	private static final int MENU_END_NUMBER = Category.size();
	private static final int ORDER_NUMBER = Category.size() + 1;
	private static final int ORDER_CANCEL_NUMBER = Category.size() + 2;

	private CafeKioskApp() {} // 생성 불가능

	public static void run() { // 유일한 진입점
		while (true) { // 아래 로직을 계속 반복
			int menuNumber = menuController.getMenuNumber(); // 메뉴 번호를 입력 받음

			if (menuNumber == SALES_RECORD_NUMBER) { // 총 판매 실적 조회
				orderController.showAllSalesRecord();
			} else if (MENU_START_NUMBER <= menuNumber && menuNumber <= MENU_END_NUMBER) { // 카테고리 선택
				int productNumber = menuController.getProductNumber(menuNumber); // 카테고리 내 상품 선택
				orderController.putCart(menuNumber, productNumber); // 장바구니 추가
			} else if (menuNumber == ORDER_NUMBER) { // 주문 진행
				orderController.order();
			} else if (menuNumber == ORDER_CANCEL_NUMBER) { // 주문 취소
				orderController.cancelOrder();
			}
		}
	}
}
