package chapter2;

/**
 * ��������
 * 
 * @author pengcx
 * 
 */
public class Quick extends Sort {
	/**
	 * ʹ�ÿ������򷽷���������a�д�a[lo]��a[hi]Ԫ��
	 * 
	 * @param a
	 *            �����������a
	 * @param lo
	 *            �����λ
	 * @param hi
	 *            �����λ
	 */
	public static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		// �з�����a
		int j = partition(a, lo, hi);

		// ����벿�ֽ�������
		sort(a, 0, j);
		// ���Ұ벿�ֽ�������
		sort(a, j + 1, hi);
	}

	/**
	 * ������a�з�Ϊa[0]��a[i-1]��a[i]��a[i+1]��a[hi]���������飬��������������������� 1.����ĳ��j��a[j]�Ѿ��Ŷ���
	 * 2.a[lo]��a[j-1]������Ԫ�ض�������a[j] 3.a[j+1]��a[hi]������Ԫ�ض���С��a[j]
	 * 
	 * @param a
	 *            ���зֵ�����a
	 * @param lo
	 *            �����λ
	 * @param hi
	 *            �����λ
	 * @return �зֵ�λ��
	 */
	private static int partition(Comparable[] a, int lo, int hi) {
		// ����ɨ��ָ��
		int i = lo, j = hi + 1;
		// Ĭ�ϰ�a[lo]��Ϊ�з�Ԫ��
		Comparable v = a[lo];

		while (true) {
			// ���������˿�ʼ����ɨ�裬ֱ���ҵ�һ�����ڵ�������Ԫ��
			while (less(a[++i], v)) {
				if (i == hi) {
					break;
				}
			}

			// �ڴ�������Ҷ˿�ʼ����ɨ�裬ֱ���Ҹ�һ��С�ڵ�������Ԫ��
			while (less(v, a[--j])) {
				if (j == lo) {
					break;
				}
			}

			// ������ָ��������ʱ�������˳�ѭ��
			if (i >= j) {
				break;
			}

			// ������Ԫ�ص�λ����Ȼ���ԣ�����λ��
			exch(a, i, j);
		}

		// ���з�Ԫ��a[lo]���������������Ҳ�a[j]����Ȼ�󷵻�j
		exch(a, lo, j);
		return j;
	}

	public static void main(String[] args) {
		String[] a = { "d", "a", "w", "b", "q" };
		Quick.sort(a, 0, a.length - 1);
		show(a);
	}
}
