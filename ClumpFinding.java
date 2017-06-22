import java.util.*;
import java.io.*;

public class ClumpFinding{
   static int[] freqArray;
   static int[] Clump;
   public static void main(String[] args) throws FileNotFoundException{
      Scanner sc = new Scanner(new File("E_coli.txt"));
      String text = sc.next();
      int k = 9;//sc.nextInt();
      int L = 500;//sc.nextInt();
      int t = 3;//sc.nextInt();
      int chars = (int)Math.pow(4, k);
      
      Clump = new int[chars];
      freqArray = FrequencyArray.ComputingFrequencies(text.substring(0, L), k);
      for(int i = 0; i< chars; i++){
         if(freqArray[i] >= t){
            Clump[i] = 1;
         }
      }
      for(int i =1 ; i <= text.length()-L ; i++){
          int left = FrequencyArray.PatternToNumber(text.substring(i-1, i+k-1));
          int right = FrequencyArray.PatternToNumber(text.substring(i+L-k,i+L));
         freqArray[left]--;
         freqArray[right]++;
         if(freqArray[right]>= t){
            Clump[right] = 1;
         }    
      }
      int count = 0;
      for(int i = 0; i< chars; i++){
         if(Clump[i] == 1){
            count++;
            String s = FrequencyArray.NumberToPattern(i, k);
            System.out.print(s+ " ");
         }
      }
       System.out.println();
      System.out.println(count);
      
      
   }
}