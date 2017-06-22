import java.util.*;
import java.io.*;

public class PatternMatching{
   public static void main(String[] args) throws FileNotFoundException{
      Scanner k = new Scanner(new File("Vibrio_cholerae"));
      String Pattern = k.nextLine();
      String Genome = k.nextLine();
      matchPatterns(Pattern, Genome);
   }
   
   public static void matchPatterns(String Pattern, String Genome){
      int index = 0;
      int a = Genome.length();
      int b = Pattern.length();
      while (index < a - b + 1){
         if(Genome.substring(index, index + b).equals(Pattern)){
            System.out.print(index+" ");
           
         }
         index++;
      }
   }
}