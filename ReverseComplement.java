import java.util.*;
public class ReverseComplement{
   public static Map<Character, Character> mapping = new HashMap<Character, Character>();
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);

      System.out.println(reverseComplement(k.nextLine()));
   }
   public static String reverseComplement(String Pattern){
      fillMap();
      String s = "";
      for(int i = 0; i< Pattern.length(); i++){
         s = mapping.get(Pattern.charAt(i)) + s;
      }
      return s;
   
  }

    public static void fillMap(){
        mapping.put('A', 'T');
        mapping.put('C', 'G');
        mapping.put('G', 'C');
        mapping.put('T', 'A');
    }
}