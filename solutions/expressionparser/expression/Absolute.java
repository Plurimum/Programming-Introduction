package expressionparser.expression;

public class Absolute extends AbstractUnaryOperation{

    public Absolute(TripleExpression arg){

        super(arg);
    }
    protected int doOperation(int arg){

        return Math.abs(arg);
    }
}
