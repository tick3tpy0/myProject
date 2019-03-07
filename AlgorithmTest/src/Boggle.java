import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boggle {
    static char[][] map = new char[5][5];
    static final int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0 };
    static final int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1 };

    // 5 x 5 보글 게임 판의 해당 위치에서 주어진 단어가 시작하는지를 반환.
    static boolean hasWord(int y, int x, String word) {
        // 1. 시작 위치가 범위 밖이면 무조건 실패
        if (!(y >= 0 && y < 5 && x >= 0 && x < 5)) {
            return false;
        }
        // 2. 첫 글자가 일치하지 않으면 실패
        if (map[y][x] != word.charAt(0)) {
            return false;
        }
        // 3. 단어가 일치하면서 원하는 단어가 한 글자인 경우 항상 성공
        System.out.println("word length : " + word.length());
        System.out.println("word : " + word);
        if (word.length() == 1) {
            return true;
        }
        // 인접한 여덟 칸을 검사한다.
        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            // word.substring(1)을 하면
            // 첫 번째 index 0을 제외하고 [1...]을 계속해서 수행한다.
            // word를 하나씩 줄여나가면서 인접한 알파벳을 찾기 시작
            if (hasWord(ny, nx, word.substring(1))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            for (int i = 0; i < 5; i++) {
                String str = br.readLine();
                map[i] = str.toCharArray();
            }
            int nWord = Integer.parseInt(br.readLine());
            while (nWord-- > 0) {
                String word = br.readLine();
                String result = "NO";
                for (int y = 0; y < 5; y++) {
                    for (int x = 0; x < 5; x++) {
                        // System.out.println("y : " + y + " x : " + x);
                        if (hasWord(y, x, word) && result.equals("NO"))
                            result = "YES";
                    }
                }
                bw.write(word + " " + result);
                bw.newLine();
                bw.flush();
            }
            bw.close();
        }
    }
}
