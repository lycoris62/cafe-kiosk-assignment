package app;

import app.command.CommandRunner;
import app.command.implement.OrderCancelCommand;
import app.command.implement.OrderCommand;
import app.command.implement.PurchaseCommand;
import app.command.implement.SalesRecordCommand;
import app.io.console.Console;
import app.io.console.ConsoleFactory;
import app.io.input.ScannerInput;
import app.menu.Category;

public class CafeKioskApp {
	private final ConsoleFactory consoleFactory;
	private final CommandRunner runner = new CommandRunner();

	private final int SALES_RECORD_NUMBER = 0;
	private final int MENU_START_NUMBER = 1;
	private final int MENU_END_NUMBER = Category.values().length;
	private final int ORDER_NUMBER = Category.values().length + 1;
	private final int ORDER_CANCEL_NUMBER = Category.values().length + 2;

	private CafeKioskApp() {
		this.consoleFactory = new ConsoleFactory(new ScannerInput());
	}

	public static void run() {
		CafeKioskApp app = new CafeKioskApp();
		app.start();
	}

	private void start() {
		while (true) {
			try {
				Console console = consoleFactory.getWelcome();
				int menuNumber = console.request();
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
			runner.setCommand(new SalesRecordCommand(consoleFactory.getRecord()));
		} else if (MENU_START_NUMBER <= menuNumber && menuNumber <= MENU_END_NUMBER) {
			runner.setCommand(new PurchaseCommand(consoleFactory, menuNumber));
		} else if (menuNumber == ORDER_NUMBER) {
			runner.setCommand(new OrderCommand(consoleFactory.getOrderProcess()));
		} else if (menuNumber == ORDER_CANCEL_NUMBER) {
			runner.setCommand(new OrderCancelCommand(consoleFactory.getOrderCancel()));
		}
	}

	private void waitForThreeSeconds() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ignored) {
		}
	}
}
