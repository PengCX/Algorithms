package chapter2;

/** 
 * 插入排序 
 *  
 * @author pengcx 
 *  
 */ 
public class Insertion  extends Sort{ 
 
    public static void main(String[] args) { 
        String[] a = { "d", "a", "w", "b", "q" }; 
        Insertion.sort(a);  
        show(a); 
    } 
 
    /**  
    * 排序数组a 
    *  
    * @param a 
    *            排序的数组a 
    */ 
   private static void sort(Comparable[] a) { 
        int N = a.length; 
        for (int i = 0; i < N; i++) { 
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) { 
                exch(a, j, j - 1); 
            } 
        } 
    } 
}