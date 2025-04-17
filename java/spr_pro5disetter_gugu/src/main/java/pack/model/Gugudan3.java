package pack.model;

public class Gugudan3 implements GuguInter {
	@Override
	public int[] numberCalc(int dan) {
		int[] result = new int[9];

		for (int i = 0; i < 9; i++) {
			result[i] = dan * (i + 1);
		}

		return result;
	}
}
