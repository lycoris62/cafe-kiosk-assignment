package app.command.implement;

import app.command.Command;
import app.console.Console;
import app.console.ConsoleFactory;

public class SalesRecordCommand extends Command {

	@Override
	public void execute() {
		Console console = ConsoleFactory.getRecord();
		console.request();
	}
}
