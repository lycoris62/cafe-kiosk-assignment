package app;

public class CafeKioskApp {
	private final String reader;

	private CafeKioskApp(String  reader) {
		this.reader = reader;
	}

	public static void run() {
		CafeKioskApp app = new CafeKioskApp("scanner");
		app.start();
	}

	private void start() {
		while (true) {
			try {

			} catch (IllegalArgumentException e) {
				System.out.println("잘못된 입력으로 메인 메뉴판 화면으로 이동합니다.");
			}
		}
	}
}
