package app;

import app.command.CommandRunner;

public class CafeKioskApp {

	private final CommandRunner commandRunner = new CommandRunner();

	private CafeKioskApp() {}

	public static void run() {
		CafeKioskApp app = new CafeKioskApp();
		app.start();
	}

	private void start() {
		while (true) {
			try {
				commandRunner.init();
				commandRunner.run();
			} catch (IllegalArgumentException e) {
				System.out.println("잘못된 입력으로 3초 뒤 메인 메뉴판 화면으로 이동합니다.");
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
