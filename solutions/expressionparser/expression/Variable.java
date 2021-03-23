package expressionparser.expression;

public class Variable implements TripleExpression {

    String name;

    public Variable(String newName) {

        name = newName;
    }

    public int evaluate(int x, int y, int z) {

        if (name.contentEquals("x")) {
            return x;
        } else {
            if (name.contentEquals("y")) {
                return y;
            } else {
                return z;
            }

        }
    }
}