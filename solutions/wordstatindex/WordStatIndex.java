package wordstatindex;

import java.io.*;
import java.util.*;

public class WordStatIndex {
    public static void main(String[] args) {
        try {
            int i, indexKeeper = 0, currentNumber;
            LinkedHashMap<String, ArrayList<Integer>> answerMap = new LinkedHashMap<>();
            InputStreamReader reader = new InputStreamReader(new FileInputStream(args[0]), "UTF8");
            MyFastScanner scanIn = new MyFastScanner(reader);
            PrintWriter writer = new PrintWriter(args[1], "UTF8");
            try {
                String lineForEdit;
                while (scanIn.hasNext()) {
                    lineForEdit = scanIn.readNext();
                    lineForEdit = lineForEdit.toLowerCase(); //приведение регистра к строчным буквам
                    if (!lineForEdit.matches("[^\\p{L}\\p{Pd}']")) {
                        String[] stringArr = lineForEdit.split("[^\\p{L}\\p{Pd}']");
                        ArrayList<String> stringList = new ArrayList<>();
                        for (i = 0; i < stringArr.length; i++) {
                            if (!stringArr[i].isEmpty()) {
                                stringList.add(stringArr[i]);
                            }
                        }
                        for (i = 0; i < stringList.size(); i++) {
                            if (!answerMap.containsKey(stringList.get(i))) {
                                ArrayList<Integer> listOfIndexes = new ArrayList<>();
                                listOfIndexes.add(1);
                                listOfIndexes.add(i + 1 + indexKeeper);
                                answerMap.put(stringList.get(i), listOfIndexes);
                            } else {
                                ArrayList<Integer> listOfIndexes = answerMap.get(stringList.get(i));
                                listOfIndexes.add(i + 1 + indexKeeper);
                                currentNumber = listOfIndexes.get(0) + 1;
                                listOfIndexes.set(0, currentNumber);
                                answerMap.put(stringList.get(i), listOfIndexes);
                            }
                        }
                        indexKeeper += stringList.size();
                    } else {
                        throw new InputMismatchException();
                    }
                }
                for (String key : answerMap.keySet()) {
                    writer.write(key);
                    for (i = 0; i < answerMap.get(key).size(); i++){
                        writer.write(" " + answerMap.get(key).get(i));
                    }
                    writer.println();
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("ArrayIndexOutOfBoundsException");
            } catch (InputMismatchException ex) {
                System.out.println("InputMismatchException");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                scanIn.closeNextLineReader(); // закрытие потока
                writer.close(); // закрытие потока
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("IndexOutOfBoundsException");
        } catch (IllegalArgumentException ex) {
            System.out.println("IllegalArgumentException");
        }
    }
}


