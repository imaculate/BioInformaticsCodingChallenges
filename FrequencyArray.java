import java.util.*;
public class FrequencyArray{
   public static String DNA = "ACGT";
   //DNA strings = ACGT
   public static void main(String[] args){
      Scanner k = new Scanner(System.in);
      //System.out.println(PatternToNumber("ATGCAA"));
      //System.out.println(NumberToPattern(5437 , 7));
      //System.out.println(NumberToPattern(5437 , 8));
      String text = k.nextLine();
      int patternLength = k.nextInt();
      ComputingFrequencies(text, patternLength);
      }
   
   public static int PatternToNumber(String pattern){
      int len = pattern.length();
      int number = 0;
      int pow = 1;
      int ind = len-1;
      while(ind >= 0){
         number  += pow * DNA.indexOf(pattern.charAt(ind));
         ind --;
         pow *= 4;
      }
      return number;
   }
   
   public static String  NumberToPattern(int number, int len){
      int ind = 0;
      String s = "";
      while(ind < len){
         s = DNA.charAt(number%4) + s;
         number = number/4;
         ind++;
      }
      return s;
   }
   
   public static int[] ComputingFrequencies(String text, int k){
      int len = text.length();
      int lenArray = (int)Math.pow(4,k);
      int[] freq = new int[lenArray];
      for(int i = 0 ; i<= len-k; i++){
         freq[PatternToNumber(text.substring(i, i+k))] += 1;
      }
      /*for(int i = 0 ; i< lenArray; i++){
         System.out.print(freq[i]+" ");
      }*/
      return freq;
   }
}