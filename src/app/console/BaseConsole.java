package app.console;

import app.console.input.Input;
import app.console.input.ScannerInput;

public class BaseConsole implements Console {

	private final Input input = new ScannerInput();

	public BaseConsole() {
	}

	@Override
	public int request() {
		return input.read();
	}
}
