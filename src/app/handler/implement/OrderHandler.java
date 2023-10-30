package app.handler.implement;

import app.command.implement.OrderCommand;
import app.handler.Handler;
import app.domain.Category;

public class OrderHandler extends Handler {

	private static final int ORDER_NUMBER = Category.size() + 1;

	@Override
	protected boolean check(int menuNumber) {
		return menuNumber == ORDER_NUMBER;
	}

	@Override
	protected void process(int menuNumber) {
		OrderCommand command = new OrderCommand();
		command.execute();
	}
}
