package wordstatindex;

import java.io.*;


public class MyFastScanner {
    public BufferedReader nextLine;

    public MyFastScanner(InputStreamReader reader) {
        nextLine = new BufferedReader(reader);
    }

    public String readNext() throws IOException {
        return nextLine.readLine();
    }

    public void closeNextLineReader() throws IOException {
        nextLine.close();
    }

    public boolean hasNext() throws IOException {
        return nextLine.ready();
    }
}
