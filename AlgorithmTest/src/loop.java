
public class loop {
    static int[] a = new int[100];
    static int cnt = 1;

    public static void main(String[] args) {

        for (int i = 0; i < 4; i++) {
            System.out.println(a[cnt]);
            System.out.println(a[cnt]++);
        }

    }
}
