package app.command;

import app.command.implement.WelcomeCommand;

public class CommandRunner {

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void run() {
		command.execute();
	}

	public int init() {
		setCommand(new WelcomeCommand());
		return command.console.request();
	}
}
