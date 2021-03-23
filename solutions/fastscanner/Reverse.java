package fastscanner;

import java.io.IOException;

public class Reverse {
    public static void main(String args[]) throws IOException {
        long start = System.currentTimeMillis();
        FastScanner scanner = new FastScanner(System.in);
        int size = 1_000_001;
        String[] numbers = new String[size];
        int i = 0;
        while (scanner.hasNextLine()) {
            i++;
            numbers[i] = scanner.nextLine();
        }
        System.err.println("Read done in " + (System.currentTimeMillis() - start));
        StringBuilder reversedString = new StringBuilder();
        for (int j = i; j >= 1; j--){
            FastScanner stringScanner = new FastScanner(numbers[j]);
            reversedString.setLength(0);
            while (stringScanner.hasNextInt()){
                int curNumber = stringScanner.nextInt();
                reversedString.insert(0, String.valueOf(curNumber) + " ");
            }
            stringScanner.close();
            System.out.println(reversedString.toString());
        }
        scanner.close();
    }
}

