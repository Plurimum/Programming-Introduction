package wordstat;

import java.util.*;
import java.io.*;

public class WordStatWords {

    public static void main(String[] args) {
        try {
            int i, currentNumber;
            TreeMap<String, Integer> mapOfCountOfWords = new TreeMap<>();
            InputStreamReader reader = new InputStreamReader(new FileInputStream(args[0]), "UTF8");
            Scanner scanIn = new Scanner(reader);
            PrintWriter writer = new PrintWriter(args[1], "UTF8");
            try {
                String lineForEdit;
                while (scanIn.hasNextLine()) {
                    lineForEdit = scanIn.nextLine();
                    lineForEdit = lineForEdit.toLowerCase(); //приведение регистра к строчным буквам
                    if (!lineForEdit.matches("[^\\p{L}\\p{Pd}']")) {
                        String[] stringArr = lineForEdit.split("[^\\p{L}\\p{Pd}']");
                        for (i = 0; i < stringArr.length; i++) {
                            if (!stringArr[i].isEmpty()) {
                                if (!mapOfCountOfWords.containsKey(stringArr[i])) {
                                    mapOfCountOfWords.put(stringArr[i], 1);
                                } else {
                                    currentNumber = mapOfCountOfWords.get(stringArr[i]);
                                    mapOfCountOfWords.put(stringArr[i], currentNumber + 1);
                                }
                            }
                        }
                    } else {
                        throw new InputMismatchException();
                    }
                }
                for (String key : mapOfCountOfWords.keySet()) {
                    writer.write(key + " " + mapOfCountOfWords.get(key));
                    writer.println();
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("ArrayIndexOutOfBoundsException");
            } catch (InputMismatchException ex) {
                System.out.println("InputMismatchException");
            } finally {
                scanIn.close(); // закрытие потока
                writer.close(); // закрытие потока
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("IndexOutOfBoundsException");
        } catch (IllegalArgumentException ex) {
            System.out.println("IllegalArgumentException");
        }
    }
}
