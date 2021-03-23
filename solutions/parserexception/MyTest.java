package parserexception;

import parserexception.exceptions.*;

public class MyTest {
    public static void main (String args[]) throws FormatParserException {
        ExpressionParser expressionParser = new ExpressionParser();
        int x,y,z;
        x = 1;
        y = 2;
        z = 3;
        System.out.println(expressionParser.parse("10 / 0").evaluate(x, y, z));
    }
}
