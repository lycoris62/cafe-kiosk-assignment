package app.util;

import java.util.Scanner;
import java.util.function.Predicate;

import app.domain.Category;

public final class InputUtil {

	private static final int MENU_LENGTH = Category.values().length + 2;

	private static int validate(Predicate<Integer> validator) {
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				int number = scanner.nextInt();
				validate(validator, number);

				return number;
			} catch (RuntimeException e) {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
			}
		}
	}

	private static void validate(Predicate<Integer> validator, int number) {
		if (!validator.test(number)) {
			throw new IllegalArgumentException();
		}
	}

	public static int readMenuNumber() {
		return validate(input -> (0 <= input && input <= MENU_LENGTH));
	}

	public static int readProductNumber(int categoryNumber) {
		return validate(input -> (0 < input && input <= getCategorySize(categoryNumber)));
	}

	private static int getCategorySize(int categoryNumber) {
		return Category.getCategorySize(categoryNumber);
	}

	public static int readAddCartCheckNumber() {
		return validate(input -> (input == 1 || input == 2));
	}

	public static int readOrderCheckNumber() {
		return validate(input -> (input == 1 || input == 2));
	}

	public static int readOrderCancelCheckNumber() {
		return validate(input -> (input == 1 || input == 2));
	}

	public static int readReturnMenuCheckNumber() {
		return validate(input -> input == 1);
	}
}
