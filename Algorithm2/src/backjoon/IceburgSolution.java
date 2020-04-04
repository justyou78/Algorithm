package backjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class IceburgSolution {
	/*
	 * 
	 * 내가 푼 방식과는 다른것이 배열을 하나 더 만들어서 그곳에다가 dfs하는 과정에서 움직인 경로에
	 * 0이있을경우 x,y좌표를 ++하면서 내가 했던 과정에서의 for 하나를 더 줄였어.
	*/
	
	 static int r;
	    static int c;
	    static int[][] map;
	    static int[][] visited;
	    static int[][] melt;
	    static int[] dx = {1, -1, 0, 0};
	    static int[] dy = {0, 0, 1, -1};
	 
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        r = Integer.parseInt(st.nextToken());
	        c = Integer.parseInt(st.nextToken());
	        map = new int[r][c];
	        visited = new int[r][c];
	        melt = new int[r][c];
	 
	        for(int i=0; i<r; i++) {
	            st = new StringTokenizer(br.readLine());
	            for(int j=0; j<c; j++) {
	                map[i][j] = Integer.parseInt(st.nextToken());
	            }
	        }
	 
	        solution();
	    }
	 
	    static void solution() {
	        int year = 0;
	 
	        while(true) {
	            // dfs 로 빙산 덩어리 세기
	            int count = 0;
	            for(int i=0; i<r; i++) {
	                for(int j=0; j<c; j++) {
	                    if(visited[i][j] == 0 && map[i][j] != 0) {
	                        dfs(i, j);
	                        count++;
	                    }
	                }
	            }
	 
	            if(count == 0) {
	                System.out.println(0);
	                break;
	            } else if(count >= 2) {
	                System.out.println(year);
	                break;
	            }
	 
	            melting();
	            year++;
	        }
	    }
	    
	    static void dfs(int x, int y) {
	        visited[x][y] = 1;
	 
	        for(int i=0; i<4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	 
	            if(0 <= nx && nx < r && 0 <= ny && ny < c) {
	                // 1년 후에 녹는 빙산의 양 구하기
	                if(map[nx][ny] == 0)
	                    melt[x][y]++;
	 
	                // dfs 재귀
	                if(visited[nx][ny] == 0 && map[nx][ny] != 0)
	                    dfs(nx, ny);                    
	            }
	        }
	    }
	 
	    static void melting() {    
	        /**
	        * 1. 빙산 녹이기
	        * 2. 만약 녹인 높이가 음수가 되면 0으로 바꿔주기
	        * 3. visited 초기화
	        * 4. melt 초기화
	        */               
	        for(int i=0; i<r; i++) {
	            for(int j=0; j<c; j++) {
	                map[i][j] -= melt[i][j];
	 
	                if(map[i][j] < 0)
	                    map[i][j] = 0;
	                                    
	                visited[i][j] = 0;
	                melt[i][j] = 0;
	            }
	        }
	    }
	}