package app.menu;

public class MenuItem {
	protected final String name;
	protected final String description;

	public MenuItem(String name, String description) {
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
