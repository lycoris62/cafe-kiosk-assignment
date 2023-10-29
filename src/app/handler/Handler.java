package app.handler;

import app.command.CommandRunner;

public abstract class Handler {

	protected Handler nextHandler;

	public Handler setNext(Handler handler) {
		this.nextHandler = handler;
		return handler;
	}

	protected abstract boolean check(int menuNumber);

	protected abstract void process(CommandRunner runner, int menuNumber);

	public void handle(CommandRunner runner, int menuNumber) {
		if (check(menuNumber)) {
			process(runner, menuNumber);
			return;
		}

		nextHandler.handle(runner, menuNumber);
	}
}
