import java.util.Scanner;

public class HammingDistance {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String Pattern = sc.nextLine();
        String Text = sc.nextLine();
        int d = sc.nextInt();
        int k = Pattern.length();
        int count = 0;
        for(int i = 0; i<= Text.length()- k ; i++){
            String s = Text.substring(i, i+k);
            if(distance(s, Pattern)<=d){
                count++;
                System.out.print(i+" ");
            }
        }
        System.out.println("\n"+ count);

    }

    public static int distance(String s1, String s2){
        int count = 0;
        for(int i = 0; i< s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
        }
        //System.out.println(count);
        return count;
    }
}
