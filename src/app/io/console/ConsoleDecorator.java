package app.io.console;

public abstract class ConsoleDecorator implements Console {

	private final Console console;

	public ConsoleDecorator(Console console) {
		this.console = console;
	}

	@Override
	public int request() {
		return console.request();
	}
}
