package sumlong;

public class SumLong {
    public static void main(String args[]) {
        long sum = 0;
        StringBuilder number = new StringBuilder();
        for (String arg : args) {
            for (int i = 0; i < arg.length(); i++) {
                char symbol = arg.charAt(i);
                if (!Character.isWhitespace(symbol)) {
                    number.append(symbol);
                }
                if ((Character.isWhitespace(symbol) || i == arg.length() - 1) && number.length() > 0) {
                    sum += Long.parseLong(number.toString());
                    number.setLength(0);
                }
            }
        }
        System.out.println(sum);
    }
}
