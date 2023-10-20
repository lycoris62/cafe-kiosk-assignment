package app.menu;

import static app.menu.CategoryMenu.*;

import java.util.List;

public enum Category {
	COFFEE("Coffee", "커피 입니다.", List.of(
		AMERICANO,
		EINSPANNER,
		CAFE_LATTE,
		VANILLA_LATTE,
		OREO_LATTE)),

	ADE("Ade", "에이드 입니다.", List.of(
		GREEN_GRAPE_ADE,
		GRAPE_FRUIT_ADE,
		LEMON_ADE,
		MANGO_ADE,
		STRAWBERRY_ADE,
		BLUEBERRY_ADE)),

	TEA("Tea", "차 입니다.", List.of(STRAWBERRY_TEA)),

	LATTE("Latte", "라떼 입니다.", List.of(
		GREEN_TEA_LATTE,
		EARL_GREY_MILK_TEA,
		MANGO_CREAM_LATTE,
		STRAWBERRY_CREAM_LATTE)),

	HANDMADE_DESSERT("Handmade Dessert", "수제 디저트 입니다.", List.of(
		WHIPPED_CREAM_CROISSANT,
		GREEN_GRAPE_CROISSANT,
		OREO_CROISSANT,
		CHOCO_CROISSANT,
		STRAWBERRY_CROISSANT,
		PLAIN_SCONE,
		EARL_GREY_CORN));

	private final String menuName;
	private final String description;
	private final List<app.menu.CategoryMenu> categoryItems;

	Category(String menuName, String description, List<app.menu.CategoryMenu> categoryItems) {
		this.menuName = menuName;
		this.description = description;
		this.categoryItems = categoryItems;
	}

	public static List<CategoryMenu> getCategoryItems(int categoryNumber) {
		Category category = Category.values()[categoryNumber - 1];
		return category.categoryItems;
	}

	@Override
	public String toString() {
		return String.format("%-20s | %s", menuName, description);
	}
}
