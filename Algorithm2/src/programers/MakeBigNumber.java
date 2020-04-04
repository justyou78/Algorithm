package programers;

public class MakeBigNumber {
	public String solution(String number, int k) {
		String answer = "";

		char st[] = number.toCharArray();
		StringBuilder sb = new StringBuilder();
		// 3 4
		// 4 5 6 7

		int size = st.length - k;
		int size2 = k+1;
		// 7 - 3 = 4
		// 7 - 4 = 3;
		int idx = 0;
		
		while (size > 0) {
			char max = '0';
			for (int i = idx; i < size2; i++) {
				char num =st[i];

				if (num > max) {
					max = num;
					idx = i;
				}

			}
			sb.append(max);
			idx++;
			size2++;
			size--;
			if (idx == size2) {
                sb.append(number.substring(idx, number.length() - idx));
                break;
            }

			
			
		}
		return sb.toString();
	}
}