package expressionparser.expression;

public class Add extends AbstractBinaryOperation {

    public Add(TripleExpression newLeft, TripleExpression newRight) {

        super(newLeft, newRight);
    }

    protected int doOperation(int left, int right) {

        return left + right;
    }
}