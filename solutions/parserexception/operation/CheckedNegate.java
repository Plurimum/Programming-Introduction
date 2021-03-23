package parserexception.operation;

import parserexception.TripleExpression;
import parserexception.exceptions.ArithmeticParserException;
import parserexception.exceptions.UnderflowException;

public class CheckedNegate extends AbstractUnaryOperation {
    public CheckedNegate(TripleExpression object) {
        super(object);
    }

    @Override
    protected int doOperation(int object) throws ArithmeticParserException {
        if (object == Integer.MIN_VALUE)
            throw new UnderflowException("Underflow by -(" + object + ")");
        return -object;
    }

}