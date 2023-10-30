package app.handler;

public abstract class Handler {

	protected Handler nextHandler;

	public Handler setNext(Handler handler) {
		this.nextHandler = handler;
		return handler;
	}

	public void handle(int menuNumber) {
		if (check(menuNumber)) {
			process(menuNumber);
			return;
		}

		nextHandler.handle(menuNumber);
	}

	protected abstract boolean check(int menuNumber);

	protected abstract void process(int menuNumber);
}
