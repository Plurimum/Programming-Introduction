package parserexception.parser;

import parserexception.TripleExpression;
import parserexception.exceptions.FormatParserException;

public interface Parser {

    TripleExpression parse(String expression) throws FormatParserException;
}