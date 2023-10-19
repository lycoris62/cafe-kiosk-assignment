package app.menu;

public enum CategoryMenu {

	// Coffee
	AMERICANO("아메리카노", 4000),
	EINSPANNER("아인슈페너", 5000),
	CAFE_LATTE("카페 라떼", 4300),
	VANILLA_LATTE("바닐라 라떼", 4500),
	OREO_LATTE("오레오 라떼", 4800),

	// Ade
	GREEN_GRAPE_ADE("청포도 에이드", 5500),
	GRAPE_FRUIT_ADE("자몽 에이드", 5500),
	LEMON_ADE("레몬 에이드", 5500),
	MANGO_ADE("망고 에이드", 6000),
	STRAWBERRY_ADE("딸기 에이드", 6000),
	BLUEBERRY_ADE("블루베리 에이드", 6000),

	// Tea
	STRAWBERRY_TEA("딸기차", 4500),

	// Latte
	GREEN_TEA_LATTE("녹차 라떼", 4500),
	EARL_GREY_MILK_TEA("얼그레이 홍차 라떼", 4500),
	MANGO_CREAM_LATTE("망고 크림 라떼", 6000),
	STRAWBERRY_CREAM_LATTE("딸기 크림 라떼", 6000),

	// Handmade Dessert
	WHIPPED_CREAM_CROISSANT("생크림 크루아상", 4500),
	GREEN_GRAPE_CROISSANT("청포도 크루아상", 5000),
	OREO_CROISSANT("오레오 크루아상", 5000),
	CHOCO_CROISSANT("초코 크루아상", 5000),
	STRAWBERRY_CROISSANT("딸기 크루아상", 5500),
	PLAIN_SCONE("플레인 스콘", 3000),
	EARL_GREY_CORN("얼그레이 스콘", 3400);

	CategoryMenu(String menuName, int price) {
	}
}
