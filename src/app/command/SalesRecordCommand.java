package app.command;

import app.io.console.Console;

public class SalesRecordCommand extends Command {

	private final Console console;

	public SalesRecordCommand(Console console) {
		this.console = console;
	}

	@Override
	public void execute() {
		console.request();
	}
}
