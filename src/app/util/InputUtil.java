package app.util;

import java.util.Scanner;
import java.util.function.Predicate;

import app.domain.Category;

public final class InputUtil { // 유틸 클래스로 상속, 생성 불가능

	private static final int MENU_LENGTH = Category.values().length + 2;
	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * 잘못된 입력 받을 시 계속 입력을 받도록 하는 함수.
	 *
	 * @param validator 올바른 입력을 검증하는 람다식
	 * @return 검증된 입력 번호를 리턴
	 */
	private static int validate(Predicate<Integer> validator) {
		while (true) {
			try {
				int number = scanner.nextInt(); // 정수가 아니라면 예외 발생으로 다시 입력 받음
				validate(validator, number); // 올바른 입력이 아니라면 예외 발생으로 다시 입력 받음

				return number;
			} catch (RuntimeException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
				scanner.nextLine(); // 버퍼에 남은 값들 제거
			}
		}
	}

	private static void validate(Predicate<Integer> validator, int number) {
		if (!validator.test(number)) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 메인화면에서 메뉴 번호를 입력 받음
	 */
	public static int readMenuNumber() {
		return validate(input -> (0 <= input && input <= MENU_LENGTH));
	}

	/**
	 * 특정 카테고리 내의 상품 번호를 입력 받음
	 *
	 * @param categoryNumber 특정 카테고리 번호
	 */
	public static int readProductNumber(int categoryNumber) {
		return validate(input -> (0 < input && input <= getCategorySize(categoryNumber)));
	}

	private static int getCategorySize(int categoryNumber) {
		return Category.getCategorySize(categoryNumber);
	}

	/**
	 * 장바구니 추가를 확인하는 번호를 입력 받음
	 */
	public static int readAddCartCheckNumber() {
		return validate(input -> (input == 1 || input == 2));
	}

	/**
	 * 주문을 확인하는 번호를 입력 받음
	 */
	public static int readOrderCheckNumber() {
		return validate(input -> (input == 1 || input == 2));
	}

	/**
	 * 주문 취소를 확인하는 번호를 입력 받음
	 */
	public static int readOrderCancelCheckNumber() {
		return validate(input -> (input == 1 || input == 2));
	}

	/**
	 * 판매실적 확인 후 메인 화면으로 돌아갈지를 확인하는 번호를 입력 받음
	 */
	public static int readReturnMenuCheckNumber() {
		return validate(input -> input == 1);
	}
}
