package app.command;

import app.console.Console;
import app.console.ConsoleFactory;

public abstract class Command {

	protected Console console;
	protected ConsoleFactory consoleFactory = new ConsoleFactory();
	public abstract void execute();
}
