package expressionparser.parser;

import expressionparser.expression.*;

public interface Parser {

    TripleExpression parse(String expression);
}
