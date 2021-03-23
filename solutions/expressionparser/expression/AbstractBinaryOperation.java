package expressionparser.expression;

public abstract class AbstractBinaryOperation implements TripleExpression {

    TripleExpression left, right;

    protected AbstractBinaryOperation(TripleExpression newLeft, TripleExpression newRight) {

        left = newLeft;

        right = newRight;

    }

    abstract protected int doOperation(int left, int right);

    public int evaluate(int x, int y, int z) {

        return doOperation(left.evaluate(x, y, z), right.evaluate(x, y, z));
    }
}