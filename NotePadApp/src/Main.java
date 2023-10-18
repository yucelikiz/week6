import java.io.*;
import java.util.Scanner;

public class Main {

    public static void WriteText() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Yeni bir not giriniz : ");
        String text = scan.nextLine();

        try {
            FileWriter fileWriter = new FileWriter("notlar.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(text);
            printWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ReadText() {

        try {
            FileReader fileReader = new FileReader("notlar.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null ) {
                System.out.println("Önceki notunuz : " + line);
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        ReadText();
        WriteText();


    }
}