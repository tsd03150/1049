import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 사야되는 기타줄
        int m = kb.nextInt(); // 브랜드 갯수
        int[] po = new int[m];
        int[] no = new int[m];

        for (int i = 0; i < m; i++) {
            po[i] = kb.nextInt();
            no[i] = kb.nextInt();
        }

        Arrays.sort(po);
        Arrays.sort(no);
        int answer = Integer.MAX_VALUE;

        // 셋 중에 경우가 하나이다
        // 1. 전부 패키지 2. 전부 낱개 3. 부분 패키지 + 낱개

        // 1, 2를 비교
        answer = Math.min((n / 6 + 1) * po[0], n * no[0]);
        // 1, 2 비교에서 최솟값과 3을 비교
        // +) N = 18인 처럼 나머지가 0인 경우에는 위에 코드에서 나머지가 있는 걸로 간주되어 80(po[0]= 20)이라는 값이 나오지만
        // 아래에 코드에서 나머지가 없기 때문에 60이라는 값으로 정정된다
        answer = Math.min(answer, (n / 6) * po[0] + (n % 6) * no[0]);

        System.out.println(answer);
    }
}
