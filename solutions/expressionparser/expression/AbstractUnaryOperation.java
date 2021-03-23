package expressionparser.expression;

public abstract class AbstractUnaryOperation implements TripleExpression {

    TripleExpression arg; /* Left and right part of expression*/

    protected AbstractUnaryOperation(TripleExpression arg) {

        this.arg = arg;
    }

    abstract protected int doOperation(int arg);

    public int evaluate(int x, int y, int z) {

        return doOperation(arg.evaluate(x, y, z));

    }
}