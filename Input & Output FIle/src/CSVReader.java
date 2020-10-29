import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    static String csv = "";
    static String csv2 = "";
    static ArrayList<String> num = new ArrayList<>();
    public static int numberOfRows(){
        int rows = 0;
        for (int i = 0; i < csv.length(); i++){
            if (csv.charAt(i) == '"' && csv.charAt(i + 1) == ','){
                rows++;
            }
        }
        return rows;
    }
    public static int numberOfColumns(Scanner scan){

        int columns = 0;
        int counter = 0;
        while (scan.hasNext()){
            csv += scan.next();
        }
        for (int i = 0; i < csv.length(); i++){
            if (csv.charAt(i) == ',' && (csv.charAt(i + 1) == '"')){
                for (int j = i; j < csv.length(); j++){
                    if (csv.charAt(j) == '"' && csv.charAt(j + 1) == ','){
                        counter++;
                        break;
                    }else{
                        counter++;
                    }
                }
                columns++;
                i = i + counter;
            }
            else if (csv.charAt(i) == ',' && !(csv.charAt(i + 1) == ',')){
                columns++;
            }
            else if (csv.charAt(i) == ',' && csv.charAt(i + 1) == ','){
                columns++;
                break;
            }
        }
        return columns;
    }
    public static String statistics(Scanner scan){
        int counter = 0;
        int counter2 = 1;
        List<String> numbers = Arrays.asList(csv.split(","));
        for (int i = 0; i < numbers.size(); i++){
            if (counter >= 2 && counter <= 6 && !(numbers.get(i) == "")){
                num.add(numbers.get(i));
                counter++;
            }
            else if(!(numbers.get(i) == "")){
                counter++;
            }
            if (counter > 10){
                counter = 0;
                counter2++;
                i = 11 * counter2;
            }
        }
        for (int i = 0; i < num.size(); i++){
            csv2 += num.get(i);
        }
        return csv2;
    }
    public static String fields(int column, int row){
        return "Rows: " + row + " Columns: " + column;
    }
}
