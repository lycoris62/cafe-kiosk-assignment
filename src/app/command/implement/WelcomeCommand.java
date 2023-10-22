package app.command.implement;

import app.command.Command;
import app.console.Console;
import app.console.ConsoleFactory;

public class WelcomeCommand extends Command {

	public WelcomeCommand() {
	}

	@Override
	public void execute() {
		Console console = ConsoleFactory.getWelcome();
		console.request();
	}
}
