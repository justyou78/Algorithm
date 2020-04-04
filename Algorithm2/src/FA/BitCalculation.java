package FA;

import java.util.Scanner;
//https://zoonvivor.tistory.com/45
public class BitCalculation {
	  public static void main(String[] args) throws Exception {
	        // TODO Auto-generated method stub
	        // Scanner sc = new Scanner(new FileInputStream("input.txt"));
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	 
	        int[] arr = new int[N];
	        for (int i = 0; i < 1 << N; i++) {
	            int[] abc = new int[N];
	            int bit = i;
	            for (int j = 0; bit != 0; j++, bit >>= 1) {
	                if ((1 & bit) == 0) {
	                    continue;
	                }
	                abc[j] = 1;
	 
	            }
	            for (int k = N - 1; k >= 0; k--) {
	                System.out.print(abc[k] + " ");
	            }
	            System.out.println();
	        }
	    }
	}
