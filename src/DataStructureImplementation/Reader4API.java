package DataStructureImplementation;

public class Reader4API {

    public static void main(String[] args) {
        char[] buf = {'a', 'b', 'c', 'd', 'e'};
        int n = 5;
        System.out.println(new Reader4API().read(buf, n));
    }

    public int read(char[] buf, int n) {
        char[] tempBuf = new char[4];
        int i = 0;
        int count = 0;
        int actualCount = 0;

        while (i < n) {
            //count = read4(tempBuf);
            actualCount = Math.min(count, n - i);

            for (int j = 0; j < actualCount; ++j) {
                buf[i++] = tempBuf[j];
            }

            if (count < 4) break;
        }

        return i;
    }
}
