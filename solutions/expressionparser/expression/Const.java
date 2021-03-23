package expressionparser.expression;

public strictfp class Const implements TripleExpression {

    private final int value;

    public Const(int newValue) {

        value = newValue;
    }

    public int evaluate(int x, int y, int z) {

        return value;
    }

}