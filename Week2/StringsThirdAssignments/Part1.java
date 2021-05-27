
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part1 {
    int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        while (currIndex != -1) {
            if ((currIndex - startIndex) % 3 == 0) {
                return currIndex;
            }
            // stop codon not valid, search again for stop codon
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
        }
        // unable to find stop codon
        return -1;
    }

    String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1)
            return "";
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int minIndex;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        } else {
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        if (minIndex == -1) {
            return "";
        }
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

    StorageResource getAllGenes(String dna) {
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while (true) {
            String currDna = findGene(dna, startIndex);
            if (currDna.isEmpty())
                break;
            geneList.add(currDna);
            startIndex = dna.indexOf(currDna, startIndex) + currDna.length();
        }
        return geneList;
    }

    double cgRatio(String dna) {
        int count = 0;
        for (char c : dna.toCharArray()) {
            if (c == 'C' || c == 'G') {
                count++;
            }
        }
        return ((double) count) / dna.length();
    }

    int countGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        while (true) {
            int currDna = dna.indexOf("CTG", startIndex);
            if (currDna == -1)
                break;
            count++;
            startIndex = currDna + 3;
        }
        return count;
    }

    void processGenes(StorageResource sr) {
        System.out.println("longer than 60 characters");
        int count1 = 0;
        for (String s : sr.data()) {
            if (s.length() > 60) {
                System.out.println(s);
                count1++;
            }
        }
        System.out.println("number longer than 60 characters");
        System.out.println(count1);
        System.out.println("C-G-ratio is higher than 0.35");
        int count2 = 0;
        for (String s : sr.data()) {
            if (cgRatio(s) > 0.35) {
                System.out.println(s);
                count2++;
            }
        }
        System.out.println("number C-G-ratio is higher than 0.35");
        System.out.println(count2);
        System.out.println("longest gene in sr");
        int maxLength = 0;
        for (String s : sr.data()) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        System.out.println(maxLength);
        System.out.println("how many genes");
        System.out.println(sr.size());
        System.out.println("=======================================================");

    }

    void testGetAllGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        StorageResource sr = getAllGenes(dna);
        for (String s : sr.data()) {
            System.out.println(s);
        }
        dna = "ATGATCATAAGAAGATAATAGAGGGCCATGTAA";
        sr = getAllGenes(dna);
        for (String s : sr.data()) {
            System.out.println(s);
        }
    }

    void testCountGenes() {
        String dna = "CTGAAACTGAACTGAAACTGAACTGAAACTGAACTGAAACTGAA";
        System.out.println(countGenes(dna));
    }

    void testProcessGenes() {
        String dna;
        dna = "ATGGCCGCCTAA";
        processGenes(getAllGenes(dna));
        dna = "ATGTAA";
        processGenes(getAllGenes(dna));
        dna = "ATGCGCCGCCGCCGCCGCCGCTAATTTATGATTCGGTAA";
        processGenes(getAllGenes(dna));
        dna = "ATGTATTATTATTATTATTATTATTATTAA";
        processGenes(getAllGenes(dna));
        dna = "ATGTAA|||ATGGCTGCTTAA|||ATGGCTGCTGCTGCTTAA";
        processGenes(getAllGenes(dna));
    }

    public static void main(String[] args) {
        Part1 inst = new Part1();
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        StorageResource sr = inst.getAllGenes(dna);
        inst.processGenes(sr);
        
    }
}
