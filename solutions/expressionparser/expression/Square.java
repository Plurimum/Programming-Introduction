package expressionparser.expression;

public class Square extends AbstractUnaryOperation {

    public Square(TripleExpression arg){
        super(arg);
    }

    protected int doOperation(int arg){

        return arg * arg;
    }
}
