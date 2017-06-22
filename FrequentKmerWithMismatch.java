import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FrequentKmerWithMismatch {
    public static List<String> nucleotides = Arrays.asList("A", "C","G","T");
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String Text = sc.nextLine();
        int k = sc.nextInt();
        int d = sc.nextInt();
        ApproximatePatternCountWithReverseComplement(Text, d,k);
        //ApproximatePatternCount(Text,d,k);
        /*List<String> neighbors = Neighbours(Pattern, d);
        for(String neighbor: neighbors){
            System.out.println(neighbor);
        }*/

    }

    public static void ApproximatePatternCount(String Text, int d, int k){
        int maxCount = 0;
        int[] freqArray = new int[(int)Math.pow(4,k)];
        for(int i = 0; i<= Text.length()-k; i++){
            String Pattern = Text.substring(i, i+k);
            List<String> neighbors = Neighbours(Pattern, d);
            for(String neighbour: neighbors){
                int index = FrequencyArray.PatternToNumber(neighbour);
                freqArray[index]++;
                maxCount = (freqArray[index] > maxCount)? freqArray[index] : maxCount;
            }
        }

        for(int i = 0; i< freqArray.length; i++){
            if(freqArray[i] == maxCount){
                System.out.print(FrequencyArray.NumberToPattern(i, k)+ " ");
            }
        }
    }

    public static void ApproximatePatternCountWithReverseComplement(String Text, int d, int k){
        int maxCount = 0;
        int[] freqArray = new int[(int)Math.pow(4,k)];
        for(int i = 0; i<= Text.length()-k; i++){
            String Pattern = Text.substring(i, i+k);
            List<String> neighbors = Neighbours(Pattern, d);
            for(String neighbour: neighbors){
                int index = FrequencyArray.PatternToNumber(neighbour);
                freqArray[index]++;
                maxCount = (freqArray[index] > maxCount)? freqArray[index] : maxCount;
            }

            String Reverse = ReverseComplement.reverseComplement(Pattern);
            neighbors = Neighbours(Reverse, d);
            for(String neighbour: neighbors){
                int index = FrequencyArray.PatternToNumber(neighbour);
                freqArray[index]++;
                maxCount = (freqArray[index] > maxCount)? freqArray[index] : maxCount;
            }
        }

        for(int i = 0; i< freqArray.length; i++){
            if(freqArray[i] == maxCount){
                System.out.print(FrequencyArray.NumberToPattern(i, k)+ " ");
            }
        }
    }


    public static List<String> Neighbours(String Pattern, int d){
        if(d == 0){
            return Arrays.asList(Pattern);
        }
        if (Pattern.length() == 1){
            return new ArrayList<String>(nucleotides);
        }
        List<String> neighbors = new ArrayList<String>();
        String suffixPattern = Pattern.substring(1);
        List<String> suffixNeighbors = Neighbours(suffixPattern, d);
        for(String suffixNeighbour: suffixNeighbors){
            if(HammingDistance.distance(suffixNeighbour, suffixPattern) < d){
                for(String nucleotide : nucleotides ){
                    neighbors.add(nucleotide + suffixNeighbour);
                }
            } else { //distance = d since it is guaranteed to be in the neighbourhood
                    neighbors.add(Pattern.charAt(0) + suffixNeighbour);
            }
        }

        return neighbors;
    }

    public static List<String> ExactNeighbours(String Pattern, int d){
        if(d == 0){
            return Arrays.asList(Pattern);
        }
        if (Pattern.length() == 1){
            return new ArrayList<String>(nucleotides);
        }
        List<String> neighbors = new ArrayList<String>();
        String suffixPattern = Pattern.substring(1);
        List<String> suffixNeighbors = Neighbours(suffixPattern, d);
        for(String suffixNeighbour: suffixNeighbors){
            if(HammingDistance.distance(suffixNeighbour, suffixPattern) < d){
                for(String nucleotide : nucleotides ){
                    neighbors.add(nucleotide + suffixNeighbour);
                }
            } else { //distance = d since it is guaranteed to be in the neighbourhood
                neighbors.add(Pattern.charAt(0) + suffixNeighbour);
            }
        }

        return neighbors;
    }
}
