package app.command.implement;

import app.command.Command;

public class WelcomeCommand extends Command {

	public WelcomeCommand() {
		this.console = consoleFactory.getWelcome();
	}

	@Override
	public void execute() {
		console.request();
	}
}
