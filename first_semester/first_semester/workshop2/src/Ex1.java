

public class Ex1 {

	public static void main(String[] args) {

		boolean[] array = new boolean[15];

		for (int i = 1; i <= 15; i++) {
			if (i % 3 != 0) {
				array[i - 1] = true;
			}
			System.out.println(array[i - 1]);
		}

	}

}
