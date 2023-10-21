package app.console;

import app.console.input.Input;

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
