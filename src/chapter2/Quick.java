package chapter2;

/**
 * 快速排序
 * 
 * @author pengcx
 * 
 */
public class Quick extends Sort {
	/**
	 * 使用快速排序方法排序数组a中从a[lo]至a[hi]元素
	 * 
	 * @param a
	 *            待排序的数组a
	 * @param lo
	 *            排序低位
	 * @param hi
	 *            排序高位
	 */
	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		// 切分数组a
		int j = partition(a, lo, hi);

		// 将左半部分进行排序
		sort(a, 0, j);
		// 将右半部分进行排序
		sort(a, j + 1, hi);
	}

	/**
	 * 将数组a切分为a[0]至a[i-1]，a[i]，a[i+1]至a[hi]三个子数组，这个过程满足三个条件： 1.对于某个j，a[j]已经排定；
	 * 2.a[lo]到a[j-1]的所有元素都不大于a[j] 3.a[j+1]到a[hi]的所有元素都不小于a[j]
	 * 
	 * @param a
	 *            待切分的数组a
	 * @param lo
	 *            数组低位
	 * @param hi
	 *            数组高位
	 * @return 切分的位置
	 */
	private static int partition(Comparable[] a, int lo, int hi) {
		// 左右扫描指针
		int i = lo, j = hi + 1;
		// 默认把a[lo]作为切分元素
		Comparable v = a[lo];

		while (true) {
			// 从数组的左端开始向右扫描，直到找到一个大于等于它的元素
			while (less(a[++i], v)) {
				if (i == hi) {
					break;
				}
			}

			// 在从数组的右端开始向左扫描，直到找个一个小于等于它的元素
			while (less(v, a[--j])) {
				if (j == lo) {
					break;
				}
			}

			// 当两个指针相遇的时候，我们退出循环
			if (i >= j) {
				break;
			}

			// 这两个元素的位置显然不对，交换位置
			exch(a, i, j);
		}

		// 将切分元素a[lo]和左子数组中最右侧a[j]交换然后返回j
		exch(a, lo, j);
		return j;
	}

	public static void main(String[] args) {
		String[] a = { "d", "a", "w", "b", "q" };
		Quick.sort(a, 0, a.length - 1);
		show(a);
	}
}
