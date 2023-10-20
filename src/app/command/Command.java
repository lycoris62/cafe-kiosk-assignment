package app.command;

import app.io.console.Console;

public abstract class Command {

	protected Console console;
	public abstract void execute();
}
