package app.io.console;

import app.io.console.input.Input;

public class BaseConsole implements Console {

	private final Input input;

	public BaseConsole(Input input) {
		this.input = input;
	}

	@Override
	public int request() {
		return input.read();
	}
}
