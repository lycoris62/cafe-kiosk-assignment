package app.console.decorator;

import app.console.Console;
import app.console.ConsoleDecorator;
import app.container.SalesRecord;

public class RecordConsole extends ConsoleDecorator {

	public RecordConsole(Console console) {
		super(console);
	}

	@Override
	public int request() {
		showSalesRecord();
		int input = super.request();
		validate(input);

		return input;
	}

	private void showSalesRecord() {
		SalesRecord salesRecord = SalesRecord.getInstance();
		salesRecord.showAllRecord();
	}

	private void validate(int input) {
		if (input != 1) {
			throw new IllegalArgumentException();
		}
	}
}
