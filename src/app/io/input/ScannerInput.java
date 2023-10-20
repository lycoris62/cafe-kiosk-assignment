package app.io.input;

import java.util.Scanner;

public class ScannerInput implements Input {

	private static final Scanner scanner = new Scanner(System.in);

	@Override
	public int read() {
		return scanner.nextInt();
	}
}
