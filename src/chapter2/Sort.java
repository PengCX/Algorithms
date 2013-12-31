package chapter2;

/**
 * �����ࣺ��������Ĺ�������
 * 
 * @author pengcx
 * 
 */
public class Sort {

	/**
	 * ��������a�еĵ�i��Ԫ�غ͵�j��Ԫ��
	 * 
	 * @param a
	 *            ����Ԫ�ص�����a
	 * @param i
	 *            ����Ԫ�ص�����i
	 * @param j
	 *            ����Ԫ�ص�����j
	 */
	protected static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * �Ƚ�v��w�Ĵ�С
	 * 
	 * @param v
	 *            �Ƚϵ�Ԫ��v
	 * @param w
	 *            �Ƚϵ�Ԫ��w
	 * @return ��С��ʶ
	 */
	protected static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	/**
	 * �������a�еĸ���Ԫ��
	 * 
	 * @param a
	 *            ����a
	 */
	protected static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
	}
}