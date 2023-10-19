package app;

import app.io.input.Input;
import app.io.input.ScannerInput;

public class CafeKioskApp {
	private final Input input;

	public CafeKioskApp(Input input) {
		this.input = input;
	}

	public static void run() {
		CafeKioskApp app = new CafeKioskApp(new ScannerInput());
		app.start();
	}

	private void start() {
		while (true) {
			try {
				String str = input.read();
				System.out.println("str = " + str);
			} catch (IllegalArgumentException e) {
				System.out.println("잘못된 입력으로 메인 메뉴판 화면으로 이동합니다.");
			}
		}
	}
}
