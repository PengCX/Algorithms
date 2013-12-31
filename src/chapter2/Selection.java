package chapter2;

/**
 * ѡ������
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
	 * ��������a
	 * 
	 * @param a
	 *            ���������a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			// Ĭ����СԪ��Ϊa[i]
			int min = i;
			// ��a[i+1]��a[N]��Ѱ�ҵ���СԪ��
			for (int j = i + 1; j < N; j++) {
				// ���a[j]��a[min]С����ǰ��СԪ��Ϊa[j]
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			// ��a[min]��a[i]����
			exch(a, i, min);
		}
	}
}