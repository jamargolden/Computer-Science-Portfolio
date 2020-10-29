import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HTMLConverter {
    public static void write_header(PrintWriter p){
        p.println("<html>");
        p.println("<title>");
        p.println("This is my Java html converter");
        p.println("</title>");
        p.println("<body>");


    }
    public static String write_footer(PrintWriter p, Scanner s){
        String str = "";
        while (s.hasNextLine()){
            str = s.nextLine();
            p.println("<p>" + str + "<p>" + "<br>");
        }
        p.println("</body>");
        p.println("</html>");
        p.close();
        return str;
    }
    public static void main(String[] args) throws FileNotFoundException{
        File input = new File("C:\\Users\\jgold\\eclipse-workspace\\Lab10\\src\\myfile.txt");
        Scanner sc = new Scanner(input);
        PrintWriter out = new PrintWriter("myfile.html");
        write_header(out);
        write_footer(out, sc);
    }
}
