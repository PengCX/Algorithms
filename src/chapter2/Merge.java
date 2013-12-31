package chapter2;

/**
 * �鲢����
 * 
 * @author pengcx
 * 
 */
public class Merge extends Sort {
	/** �鲢����ĸ������� */
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
	 * ���������a[lo]��a[hi]Ԫ��
	 * 
	 * @param a
	 *            ����a
	 * @param lo
	 *            ��СԪ��λ��lo
	 * @param hi
	 *            ���Ԫ��λ��hi
	 */
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		// ���������м�λ��
		int mid = lo + (hi - lo) / 2;
		// ��������a��ߵ�Ԫ��
		sort(a, lo, mid);
		// ��������a�ұߵ�Ԫ��
		sort(a, mid + 1, hi);
		// �ϲ�����a��ߺ��ұߵ�Ԫ��
		merge(a, lo, mid, hi);
	}

	/**
	 * ������a��a[lo]��a[mid]��Ԫ����a[mid]��a[hi]��Ԫ�غϲ�
	 * 
	 * @param a
	 *            �ϲ�������a
	 * @param lo
	 *            ��С����Ԫ��lo
	 * @param mid
	 *            �м�Ԫ��λ��mid
	 * @param hi
	 *            ���Ԫ��λ��hi
	 */
	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		for (int k = lo; k <= hi; k++) {
			// �����ߵ�Ԫ���þ���ȡ�ұߵ�Ԫ��
			if (i > mid) {
				a[k] = aux[j++];
			}
			// ����ұߵ�Ԫ���þ���ȡ��ߵ�Ԫ��
			else if (j > hi) {
				a[k] = aux[i++];
			}
			// ����Ұ�ߵĵ�ǰԪ��С�����ߵĵ�ǰԪ�أ�ȡ�Ұ��Ԫ��
			else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			}
			// ����Ұ�ߵĵ�ǰԪ�ش��ڵ������ߵĵ�ǰԪ�أ�ȡ����Ԫ��
			else {
				a[k] = aux[i++];
			}
		}
	}
}
