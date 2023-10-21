package app.handler.implement;

import app.command.CommandRunner;
import app.command.implement.SalesRecordCommand;
import app.handler.Handler;

public class SalesRecordHandler extends Handler {

	private final int SALES_RECORD_NUMBER = 0;

	@Override
	protected boolean check(int menuNumber) {
		return menuNumber == SALES_RECORD_NUMBER;
	}

	@Override
	protected void process(CommandRunner runner, int menuNumber) {
		runner.setCommand(new SalesRecordCommand());
	}
}
