/*
 * package EST;
 * 
 * import java.util.HashMap;
 * 
 * class Solution { public int solution(int[] A) {
 * 
 * HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); int answer =
 * -1;
 * 
 * for (int i = 0; i < A.length; i++) { int getNum = A[i];
 * 
 * int num = 1; int sum = 0; int length = (int)(Math.log10(getNum)+1);
 * 
 * 
 * for (int j = 0; j < length-1; j++) { num = num * 10; }
 * 
 * 
 * int count = 0; int cloneGetNum = getNum; while(length != count) {
 * System.out.println(num); int digit=cloneGetNum /num;
 * System.out.println(digit); sum += digit; cloneGetNum -= digit *num; num /=
 * 10; count++; }
 * 
 * if(hm.containsKey(sum)) {
 * 
 * answer = Math.max(answer, getNum+hm.get(sum)); hm.replace(sum,
 * Math.max(hm.get(sum), getNum));
 * 
 * } else { hm.put(sum,getNum); }
 * 
 * 
 * 
 * } return answer;
 * 
 * } }
 */