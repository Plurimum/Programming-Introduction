package expressionparser.expression;

public class Divide extends AbstractBinaryOperation {
    public Divide(TripleExpression newLeft, TripleExpression newRight){

        super(newLeft, newRight);
    }

    protected int doOperation(int left, int right){

        return left / right;
    }
}
