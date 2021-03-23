package markup;

public class Text extends Paragraph {

    private String text;

    Text(String string){
        text = string;
    }

    public String getText(){
        return text;
    }

    void toMarkdown(StringBuilder sb){
        sb.append(text);
    }

    void toHtml(StringBuilder sb){
        sb.append(text);
    }
}
