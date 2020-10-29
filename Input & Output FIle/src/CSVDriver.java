import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVDriver extends CSVReader{
    public static void main(String[] args)throws FileNotFoundException {
        File inputFIle = new File("C:\\Users\\jgold\\eclipse-workspace\\Lab10\\src\\sample.csv");
        Scanner sc = new Scanner(inputFIle);
        System.out.println(fields(numberOfColumns(sc), numberOfRows()));
        System.out.println(statistics(sc));
    }
}
