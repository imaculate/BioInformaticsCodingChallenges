import java.util.Scanner;

public class Skew {

   public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       String s = sc.nextLine();//"TAAAGACTGCCGAGAGGCCAACACGAGTGCTAGAACGAGGGGCGTAAACGCGGGTCCGAT";//
       int[] counts = new int[s.length()+1];
       int count = 0;
       int minCount = Integer.MAX_VALUE;
       //System.out.print(count);
       for(int i = 0; i< s.length(); i++){
           if(s.charAt(i)== 'G'){
               count+= 1;
           }  else if (s.charAt(i)== 'C'){
                count-=1;
                minCount = Math.min(count, minCount);
           }
           counts[i+1] = count;
           //System.out.print(" "+ count);
       }

       for(int i = 0; i<=s.length(); i++){
           if(counts[i]==minCount){
               System.out.print(i+ " ");
           }
       }

   }
}
