package expressionparser.expression;

public class Subtract extends AbstractBinaryOperation {
    public Subtract(TripleExpression newLeft, TripleExpression newRight){
        super(newLeft, newRight);
    }

    protected int doOperation(int left, int right){

        return left - right;
    }
}
