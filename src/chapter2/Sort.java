package chapter2;

/**
 * 排序父类：具有排序的公共方法
 * 
 * @author pengcx
 * 
 */
public class Sort {

	/**
	 * 交换数组a中的第i个元素和第j个元素
	 * 
	 * @param a
	 *            交换元素的数组a
	 * @param i
	 *            交换元素的索引i
	 * @param j
	 *            交换元素的索引j
	 */
	protected static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * 比较v和w的大小
	 * 
	 * @param v
	 *            比较的元素v
	 * @param w
	 *            比较的元素w
	 * @return 大小标识
	 */
	protected static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	/**
	 * 输出数组a中的各个元素
	 * 
	 * @param a
	 *            数组a
	 */
	protected static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}