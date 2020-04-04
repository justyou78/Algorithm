package programers;


public class Visit_Length {
public int solution(String dirs) {
    int answer = 0;
    
    
    Test02 left = new Test02();
    Test02 right= new Test02();
    Test02 up = new Test02();
    Test02 down = new Test02();
    int x =  5;
    int y = 5;
  
    for (int i = 0; i < dirs.length(); i++) {
		char c = dirs.charAt(i);
		boolean check =false;
		
		if(c == 'U') {
			check =up.check(x, y+1);
			if(check) {
				down.check(x, y);
				y++;
			}
		}
		else if(c == 'R') {
			check =right.check(x+1, y);
			if(check) {
				left.check(x, y);
				x++;
			}
		}
		else if(c == 'L') {
			check =left.check(x-1, y);
			if(check) {
				right.check(x, y);
				x--;
			}
		}
		else if(c=='D') {
			check =down.check(x, y-1);
			if(check) {
				up.check(x, y);
				y--;
			}
			
		}
	}
    
    answer += left.getCount();
    answer += up.getCount();
    answer += right.getCount();
    answer += down.getCount();
    
    
    
    return answer/2;
}
}

class Test02{
boolean[][] spot;
int count= 0;
Test02() {
	spot = new boolean[11][11];
}
public boolean check(int x, int y) {
	
	//안움직임
	if(x < 0 || x > 10 || y < 0 || y > 10) {
		return false;
	}
	
	
	//움직임
	if(!spot[x][y]) {
		spot[x][y] = true;
		count++;
		return true;
	}
	else {
		return true;
	}
		
}

public int getCount() {
	return count;
}
}