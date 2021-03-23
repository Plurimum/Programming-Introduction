package markup;

import java.util.List;

public class Strong extends Paragraph{
    Strong(List<Paragraph> list) {
        super(list);
    }

    void toMarkdown(StringBuilder sb){
        sb.append("__");
        super.toMarkdown(sb);
        sb.append("__");
    }

    void toHtml(StringBuilder sb){
        sb.append("<strong>");
        super.toHtml(sb);
        sb.append("</strong>");
    }

    public String getText(){
        return super.getText();
    }
}
