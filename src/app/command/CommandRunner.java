package app.command;

public class CommandRunner {

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void run() {
		command.execute();
	}
}