package chapter2;

/**
 * 归并排序
 * 
 * @author pengcx
 * 
 */
public class Merge extends Sort {
	/** 归并所需的辅助数组 */
	private static Comparable[] aux;

	public static void main(String[] args) {
		String[] a = { "d", "a", "w", "b", "q" };
		Merge.sort(a);
		show(a);
	}

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	/**
	 * 排序数组的a[lo]至a[hi]元素
	 * 
	 * @param a
	 *            数组a
	 * @param lo
	 *            最小元素位置lo
	 * @param hi
	 *            最大元素位置hi
	 */
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		// 计算数组中间位置
		int mid = lo + (hi - lo) / 2;
		// 排序数组a左边的元素
		sort(a, lo, mid);
		// 排序数组a右边的元素
		sort(a, mid + 1, hi);
		// 合并数组a左边和右边的元素
		merge(a, lo, mid, hi);
	}

	/**
	 * 将数组a的a[lo]至a[mid]的元素与a[mid]至a[hi]的元素合并
	 * 
	 * @param a
	 *            合并的数组a
	 * @param lo
	 *            最小数组元素lo
	 * @param mid
	 *            中间元素位置mid
	 * @param hi
	 *            最大元素位置hi
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		for (int k = lo; k <= hi; k++) {
			// 如果左边的元素用尽，取右边的元素
			if (i > mid) {
				a[k] = aux[j++];
			}
			// 如果右边的元素用尽，取左边的元素
			else if (j > hi) {
				a[k] = aux[i++];
			}
			// 如果右半边的当前元素小于左半边的当前元素，取右半边元素
			else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			}
			// 如果右半边的当前元素大于等于左半边的当前元素，取左半边元素
			else {
				a[k] = aux[i++];
			}
		}
	}
}
