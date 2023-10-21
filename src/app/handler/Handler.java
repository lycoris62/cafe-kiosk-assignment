package app.handler;

import app.command.CommandRunner;

public abstract class Handler {

	protected Handler nexthandler;

	public Handler setNext(Handler handler) {
		this.nexthandler = handler;
		return handler;
	}

	protected abstract boolean check(int menuNumber);

	protected abstract void process(CommandRunner runner, int menuNumber);

	public void run(CommandRunner runner, int menuNumber) {
		if (check(menuNumber)) {
			process(runner, menuNumber);
			return;
		}

		nexthandler.run(runner, menuNumber);
	}
}
