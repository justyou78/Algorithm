/*
 * package EST;
 * 
 * import java.util.ArrayList;
 * 
 * class Solution { public int solution(int[] A) {
 * 
 * int answer = 0; ArrayList<Integer> al = new ArrayList<Integer>(); for (int i
 * = 0; i < A.length; i++) { al.add(A[i]); } //나무의 갯수가 2개일 경우 확인할 수 없음.
 * if(al.size() <=2 ) { return 0; }
 * 
 * //초기 나무를 자르지 않았을 때 int check =1; if (al.get(0) < al.get(1)) { check = 1; //
 * 다음은 음수값 확인 } else if (al.get(0) > al.get(1)) { check = -1; // 다음은 양수값 확인. }
 * 
 * boolean ch = false; for (int i = 1; i < al.size()-1; i++) { if (check == 1 &&
 * al.get(i) <= al.get(i + 1)) { ch = true; } else { check *= -1; } if (check ==
 * -1 && al.get(i) >= al.get(i + 1)) { ch = true; } else { check *= +1; } }
 * System.out.println("test"); if(!ch) { for (int i = 0; i < al.size(); i++) {
 * 
 * //나무 하나 제거 int pop = al.remove(i); int num = 1; int count = 0; if (al.get(0)
 * < al.get(1)) { num = 1; // 다음은 음수값 확인 } else if (al.get(0) > al.get(1)) { num
 * = -1; // 다음은 양수값 확인. } else { //또 제거 = -1; return -1; } for (int j = 1; j <
 * al.size()-1; j++) { if (num == 1 && al.get(j) <= al.get(j + 1)) { return -1;
 * } else { num *= -1; } if (num == -1 && al.get(j) >= al.get(j + 1)) { return
 * -1; } else { num *= +1; }
 * 
 * 
 * } // 하나만 잘라서 성공 if (count == 0) { answer++; }
 * 
 * al.add(i, pop); } } else { return 0; }
 * 
 * 
 * 
 * 
 * return answer; } }
 */