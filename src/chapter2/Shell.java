package chapter2;

/**
 * 希尔排序
 * 
 * @author pengcx
 * 
 */
public class Shell extends Sort {
	public static void main(String[] args) {
		String[] a = { "d", "a", "w", "b", "q" };
		Shell.sort(a);
		show(a);
	}

	/**
	 * 排序数组a
	 * 
	 * @param a
	 *            排序的数组a
	 */
	protected static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			for (int i = 0; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}
}