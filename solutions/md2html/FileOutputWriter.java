package md2html;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOutputWriter {
    String nameOfFile = "";
    PrintWriter writer;

    public void write(String nameOfFile, String text) throws IOException{
        writer = new PrintWriter(new File(nameOfFile), "UTF-8");
        writer.write(text);
    }
}
