/*
 * package FA;
 * 
 * import java.io.BufferedReader; import java.io.BufferedWriter; import
 * java.io.IOException; import java.io.InputStreamReader; import
 * java.io.OutputStreamWriter;
 * 
 * public class backjoon1787 { public static void main(String[] args) throws
 * NumberFormatException, IOException { BufferedReader br = new
 * BufferedReader(new InputStreamReader(System.in)); int num =
 * Integer.parseInt(br.readLine()); String st = br.readLine();
 * 
 * 
 * 
 * 
 * int answer = 0; for (int i = 0; i < st.length(); i++) {
 * 
 * int len = st.length()-i; //우측 문자열의 갯수 loop : for (int j = 1; j <= len/2; j++)
 * { int index = i; int index2 = st.length()-j; boolean check =false; //각 잘라놓은
 * 문자열 비교 //aabab //
 * 
 * j = 0 i = 1 a a pi[1] = 1; j = 1 i = 2 a b j = pi[0]; => j = 0 j = 0 i = 3 a
 * a pi[3] = 1; a b j = j = pi[0]= j = 0; 01010 pi는 cabaaabab
 * 
 * 
 * 
 * 
 * 
 * 
 * ABCDABE // i = 1 j = 0
 * 
 * B A I = 2 j = 0 C A I = 4 J = 0 A A PI[4] = 1 I = 5 J = 1 B B PI[5] = 2 I = 6
 * J = 2 J = PI[1]; -> J =2 ; 0000120 ABCDABCDABEAAAA PI(Pattern Index) 는 찾는
 * 스트링의 인덱스를 잡아주는 역할을 해.
 * 
 * -----------------------------결론 원래 패턴확인하고 안맞으면 패턴 길이만큼 넘겨서 확인하면 돼 근데 문제가 생기지
 * 그래서 그 문제를 해결하기 위해서 총 문자열의 접미사와 패턴 문자열의 접두사를 비교해서 총문자열은 그대로 쭉가게 만들면서 패턴 문자열의
 * 인덱스를 변경하게 하는거야. 어렵네... 그래도 이해는했다!
 * 
 * 
 * if(st.substring(beginIndex)) for (int j2 = 0; j2 < j; j2++) {
 * if(st.charAt(index++) != st.charAt(index2++)) { check =true; break; } }
 * 
 * if(!check) {
 * 
 * answer += len-j; break loop; } }
 * 
 * 
 * } BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 * bw.write(String.valueOf(answer)); bw.flush(); bw.close();
 * 
 * } }
 * 
 * 
 * 
 * https://mygumi.tistory.com/61
 */