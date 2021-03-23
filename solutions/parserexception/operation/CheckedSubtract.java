package parserexception.operation;

import parserexception.exceptions.ArithmeticParserException;
import parserexception.TripleExpression;
import parserexception.exceptions.UnderflowException;

public class CheckedSubtract extends AbstractBinaryOperation {
    public CheckedSubtract(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    protected int doOperation(int left, int right) throws ArithmeticParserException {
        if (right > 0 ? left < Integer.MIN_VALUE + right
                : left > Integer.MAX_VALUE + right) {
            throw new UnderflowException("Underflow by subtract " + left + " " + right);
        }
        return left - right;
    }
}