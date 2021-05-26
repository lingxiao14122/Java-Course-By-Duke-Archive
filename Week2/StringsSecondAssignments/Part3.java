/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part3 {
    int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            if ( (currIndex - startIndex) % 3 == 0 ) {
                return currIndex;
            }
            // stop codon not valid, search again for stop codon
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
        }
        // unable to find stop codon
        return dna.length();
    }

    String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1)
            return "";
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        if (minIndex == dna.length())
            return "";
        return dna.substring(startIndex, minIndex + 3);
    }

    void printAllGenes(String dna) {
        int startIndex = 0;
        while (true) {
            String currDna = findGene(dna, startIndex);
            if (currDna.isEmpty())
                break;
            System.out.println(currDna);
            startIndex = dna.indexOf(currDna, startIndex) + currDna.length();
        }
    }

    int countGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        while (true) {
            String currDna = findGene(dna, startIndex);
            if (currDna.isEmpty())
                break;
            count++;
            startIndex = dna.indexOf(currDna, startIndex) + currDna.length();
        }
        return count;
    }

    void testCountGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        System.out.println("DNA : " + dna);
        System.out.println( countGenes(dna) );
        
    }

    public static void main(String[] args) {
        Part3 inst = new Part3();
        inst.testGetAllGenes();
    }

}
