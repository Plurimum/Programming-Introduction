package md2html;

import java.io.*;

public class Md2Html {
    JsonSource source;
    private int tagCount(char tag) throws IOException{
        int count = 1;
        while (true) {
            source.nextChar();
            if (Character.isWhitespace(source.getChar()) || source.getChar() == JsonSource.END || source.getChar() == '\n') {
                break;
            }
            count++;
        }
        return count;
    }

    public void parse(String fileIn, String fileOut){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn)))){
            StringBuilder markdownText = new StringBuilder();

            int markdownPos = 0;
            markdownText.append("  ");

            while (markdownPos < markdownText.length()){
                int lastElem = markdownText.charAt(markdownPos++);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getOpeningTag(char tag, int numberOftag){
        switch (tag){
            case '#':
                return "<h" + String.valueOf(numberOftag) + ">";
            case '*' | '_':
                if (numberOftag == 1) {
                    return "<em>";
                } else if (numberOftag == 2){
                    return "<strong>";
                }
            case '-':
                return "<s>";
            case '\'':
                return "<code>";
        }
        return null;
    }

    private String getClosingTag(char tag, int numberOftag){
        switch (tag){
            case '#':
                return "</h" + String.valueOf(numberOftag) + ">";
            case '*' | '_':
                if (numberOftag == 1) {
                    return "</em>";
                } else {
                    return "</strong>";
                }
            case '-':
                return "</s>";
            case '\'':
                return "</code>";
        }
        return null;
    }

    private String getSpecialSymbol (char tag) throws IOException{
        switch (tag){
            case '<':
                return "&lt";
            case '>':
                return "&gt";
            case '&':
                return "&amp;";
            case '\\':
                source.nextChar();
                return String.valueOf(source.getChar());
        }
        return null;
    }

    private String parseString() throws IOException{
        final StringBuilder sb = new StringBuilder();
        while (!test('*') && !test('#') && !test('_') && !test('\n') && !test(JsonSource.END)) {
            sb.append(source.getChar());
            source.nextChar();
        }
        return sb.toString();
    }

    private boolean testNext(final char c) throws IOException{
        if (source.getChar() == c) {
            source.nextChar();
            return true;
        } else {
            return false;
        }
    }

    private boolean test(final char c) {
        return source.getChar() == c;
    }
}
