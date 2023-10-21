package app;

import app.command.CommandRunner;
import app.command.implement.OrderCancelCommand;
import app.command.implement.OrderCommand;
import app.command.implement.PurchaseCommand;
import app.command.implement.SalesRecordCommand;
import app.menu.Category;

public class CafeKioskApp {
	private final CommandRunner runner = new CommandRunner();

	private final int SALES_RECORD_NUMBER = 0;
	private final int MENU_START_NUMBER = 1;
	private final int MENU_END_NUMBER = Category.values().length;
	private final int ORDER_NUMBER = Category.values().length + 1;
	private final int ORDER_CANCEL_NUMBER = Category.values().length + 2;

	private CafeKioskApp() {}

	public static void run() {
		CafeKioskApp app = new CafeKioskApp();
		app.start();
	}

	private void start() {
		while (true) {
			try {
				int menuNumber = runner.init();
				setCommand(menuNumber);
				runner.run();
			} catch (IllegalArgumentException e) {
				System.out.println("잘못된 입력으로 3초 뒤 메인 메뉴판 화면으로 이동합니다.");
				waitForThreeSeconds();
			}
		}
	}

	private void setCommand(int menuNumber) {
		if (menuNumber == SALES_RECORD_NUMBER) {
			runner.setCommand(new SalesRecordCommand());
		} else if (MENU_START_NUMBER <= menuNumber && menuNumber <= MENU_END_NUMBER) {
			runner.setCommand(new PurchaseCommand(menuNumber));
		} else if (menuNumber == ORDER_NUMBER) {
			runner.setCommand(new OrderCommand());
		} else if (menuNumber == ORDER_CANCEL_NUMBER) {
			runner.setCommand(new OrderCancelCommand());
		}
	}

	private void waitForThreeSeconds() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ignored) {
		}
	}
}
