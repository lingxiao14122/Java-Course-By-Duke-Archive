
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    int findStopCodon(String dna, int startIndex, String stopCodon) {
        int firstOccurence = dna.indexOf(stopCodon, startIndex);
        //System.out.println(firstOccurence);
        if ((firstOccurence - startIndex) % 3 == 0) {
            return firstOccurence;
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
        }
        else {
            minIndex = indexTAA;
        }
        if (minIndex == -1 || (indexTAG != -1 && indexTAG < minIndex) ) {
            minIndex = indexTAG;
        }
        if (minIndex == -1) { return ""; }
        return dna.substring(startCodon, minIndex+3);
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

    int countGenes (String dna) {
        int startIndex = 0;
        int count = 0;
        while (true) {
            String currGene = findGene(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            count++;
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return count;
    }

    public static void main(String[] args) {
        Part3 instance = new Part3();
        int num = instance.countGenes("ATGTAAGATGCCCTAGT");
        System.out.println(num);
        num = instance.countGenes("aaaATGaaxxxTGAxxxcTGA");
        System.out.println(num);
        instance.printAllGenes("AATGCTAACTAGCTGACTAAT");
        System.out.println(num);
    }
}
