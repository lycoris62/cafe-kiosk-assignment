package app.menu;

public class Menu {
	protected final String name;
	protected final String description;

	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
}
