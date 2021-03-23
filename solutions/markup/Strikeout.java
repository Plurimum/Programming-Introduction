package markup;

import java.util.List;

public class Strikeout extends Paragraph {

    Strikeout(List<Paragraph> list) {
        super(list);
    }

    void toMarkdown(StringBuilder sb){
        sb.append("~");
        super.toMarkdown(sb);
        sb.append("~");
    }

    void toHtml(StringBuilder sb){
        sb.append("<s>");
        super.toHtml(sb);
        sb.append("</s>");
    }

    public String getText(){
        return super.getText();
    }
}
