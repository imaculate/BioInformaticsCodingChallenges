import java.util.*;

public class FindingOri{
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      
      /*String text = k.nextLine();
      String pattern = k.nextLine();
      System.out.println(patternCount(text, pattern));*/
      
      String text = k.nextLine();
      int patternLength = k.nextInt();
      frequentWords(text, patternLength);
   }
   
   public static int patternCount(String text, String pattern){
      int k = pattern.length();
      int count = 0;
      for(int i = 0; i <= text.length()-k; i++){
         if(text.substring(i, i+k).equals(pattern)){
            count++;
         }
      }
      return count;
   }
   
   public static void frequentWords( String text, int k){
      Map<String, Integer> map = new HashMap<String, Integer>();
      String pattern;
      int maxCount = 0, count = 0;
      for(int i = 0; i <= text.length()-k; i++){
         pattern = text.substring(i, i+k);
         if( !map.containsKey(pattern)){
            count = patternCount(text, pattern);
            map.put( pattern,  count);
            maxCount = (count > maxCount)? count : maxCount;                        
         }
      }
      for( String key : map.keySet()){
         if (map.get(key) == maxCount)
            System.out.print(key+" ");
      }
   } 
}