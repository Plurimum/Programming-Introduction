package expressionparser.expression;

public class LeftShift extends AbstractBinaryOperation {

    public LeftShift(TripleExpression newLeft, TripleExpression newRight){
        super(newLeft, newRight);
    }

    protected int doOperation(int left, int right){
        return left << right;
    }
}
