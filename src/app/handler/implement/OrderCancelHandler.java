package app.handler.implement;

import app.command.CommandRunner;
import app.command.implement.OrderCancelCommand;
import app.handler.Handler;
import app.menu.Category;

public class OrderCancelHandler extends Handler {

	private final int ORDER_CANCEL_NUMBER = Category.size() + 2;

	@Override
	protected boolean check(int menuNumber) {
		return menuNumber == ORDER_CANCEL_NUMBER;
	}

	@Override
	protected void process(CommandRunner runner, int menuNumber) {
		runner.setCommand(new OrderCancelCommand());
	}
}
