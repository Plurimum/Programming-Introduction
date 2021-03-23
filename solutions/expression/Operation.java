package expression;

public abstract class Operation implements Expression {

    private final DoubleExpression left;

    private final DoubleExpression right;

    public Operation(DoubleExpression left, DoubleExpression right) {

        this.left = left;

        this.right = right;

    }

    protected abstract int evaluate(int left, int right);

    public double evaluate(double x, double y) {

        return evaluate(left.evaluate(x, y), right.evaluate(x, y));

    }



}