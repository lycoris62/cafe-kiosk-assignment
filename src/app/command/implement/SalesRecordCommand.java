package app.command.implement;

import app.command.Command;

public class SalesRecordCommand extends Command {

	public SalesRecordCommand() {
		this.console = consoleFactory.getRecord();
	}

	@Override
	public void execute() {
		console.request();
	}
}
