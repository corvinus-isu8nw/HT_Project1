package Egyszeru_titkositas;

import java.io.*;
import java.util.Arrays;

public class Titkosit {

    public static void main(String []args)
            throws IOException {
        BufferedReader inFile = new BufferedReader(new FileReader("eredeti.txt"));
        FileWriter fw = new FileWriter("titok.txt");
        PrintWriter pw = new PrintWriter(fw);

        String line = inFile.readLine();
        char[] c = line.toCharArray();

        String alphabetWithUpper = "abcdefghijklmnopqrstuvwxyz" + "abcdefghijklmnopqrstuvwxyz".toUpperCase();
        char[] letters = alphabetWithUpper.toCharArray();
        Arrays.sort(letters);

        StringBuilder titok = new StringBuilder();
        int index;

        for (char ch:c
             ) {
            index = Arrays.binarySearch(letters, ch);

            if (index == -1) {
                titok.append(ch);
            }
            else if (index<-1){
                throw new IOException("Érvénytelen karakter a bemeneti fájlban");
            }
            else {
                if ((index+1)%26==0){
                    titok.append(letters[index - 25]);
                }
                else {
                    titok.append(letters[index + 1]);
                }
            }
        }
        pw.println(titok);
        pw.close();
        inFile.close();
    }
}
