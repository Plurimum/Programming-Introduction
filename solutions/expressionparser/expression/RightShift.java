package expressionparser.expression;

public class RightShift extends AbstractBinaryOperation {

    public RightShift(TripleExpression newLeft, TripleExpression newRight){
        super(newLeft, newRight);
    }

    protected int doOperation(int left, int right){

        return  left >> right;
    }
}
