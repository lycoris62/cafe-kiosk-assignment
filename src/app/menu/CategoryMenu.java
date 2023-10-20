package app.menu;

public enum CategoryMenu {

	// Coffee
	AMERICANO("아메리카노", 4000, "아메리카노 입니다."),
	EINSPANNER("아인슈페너", 5000, "아인슈페너 입니다."),
	CAFE_LATTE("카페 라떼", 4300, "카페 라떼 입니다."),
	VANILLA_LATTE("바닐라 라떼", 4500, "바닐라 라떼 입니다."),
	OREO_LATTE("오레오 라떼", 4800, "오레오 라떼 입니다."),

	// Ade
	GREEN_GRAPE_ADE("청포도 에이드", 5500, "청포도 에이드 입니다."),
	GRAPE_FRUIT_ADE("자몽 에이드", 5500, "자몽 에이드 입니다."),
	LEMON_ADE("레몬 에이드", 5500, "레몬 에이드 입니다."),
	MANGO_ADE("망고 에이드", 6000, "망고 에이드 입니다."),
	STRAWBERRY_ADE("딸기 에이드", 6000, "딸기 에이드 입니다."),
	BLUEBERRY_ADE("블루베리 에이드", 6000, "블루베리 에이드 입니다."),

	// Tea
	STRAWBERRY_TEA("딸기차", 4500, "딸기차 입니다."),

	// Latte
	GREEN_TEA_LATTE("녹차 라떼", 4500, "녹차 라떼 입니다."),
	EARL_GREY_MILK_TEA("얼그레이 홍차 라떼", 4500, "얼그레이 홍차 라떼 입니다."),
	MANGO_CREAM_LATTE("망고 크림 라떼", 6000, "망고 크림 라떼 입니다."),
	STRAWBERRY_CREAM_LATTE("딸기 크림 라떼", 6000, "딸기 크림 라떼 입니다."),

	// Handmade Dessert
	WHIPPED_CREAM_CROISSANT("생크림 크루아상", 4500, "생크림 크루아상 입니다."),
	GREEN_GRAPE_CROISSANT("청포도 크루아상", 5000, "청포도 크루아상 입니다."),
	OREO_CROISSANT("오레오 크루아상", 5000, "오레오 크루아상 입니다."),
	CHOCO_CROISSANT("초코 크루아상", 5000, "초코 크루아상 입니다."),
	STRAWBERRY_CROISSANT("딸기 크루아상", 5500, "딸기 크루아상 입니다."),
	PLAIN_SCONE("플레인 스콘", 3000, "플레인 스콘 입니다."),
	EARL_GREY_CORN("얼그레이 스콘", 3400, "얼그레이 스콘 입니다.");

	private final String menuName;
	private final int price;
	private final String description;

	CategoryMenu(String menuName, int price, String description) {
		this.menuName = menuName;
		this.price = price;
		this.description = description;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return String.format("%-15s | ₩ %2.1f | %s", menuName, price / 1000.0, description);
	}
}