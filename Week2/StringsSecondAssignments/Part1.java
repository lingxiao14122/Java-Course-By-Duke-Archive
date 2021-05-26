
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
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

    void testFindStopCodon() {
        //            ⬇  ⬇  ⬇  ⬇  ⬇  ⬇  ⬇
        String dna = "ATCATGTCCATAATTTAATAA";
        System.out.println(findStopCodon(dna, 0, "TAA"));
        //     ⬇  ⬇  ⬇  ⬇  ⬇  ⬇  ⬇
        dna = "ATCATGTCCATACTTTACTAC";
        System.out.println(findStopCodon(dna, 0, "TAA"));
        //     ⬇  ⬇  ⬇  ⬇  ⬇  ⬇  ⬇
        dna = "ATCATGTCCATACTTTACTAA";
        System.out.println(findStopCodon(dna, 0, "TAA"));
        //     ⬇  ⬇  ⬇  ⬇  ⬇  ⬇  ⬇
        dna = "ATCATGTCCATACTTTACTAA";
        System.out.println(findStopCodon(dna, 1, "TAA"));
    }

    void testFindGene() {
        String dna;
        // no ATG
        dna = "ATTCTGACTGTACGGTAA";
        System.out.println( findGene(dna, 0) );
        // ATG and one stop codon
        dna = "ATGCTGACTGTACGGTAA";
        System.out.println( findGene(dna, 0) );
        // ATG and multiple stop codon
        //     ***            ***      ***    
        dna = "ATGCTGACTGTACGGTGAGTATGCTAA";
        System.out.println( findGene(dna, 0) );
        // no valid stop codon
        dna = "ATGCTGATTTGGTCCAACAAG";
        System.out.println( findGene(dna, 0) );
        // start codon not at index 0
        //       ⬇  ⬇  ⬇  ⬇  ⬇  ⬇  ⬇  ⬇  ⬇  
        dna = "AAATGCTGATTTGGTCCAACAAGAATTAA";
        System.out.println( findGene(dna, 0) );
    }

    void testPrintAllGenes() {
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        System.out.println("DNA : " + dna);
        printAllGenes(dna);
    }

    public static void main(String[] args) {
        Part1 inst = new Part1();
        // inst.testFindStopCodon();
        // inst.testFindGene();
        inst.testPrintAllGenes();
    }
}
