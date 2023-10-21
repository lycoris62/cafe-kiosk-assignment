package app.command;

import app.io.console.Console;
import app.io.console.ConsoleFactory;

public abstract class Command {

	protected Console console;
	protected ConsoleFactory consoleFactory = new ConsoleFactory();
	public abstract void execute();
}
