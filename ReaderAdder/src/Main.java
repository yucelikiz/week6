import java.io.*;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        try {
            FileReader fileReader = new FileReader("number.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int number = Integer.parseInt(line);

                total += number;

            }
            fileReader.close();
            bufferedReader.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

        System.out.println("Toplam :" + total);

    }
}