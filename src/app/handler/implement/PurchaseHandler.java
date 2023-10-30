package app.handler.implement;

import app.command.implement.PurchaseCommand;
import app.handler.Handler;
import app.domain.Category;

public class PurchaseHandler extends Handler {

	private static final int MENU_START_NUMBER = 1;
	private static final int MENU_END_NUMBER = Category.size();

	@Override
	protected boolean check(int menuNumber) {
		return (MENU_START_NUMBER <= menuNumber) && (menuNumber <= MENU_END_NUMBER);
	}

	@Override
	protected void process(int menuNumber) {
		PurchaseCommand command = new PurchaseCommand(menuNumber);
		command.execute();
	}
}
