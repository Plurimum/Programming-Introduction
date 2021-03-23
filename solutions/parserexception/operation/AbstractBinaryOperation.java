package parserexception.operation;

import parserexception.TripleExpression;
import parserexception.exceptions.ArithmeticParserException;

public abstract class AbstractBinaryOperation implements TripleExpression {
    private final TripleExpression left;
    private final TripleExpression right;

    public AbstractBinaryOperation(TripleExpression left, TripleExpression right) {
        this.left = left;
        this.right = right;
    }

    protected abstract int doOperation(int left, int right);


    public int evaluate(int x, int y, int z) throws ArithmeticParserException {
        return doOperation(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }
}