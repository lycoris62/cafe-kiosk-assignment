package app.menu;

import static app.menu.Product.*;

import java.util.List;

public enum Category {
	COFFEE(1, "Coffee", "커피 입니다.", List.of(
		AMERICANO,
		EINSPANNER,
		CAFE_LATTE,
		VANILLA_LATTE,
		OREO_LATTE)),

	ADE(2, "Ade", "에이드 입니다.", List.of(
		GREEN_GRAPE_ADE,
		GRAPE_FRUIT_ADE,
		LEMON_ADE,
		MANGO_ADE,
		STRAWBERRY_ADE,
		BLUEBERRY_ADE)),

	TEA(3, "Tea", "차 입니다.", List.of(STRAWBERRY_TEA)),

	LATTE(4, "Latte", "라떼 입니다.", List.of(
		GREEN_TEA_LATTE,
		EARL_GREY_MILK_TEA,
		MANGO_CREAM_LATTE,
		STRAWBERRY_CREAM_LATTE)),

	HANDMADE_DESSERT(5, "Handmade Dessert", "수제 디저트 입니다.", List.of(
		WHIPPED_CREAM_CROISSANT,
		GREEN_GRAPE_CROISSANT,
		OREO_CROISSANT,
		CHOCO_CROISSANT,
		STRAWBERRY_CROISSANT,
		PLAIN_SCONE,
		EARL_GREY_CORN));

	private final int categoryId;
	private final String menuName;
	private final String description;
	private final List<Product> categoryItems;

	Category(int categoryId, String menuName, String description, List<Product> categoryItems) {
		this.categoryId = categoryId;
		this.menuName = menuName;
		this.description = description;
		this.categoryItems = categoryItems;
	}

	public static List<Product> getCategoryItems(int categoryNumber) {
		Category category = Category.values()[categoryNumber - 1];
		return category.categoryItems;
	}

	public static Product getItem(int categoryNumber, int itemNumber) {
		return getCategoryItems(categoryNumber).get(itemNumber - 1);
	}

	public static int getCategorySize(int categoryNumber) {
		return getCategoryItems(categoryNumber).size();
	}

	public static String getCategoryName(int categoryNumber) {
		return Category.values()[categoryNumber - 1].menuName;
	}

	public static int size() {
		return Category.values().length;
	}

	public static void showCategory() {
		for (Category category : Category.values()) {
			System.out.println(category.toString());
		}
	}

	public static void showCategoryProduct(int categoryNumber) {
		for (Product item : Category.getCategoryItems(categoryNumber)) {
			System.out.println(item.toString());
		}
	}

	@Override
	public String toString() {
		return String.format("%d. %-20s | %s", categoryId, menuName, description);
	}
}
