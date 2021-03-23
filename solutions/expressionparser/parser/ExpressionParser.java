package expressionparser.parser;

import expressionparser.expression.*;

public class ExpressionParser implements Parser {

    int currentIndexOfString = 0;

    String currentToken;

    /* Read number in string function */
    private void readNumber(String str) {

        int endIndex = currentIndexOfString + 1;
        while (endIndex < str.length() && Character.isDigit(str.charAt(endIndex))) {
            endIndex++;
        }
        currentToken = str.substring(currentIndexOfString, endIndex);
        currentIndexOfString = endIndex;
    }

    /* Get expression class by string function */
    private boolean parseToken(String str) {

        /* Skip spaces */
        while (currentIndexOfString < str.length() && Character.isWhitespace(str.charAt(currentIndexOfString))) {
            currentIndexOfString++;
        }

        /* If It's end */
        if (currentIndexOfString == str.length()) {
            currentToken = "\0";
            return false;
        }
        char beginSym = str.charAt(currentIndexOfString);
        switch (beginSym) {
            case '+':
            case '*':
            case '/':
            case '(':
            case ')':
            case '-':
                currentIndexOfString++;
                currentToken = new String(String.valueOf(beginSym));
                return true;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                readNumber(str);
                return true;
            default:
                if (Character.isAlphabetic(beginSym)) {
                    int endIndex = currentIndexOfString;
                    while (endIndex < str.length() &&
                            (Character.isAlphabetic(str.charAt(endIndex)) ||
                                    Character.isDigit(str.charAt(endIndex)))) {
                        endIndex++;
                    }
                    String name = str.substring(currentIndexOfString, endIndex);
                    switch (name) {
                        case "abs":
                        case "square":
                        case "x":
                        case "y":
                        case "z":
                            currentIndexOfString = endIndex;
                            currentToken = name;
                            return true;
                        default:
                            currentToken = "unknown";
                            return true;
                    }
                } else {
                    if (beginSym == '<' &&
                            currentIndexOfString + 1 < str.length() &&
                            str.charAt(currentIndexOfString + 1) == '<') {
                        currentIndexOfString += 2;
                        currentToken = "<<";
                        break;
                    } else {
                        if (beginSym == '>' && currentIndexOfString + 1 < str.length() &&
                                str.charAt(currentIndexOfString + 1) == '>') {
                            currentIndexOfString += 2;
                            currentToken = ">>";
                        } else {
                            currentToken = "unknown";
                        }
                    }
                }
        }
        return true;
    }

    public TripleExpression parse(String expr) {
        currentIndexOfString = 0;
        if (!parseToken(expr)) {
            return null;
        }
        return parseShifts(expr, false);
    }

    /* Parse shifts expression token */
    private TripleExpression parseShifts(String expr, boolean isNotFirstRead) {
        TripleExpression leftExpr = parseAddSub(expr, isNotFirstRead);
        while (true) {
            switch (currentToken) {
                case ">>":
                    leftExpr = new RightShift(leftExpr, parseAddSub(expr, true));
                    break;
                case "<<":
                    leftExpr = new LeftShift(leftExpr, parseAddSub(expr, true));
                    break;
                default:
                    return leftExpr;
            }
        }
    }

    /* Parse add and sub expression token */
    private TripleExpression parseAddSub(String expr, boolean isNotFirstRead) {
        TripleExpression leftExpr = parseMulDiv(expr, isNotFirstRead);
        while (true) {
            switch (currentToken) {
                case "+":
                    leftExpr = new Add(leftExpr, parseMulDiv(expr, true));
                    break;
                case "-":
                    leftExpr = new Subtract(leftExpr, parseMulDiv(expr, true));
                    break;
                default:
                    return leftExpr;
            }
        }
    }

    /* Parse mul and div expression token */
    private TripleExpression parseMulDiv(String expr, boolean isNotFirstRead) {
        TripleExpression leftExpr = parseUnary(expr, isNotFirstRead);
        while (true) {
            switch (currentToken) {
                case "*":
                    leftExpr = new Multiply(leftExpr, parseUnary(expr, true));
                    break;
                case "/":
                    leftExpr = new Divide(leftExpr, parseUnary(expr, true));
                    break;
                default:
                    return leftExpr;
            }
        }
    }

    /* Parse unary opearations */
    private TripleExpression parseUnary(String expr, boolean isNotFirstRead) {
        if (isNotFirstRead)
            parseToken(expr);
        if (Character.isDigit(currentToken.charAt(0))) {
            TripleExpression result = new Const(Integer.parseUnsignedInt(currentToken));
            parseToken(expr);
            return result;
        }
        switch (currentToken) {
            case "-":
                return new Subtract(new Const(0), parseUnary(expr, true));
            case "(":
                TripleExpression result = parseShifts(expr, true);
                if (currentToken != ")")
                    currentToken = "undefined";
                parseToken(expr);
                return result;
            case "abs":
                return new Absolute(parseUnary(expr, true));
            case "square":
                return new Square(parseUnary(expr, true));
            case "x":
            case "y":
            case "z":
                TripleExpression res = new Variable(currentToken);
                parseToken(expr);
                return res;
            default:
                currentToken = "undefinded";
                return null;
        }
    }
}