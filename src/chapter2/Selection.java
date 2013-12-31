package chapter2;

/**
 * 选择排序
 * 
 * @author pengcx
 * 
 */
public class Selection extends Sort {

	public static void main(String[] args) {
		String[] a = { "d", "a", "w", "b", "q" };
		Selection.sort(a);
		show(a);
	}

	/**
	 * 排序数组a
	 * 
	 * @param a
	 *            排序的数组a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			// 默认最小元素为a[i]
			int min = i;
			// 从a[i+1]至a[N]中寻找到最小元素
			for (int j = i + 1; j < N; j++) {
				// 如果a[j]比a[min]小，则当前最小元素为a[j]
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			// 将a[min]于a[i]交换
			exch(a, i, min);
		}
	}
}