package app.command;

import app.command.implement.WelcomeCommand;
import app.handler.Handler;
import app.handler.implement.OrderCancelHandler;
import app.handler.implement.OrderHandler;
import app.handler.implement.PurchaseHandler;
import app.handler.implement.SalesRecordHandler;

public class CommandRunner {

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void run() {
		command.execute();
	}

	public void init() {
		setCommand(new WelcomeCommand());
		int menuNumber = command.console.request();

		Handler rootHandler = settingHandler();
		rootHandler.run(this, menuNumber);
	}
	private Handler settingHandler() {
		Handler rootHandler = new SalesRecordHandler();
		rootHandler
			.setNext(new PurchaseHandler())
			.setNext(new OrderHandler())
			.setNext(new OrderCancelHandler());
		return rootHandler;
	}
}
