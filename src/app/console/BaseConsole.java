package app.console;

import java.util.Scanner;

public class BaseConsole implements Console {

	private final Scanner scanner = new Scanner(System.in);

	public BaseConsole() {
	}

	@Override
	public int request() {
		return scanner.nextInt();
	}
}
