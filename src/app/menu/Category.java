package app.menu;

import static app.menu.CategoryMenu.*;

import java.util.List;

public enum Category {
	COFFEE("Coffee",
		List.of(AMERICANO, EINSPANNER, CAFE_LATTE, CAFE_LATTE, VANILLA_LATTE, OREO_LATTE)),
	ADE("Ade",
		List.of(GREEN_GRAPE_ADE, GRAPE_FRUIT_ADE, LEMON_ADE, MANGO_ADE, STRAWBERRY_ADE, BLUEBERRY_ADE)),
	TEA("Tea", List.of(STRAWBERRY_TEA)),
	LATTE("Latte",
		List.of(GREEN_TEA_LATTE, EARL_GREY_MILK_TEA, MANGO_CREAM_LATTE, STRAWBERRY_CREAM_LATTE)),
	HANDMADE_DESSERT("Handmade Dessert",
		List.of(WHIPPED_CREAM_CROISSANT, GREEN_GRAPE_CROISSANT, OREO_CROISSANT,
			CHOCO_CROISSANT, STRAWBERRY_CROISSANT, PLAIN_SCONE, EARL_GREY_CORN));

	private final String menuName;
	private final List<CategoryMenu> categoryItems;

	Category(String menuName, List<CategoryMenu> categoryItems) {
		this.menuName = menuName;
		this.categoryItems = categoryItems;
	}
}
