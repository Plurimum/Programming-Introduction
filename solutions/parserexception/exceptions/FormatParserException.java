package parserexception.exceptions;


public class FormatParserException extends Exception {
    public FormatParserException(String s) {
        super(s);
    }

    static String mark(int pos) {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(" ".repeat(Math.max(0, pos)));
        sb.append("^");
        return sb.toString();
    }
}