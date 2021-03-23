package expressionparser.expression;

public class Multiply extends AbstractBinaryOperation {

    public Multiply (TripleExpression newLeft, TripleExpression newRight){

        super(newLeft, newRight);
    }

    protected int doOperation(int left, int right){

        return left * right;
    }
}
