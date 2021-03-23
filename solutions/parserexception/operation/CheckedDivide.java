package parserexception.operation;

import parserexception.TripleExpression;
import parserexception.exceptions.ArithmeticParserException;
import parserexception.exceptions.DivisionByZeroException;
import parserexception.exceptions.OverflowException;

public class CheckedDivide extends AbstractBinaryOperation {
    public CheckedDivide(TripleExpression left, TripleExpression right) {
        super(left, right);
    }

    private void check(int left, int right) {
        if (right == 0) {
            throw new DivisionByZeroException(left + " " + right);
        }
        if (left == Integer.MIN_VALUE && right == -1) {
            throw new OverflowException();
        }
    }

    @Override
    protected int doOperation(int left, int right) throws ArithmeticParserException {
        check(left, right);
        return left / right;
    }
}