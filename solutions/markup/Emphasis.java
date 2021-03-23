package markup;

import java.util.List;

public class Emphasis extends Paragraph {

    Emphasis(List<Paragraph> list){
        super(list);
    }

    void toMarkdown(StringBuilder sb){
        sb.append("*");
        super.toMarkdown(sb);
        sb.append("*");
    }

    void toHtml(StringBuilder sb){
        sb.append("<em>");
        super.toHtml(sb);
        sb.append("</em>");
    }

    public String getText(){
        return super.getText();
    }
}
