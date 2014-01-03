package chapter5;

/**
 * ������������
 * 
 * @author pengcx
 * 
 */
public class KeyIndex {

	/**
	 * ʹ�ü�������������ѧ������a���Լ�key���з�������
	 * 
	 * @param a
	 *            ѧ������a
	 * @param R
	 *            �������R
	 */
	public static void sort(Student[] a, int R) {
		int N = a.length;
		Student[] aux = new Student[N];
		int[] count = new int[R + 1];

		// ��һ����������ֵ�Ƶ��
		for (int i = 0; i < N; i++) {
			count[a[i].key() + 1]++;
		}

		// �ڶ�������Ƶ��ת��������
		for (int r = 0; r < R; r++) {
			count[r + 1] += count[r];
		}

		// ����������Ԫ�ط���
		for (int i = 0; i < N; i++) {
			aux[count[a[i].key()]++] = a[i];
		}

		// ���Ĳ�����д
		for (int i = 0; i < N; i++) {
			a[i] = aux[i];
		}
	}

	public static void main(String[] args) {
		Student stu1 = new Student("cac", 2);
		Student stu2 = new Student("fnc", 2);
		Student stu3 = new Student("edb", 4);
		Student stu4 = new Student("oel", 0);
		Student stu5 = new Student("akf", 2);
		Student stu6 = new Student("erk", 1);

		Student[] stus = { stu1, stu2, stu3, stu4, stu5, stu6 };
		sort(stus, 5);

		for (int i = 0; i < stus.length; i++) {
			System.out.println(stus[i].toString());
		}
	}
}

class Student {
	private String name;
	private int key;

	public Student(String name, int key) {
		super();
		this.name = name;
		this.key = key;
	}

	public int key() {
		return key;
	}

	@Override
	public String toString() {
		return name + ":" + key;
	}
}
