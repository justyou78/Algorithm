package programers;

public class MakeSticker {
	public int solution(int sticker[]) {
        if (sticker.length <= 3) {
            int max = 0;
            for (int i = 0; i < sticker.length; i++) {
                max = Math.max(max, sticker[i]);
            }
            return max;
        }
        int[] dp1 = new int[sticker.length]; //첫번째부터 시작 (마지막 스티커 못 더함)
        int[] dp2 = new int[sticker.length]; //두번째부터 시작 (마지막 스티터 더하기 가능)
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }
        int i = sticker.length - 1;
        dp1[i] = Math.max(dp1[i - 1], dp1[i - 2]);
        dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        
        return Math.max(dp1[i], dp2[i]);
    }
}

