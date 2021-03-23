package md2html;

import java.io.IOException;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public abstract class JsonSource {
    public static char END = '\0';

    protected int pos;
    protected int line = 1;
    protected int posInLine;
    private char c = '0';

    protected abstract char readChar() throws IOException;

    public char getChar() {
        return c;
    }

    public char nextChar() throws IOException {
        try {
            if (c == '\n') {
                line++;
                posInLine = 0;
            }
            c = readChar();
            pos++;
            posInLine++;
            return c;
        } catch (final IOException e) {
            throw e;
        }
    }
}
