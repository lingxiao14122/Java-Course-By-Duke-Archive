
/**
 * Write a description of Part1 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1 {
    int findStopCodon(String dna, int startIndex, String stopCodon) {
        int firstOccurence = dna.indexOf(stopCodon, startIndex);
        //System.out.println(firstOccurence);
        if ((firstOccurence - startIndex) % 3 == 0) {
            return firstOccurence;
        }
        return -1;
    }

    void testFindStopCodon() {
        // > > > > > > >
        String dna = "xxxcccTAAbbbnnnmmmTAA";
        int result = findStopCodon(dna, 0, "TAA");
        System.out.println(result);
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

    void testFindGene() {
        String dna1 = "asdjakldjasdnaskdaskdjad";
        System.out.println("dna1 : ");
        printAllGenes(dna1); 
        String dna2 = "aaaATGaaaxxxTGA";
        System.out.println("dna2 : ");
        printAllGenes(dna2); 
        String dna3 = "aaaATGaaaxxxTAG";
        System.out.println("dna3 : ");
        printAllGenes(dna3); 
        String dna4 = "aaaATGaaaxxxTGA";
        System.out.println("dna4 : ");
        printAllGenes(dna4); 
        
        //start to stop codon not multiple of 3
        String dna5 = "aaaATGaaxxxTGA";
        System.out.println("dna5 : ");
        printAllGenes(dna5); 
        String dna6 = "aaaATGaaxxxTAG";
        System.out.println("dna6 : ");
        printAllGenes(dna6); 
        String dna7 = "aaaATGaaxxxTGA";
        System.out.println("dna7 : ");
        printAllGenes(dna7); 

        //multiple occurences //one wrong stop codon then one corrent stop codon //fail due to find stop codon no repeat search
        String dna8 = "aaaATGaaxxxTGAxxxcTGA";
        System.out.println("dna8 : ");
        printAllGenes(dna8); 
        String dna9 = "aaaATGaaxxxTAGxxxcTAG";
        System.out.println("dna9 : ");
        printAllGenes(dna9); 
        String dna10 = "aaaATGaaxxxTGAxxxcTGA";
        System.out.println("dna10 : " );
        printAllGenes(dna10);
        
        String dna11 = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        System.out.println("dna11 : " );
        printAllGenes(dna11);
        


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

    public static void main(String[] args) {
        new Part1().testFindGene();
    }

}
