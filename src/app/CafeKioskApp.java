package app;

import java.util.ArrayList;
import java.util.List;

import app.io.console.Console;
import app.io.console.decorator.ConsoleFactory;
import app.io.input.ScannerInput;
import app.menu.Category;
import app.menu.MenuChoiceProcessor;
import app.menu.Order;

public class CafeKioskApp {
	private final List<Order> cart = new ArrayList<>();
	private final List<Order> salesRecord = new ArrayList<>();
	private final MenuChoiceProcessor menuChoiceProcessor;
	private static int waitingNumber = 1;
	private Console console;
	private final ConsoleFactory consoleFactory;

	private final int SALES_RECORD_NUMBER = 0;
	private final int MENU_START_NUMBER = 1;
	private final int MENU_END_NUMBER = Category.values().length;
	private final int ORDER_NUMBER = Category.values().length + 1;
	private final int ORDER_CANCEL_NUMBER = Category.values().length + 2;

	public CafeKioskApp() {
		this.menuChoiceProcessor = new MenuChoiceProcessor();
		this.consoleFactory = new ConsoleFactory(new ScannerInput());
	}

	public static void run() {
		CafeKioskApp app = new CafeKioskApp();
		app.start();
	}

	private void start() {
		while (true) {
			try {
				console = consoleFactory.getWelcome();
				int menuNumber = console.request();

				if (menuNumber == SALES_RECORD_NUMBER) {
					console = consoleFactory.getRecord(salesRecord);
					console.request();
				} else if (MENU_START_NUMBER <= menuNumber && menuNumber <= MENU_END_NUMBER) {
					console = consoleFactory.getCategoryMenu(menuNumber);
					int itemNumber = console.request();

					console = consoleFactory.getPurchase(menuNumber, itemNumber);
					int purchaseNumber = console.request();

					if (purchaseNumber == 1) {
						Order order = menuChoiceProcessor.choose(menuNumber, itemNumber);
						System.out.println(order.getItemList().get(0).getName() + " 가 장바구니에 추가되었습니다.");

						cart.add(order);
					}
				} else if (menuNumber == ORDER_NUMBER) {
					if (cart.isEmpty()) {
						System.out.println("장바구니가 비어있습니다.");
						continue;
					}

					console = consoleFactory.getOrderProcess(cart);
					int checkNumber = console.request();

					if (checkNumber == 2) {
						continue;
					}

					System.out.println("주문이 완료되었습니다!\n");
					System.out.printf("""
						대기번호는 [ %d ] 번 입니다.
						(3초후 메뉴판으로 돌아갑니다.)
						""", waitingNumber++);

					salesRecord.addAll(cart);
					cart.clear();
					waitForThreeSeconds();
				} else if (menuNumber == ORDER_CANCEL_NUMBER) {
					console = consoleFactory.getOrderCancel();
					int checkNumber = console.request();
					if (checkNumber == 1) {
						cart.clear();
						System.out.println("진행하던 주문이 취소되었습니다.\n");
					}
				}
			} catch (IllegalArgumentException e) {
				System.out.println("잘못된 입력으로 3초 뒤 메인 메뉴판 화면으로 이동합니다.\n");
				waitForThreeSeconds();
			}
		}
	}

	private void waitForThreeSeconds() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ignored) {
		}
	}
}
