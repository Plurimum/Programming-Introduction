package reversemax;

import java.util.*;

public class ReverseMax {
    public static void main(String args[]) {
        Scanner scanIn = new Scanner(System.in);
        String line;
        int i, j, curMaxOfLine, numberOfColumn = -1;
        String[] strArrForEdit;
        ArrayList<String> linesList = new ArrayList<String>();
        ArrayList<Integer[]> numbersList = new ArrayList<Integer[]>();
        while (scanIn.hasNextLine()) {
            line = scanIn.nextLine();
            linesList.add(line);
            strArrForEdit = line.split(" ");
            if (strArrForEdit.length > numberOfColumn) {
                numberOfColumn = strArrForEdit.length;
            }
        }
        Integer[] maxOfLine = new Integer[linesList.size()];
        Integer[] maxOfColumn = new Integer[numberOfColumn];
        for (i = 0; i < numberOfColumn; i++) {
            maxOfColumn[i] = Integer.MIN_VALUE;
        }
        for (j = 0; j < linesList.size(); j++) {
            strArrForEdit = linesList.get(j).split(" ");
            if (linesList.get(j).isEmpty()) {
				numbersList.add(null);
                continue;
            } else {
                Integer[] intArrForEdit = new Integer[strArrForEdit.length];
                curMaxOfLine = Integer.MIN_VALUE;
                for (i = 0; i < strArrForEdit.length; i++) {
                    intArrForEdit[i] = Integer.parseInt(strArrForEdit[i]);
                    if (intArrForEdit[i] > curMaxOfLine) {
                        curMaxOfLine = intArrForEdit[i];
                    }
                    if (intArrForEdit[i] > maxOfColumn[i]) {
                        maxOfColumn[i] = intArrForEdit[i];
                    }
                }
                maxOfLine[j] = curMaxOfLine;
                numbersList.add(intArrForEdit);
            }
        }
        for (i = 0; i < linesList.size(); i++) {
            if (linesList.get(i).isEmpty()) {
                System.out.println();
				continue;
            } else {
                for (j = 0; j < numbersList.get(i).length; j++) {
                    System.out.print(Math.max(maxOfColumn[j], maxOfLine[i]) + " ");
                }
				System.out.println();
            }
        }
    }
}