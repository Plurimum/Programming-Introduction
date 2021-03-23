package fastscanner;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

class FastScanner {
    private BufferedReader in;

    FastScanner(InputStream stream) {
        in = new BufferedReader(new InputStreamReader(stream));
    }

    FastScanner(String string) {
        in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8))));
    }

    String nextLine() throws IOException {
        return in.readLine();
    }

    boolean hasNextLine() throws IOException {
        return in.ready();
    }

    Integer nextInt() throws IOException, NoSuchElementException {
        if (in.ready()) {
            boolean isNegative = false;
            char symbol = (char) in.read();
            while (in.ready() && Character.isWhitespace(symbol)) {
                symbol = (char) in.read();
            }
            StringBuilder number = new StringBuilder();
            if (in.ready() && symbol == '-'){
                isNegative = true;
                symbol = (char) in.read();
            }
            while (in.ready() && Character.isDigit(symbol)) {
                number.append(symbol);
                symbol = (char) in.read();
            }
            if (Character.isDigit(symbol)) {
                number.append(symbol);
            }
            if (number.length() > 0 && Math.abs(Long.parseLong(number.toString())) >= Integer.MIN_VALUE) {
                int result = Integer.parseInt(number.toString());
                return isNegative ? (result * -1) : result;
            } else {
                throw new NoSuchElementException("There is no integers in stream");
            }
        } else {
            throw new IOException("Can't read stream");
        }
    }

    boolean hasNextInt() throws IOException {
        if (in.ready()) {
            boolean isNegative = false;
            in.mark(1_000_000);
            char symbol = (char) in.read();
            while (in.ready() && Character.isWhitespace(symbol)) {
                symbol = (char) in.read();
            }
            StringBuilder number = new StringBuilder();
            if (in.ready() && symbol == '-'){
                symbol = (char) in.read();
            }
            while (in.ready() && Character.isDigit(symbol)) {
                number.append(symbol);
                symbol = (char) in.read();
            }
            if (Character.isDigit(symbol)) {
                number.append(symbol);
            }
            in.reset();
            long result;
            if (number.length() > 0) {
                result = Long.parseLong(number.toString());
                return Math.abs(result) >= Integer.MIN_VALUE;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void close() throws IOException {
        in.close();
    }
}