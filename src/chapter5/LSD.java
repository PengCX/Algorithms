package chapter5;

/**
 * ��λ���ȵ��ַ�������
 * 
 * @author pengcx
 * 
 */
public class LSD {
	/**
	 * ���ַ�������a�е��ַ���������Wλ�����ַ�������
	 * 
	 * @param a
	 *            �ַ�������a
	 * @param W
	 *            ��Wλ
	 */
	public static void sort(String[] a, int W) {
		// ͨ��ǰW���ַ���a[]����
		int N = a.length;
		int R = 256;
		String aux[] = new String[N];

		// ���ݴ��ҵ��󣬵�d���ַ��ü���������������W��
		for (int d = W - 1; d >= 0; d--) {

			// ��һ����������ֵ�Ƶ��
			int[] count = new int[R + 1];
			for (int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}

			// �ڶ�������Ƶ��ת��������
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}

			// ����������Ԫ�ط���
			for (int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}

			// ���Ĳ�����д
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
