package other;

public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int[] positions = new int[2];
        for (char c : moves.toCharArray()) {
            if(c == 'U'){
                positions[0] ++;
            }else if(c == 'D'){
                positions[0]--;
            }else if(c == 'L'){
                positions[1]++;
            }else {
                positions[1]--;
            }
        }
        return positions[0]==0 && positions[1]==0;
    }
}
