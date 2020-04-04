/*
 * package programers;
 * 
 * import java.util.ArrayList; import java.util.HashSet; import
 * java.util.Iterator;
 * 
 * public class RepresentationByN { public int solution(int N, int number) { int
 * answer = 0; ArrayList<Integer> al= new ArrayList<Integer>();
 * ArrayList<Integer> al2= new ArrayList<Integer>();
 * 
 * HashSet<Integer> hs = new HashSet<Integer>(); hs.add(N);
 * 
 * if (N == number) { return 1; }
 * 
 * for (int i = 2; i <= 8; i++) {
 * 
 * Iterator<Integer> it = hs.iterator();
 * 
 * while (it.hasNext()) { int num = it.next();
 * 
 * 
 * 
 * int f =((int) (Math.pow(10, i-1) * N) )+num;
 * 
 * int a =plus(num,N); int b =minus(num,N); int c =mul(num,N); int d
 * =devide(num,N); if (f == number) return i; else al2.add(f); if(a == number)
 * return i; else al2.add(a); if(b == number) return i; else al2.add(b); if(c ==
 * number) return i; else al2.add(c); if(d == number) return i; else al2.add(d);
 * 
 * al.add(num); }
 * 
 * for (int num : al) { hs.remove(num); }
 * 
 * for (int num : al2) {
 * 
 * hs.add(num); } al.clear(); al2.clear(); }
 * 
 * return -1;
 * 
 * 
 * 처음에 숫자가 2하나일때는 그냥 2; 2가 2개일때 ? 22 / 2+2 / 2-2/ 2*2 / 2/2 222 / 22 + 2 / 22 -2
 * / 22 * 2 / 22
 * 
 * 
 * 
 * 
 * }
 * 
 * public int plus(int num, int N) {
 * 
 * return num + N;
 * 
 * } public int devide_back(int num, int N) {
 * 
 * }
 * 
 * public int minus(int num, int N) {
 * 
 * return num - N; }
 * 
 * public int mul(int num, int N) {
 * 
 * return num * N; }
 * 
 * public int devide(int num, int N) {
 * 
 * return num / N; } }
 */