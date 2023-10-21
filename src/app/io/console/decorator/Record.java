package app.io.console.decorator;

import app.container.SalesRecord;
import app.io.console.Console;
import app.io.console.ConsoleDecorator;

public class Record extends ConsoleDecorator {

	public Record(Console console) {
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
