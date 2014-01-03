package chapter5;

/**
 * 低位优先的字符串排序
 * 
 * @author pengcx
 * 
 */
public class LSD {
	/**
	 * 将字符串数组a中的字符串，按低W位优先字符串排序
	 * 
	 * @param a
	 *            字符串数组a
	 * @param W
	 *            第W位
	 */
	public static void sort(String[] a, int W) {
		// 通过前W个字符将a[]排序
		int N = a.length;
		int R = 256;
		String aux[] = new String[N];

		// 根据从右到左，第d个字符用键索引计数法排序W遍
		for (int d = W - 1; d >= 0; d--) {

			// 第一步，计算出现的频率
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}

			// 第二步，将频率转换成索引
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}

			// 第三步，将元素匪类
			for (int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}

			// 第四步，回写
			for (int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}
	}

	public static void main(String[] args) {
		String[] a = { "abda", "sdfa", "qweg", "ndpl", "lkiu", "sdud" };
		int N = a.length;
		int W = a[0].length();

		sort(a, W);

		for (int i = 0; i < N; i++) {
			System.out.println(a[i]);
		}
	}
}
