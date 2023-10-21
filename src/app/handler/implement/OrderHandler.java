package app.handler.implement;

import app.command.CommandRunner;
import app.command.implement.OrderCommand;
import app.handler.Handler;
import app.menu.Category;

public class OrderHandler extends Handler {

	private final int ORDER_NUMBER = Category.size() + 1;

	@Override
	protected boolean check(int menuNumber) {
		return menuNumber == ORDER_NUMBER;
	}

	@Override
	protected void process(CommandRunner runner, int menuNumber) {
		runner.setCommand(new OrderCommand());
	}
}
