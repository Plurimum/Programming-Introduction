package parserexception.operation;

import parserexception.TripleExpression;

public abstract class AbstractUnaryOperation implements TripleExpression {
    private final TripleExpression operand;

    public AbstractUnaryOperation(final TripleExpression value) {
        operand = value;
    }

    protected abstract int doOperation(int operand);

    public int evaluate(int x, int y, int z) {
        return doOperation(operand.evaluate(x, y, z));
    }
}