
/**
 * Write a description of Part1 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part1 {

    int findStopCodon(String dna, int startIndex, String stopCodon) {
        int firstOccurence = dna.indexOf(stopCodon, startIndex);
        while (startIndex < dna.length() - 3) {
            if (firstOccurence == -1) {
                break;
            }
            if ((firstOccurence - startIndex) % 3 == 0) {
                return firstOccurence;
            }
            startIndex = firstOccurence + 3;
            firstOccurence = dna.indexOf(stopCodon, startIndex);

        }
        return -1;
    }

    String findGene(String dna, int where) {
        int startCodon = dna.indexOf("ATG", where);
        if (startCodon == -1) {
            return "";
        }
        int indexTAA = findStopCodon(dna, startCodon, "TAA");
        int indexTAG = findStopCodon(dna, startCodon, "TAG");
        int indexTGA = findStopCodon(dna, startCodon, "TGA");
        int minIndex;
        if (indexTAA == -1 || (indexTGA != -1 && indexTGA < indexTAA)) {
            minIndex = indexTGA;
        } else {
            minIndex = indexTAA;
        }
        if (minIndex == -1 || (indexTAG != -1 && indexTAG < minIndex)) {
            minIndex = indexTAG;
        }
        if (minIndex == -1) {
            return "";
        }
        return dna.substring(startCodon, (minIndex + 3));
    }

    void printAllGenes(String dna) {
        int startIndex = 0;
        while (true) {
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
    }

    StorageResource getAllGenes(String dna) {
        int startIndex = 0;
        StorageResource sr = new StorageResource();
        while (true) {
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            sr.add(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return sr;
    }

    void printGetAllGenes(String dna) {
        int count = 0;
        StorageResource sr = getAllGenes(dna);
        for (String s : sr.data()) {
            System.out.println(s);
            count = count + 1;
        }
        System.out.println(count);

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

    int countCTG(String dna) {
        int currIndex = 0;
        int index = dna.indexOf("CTG", currIndex);
        int counter = 0;
        while (index != -1) {
            counter++;
            currIndex = index + 3;
            index = dna.indexOf("CTG", currIndex);
        }
        return counter;
    }

    void modifiedprocessGenes(StorageResource sr) {
        int count60Char = 0;
        System.out.println("longer than 60 characters");
        for (String s : sr.data()) {
            if (s.length() > 60) {
                System.out.println(s);
                System.out.println("Length : " + s.length());
                count60Char++;
            }
        }
        System.out.println("number of Strings longer than 60 characters");
        System.out.println(count60Char);

        int countCgRatio = 0;
        System.out.println("whose C-G-ratio is higher than 0.35");
        for (String s : sr.data()) {
            if (cgRatio(s) > 0.35) {
                System.out.println(s);
                countCgRatio++;
            }
        }
        System.out.println("number of strings in sr whose C-G-ratio is higher than 0.35");
        System.out.println(countCgRatio);

        int countDNA = 0;
        int largestLength = 0;
        int lengthOfLongestGene = 0;
        for (String dnaString : sr.data()) {
            StorageResource srAllGene = getAllGenes(dnaString);
            for (String s : srAllGene.data()) {
                int currLength = 0;
                currLength = s.length();
                if (currLength > largestLength) {
                    largestLength = currLength;
                }
                countDNA++;
            }
        }
        System.out.println(largestLength);
        System.out.println(countDNA);

    }

    public static void main(String[] args) {
        Part1 instance = new Part1();

        FileResource fr = new FileResource("part.fa");
        String dna = fr.asString();
        dna = dna.toUpperCase();
        StorageResource sr = new StorageResource();
        sr.add(dna);
        instance.modifiedprocessGenes(sr);
        instance.printGetAllGenes(dna);
        System.out.println(instance.countCTG(dna));
    }
}
