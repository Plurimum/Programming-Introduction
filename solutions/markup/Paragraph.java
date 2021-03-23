package markup;

import java.util.List;

public class Paragraph {

    private String paragraph;
    private String markdown;
    private String html;
    private List<Paragraph> paragraphList;

    Paragraph(List<Paragraph> list){
        paragraphList = list;
        setParagraph();
    }

    Paragraph(){
    }

    void setParagraph(){
        paragraph = "";
        markdown = "";
        html = "";
        StringBuilder sb = new StringBuilder();
        for (Paragraph string : paragraphList) {
            paragraph += string.getText();
            sb.setLength(0);
            string.toMarkdown(sb);
            markdown += sb.toString();
            sb = new StringBuilder();
            string.toHtml(sb);
            html += sb.toString();
            sb.setLength(0);
        }
    }

    String getText(){
        return paragraph;
    }

    void toMarkdown(StringBuilder sb){
        sb.append(markdown);
    }

    void toHtml(StringBuilder sb){
        sb.append(html);
    }
}
