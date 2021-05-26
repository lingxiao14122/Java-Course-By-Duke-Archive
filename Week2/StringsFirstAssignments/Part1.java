
/**
 * Write a description of Part1 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part1 {
    String findSimpleGene(String dna) {
        // find the index of ATG, number of startCodon is position of A
        int startCodon = dna.indexOf("ATG");

        if (startCodon == -1)
            return "";

        // find the index of TAA, number of stopCodon is position of T
        int stopCodon = dna.indexOf("TAA", startCodon);

        if (stopCodon == -1)
            return "";

        if ((stopCodon - startCodon) % 3 == 0)
            // if dna codons are nultiple of 3, return the dna as string
            return dna.substring(startCodon, stopCodon + 3);

        // dna codon is not multiple of 3, return no string
        return "";
    }

    void testFindSimpleGene() {
        // DNA with no “ATG”
        String dna = "ATTGGATAA";
        System.out.println("DNA : " + dna);
        System.out.println(findSimpleGene(dna));
        // DNA with no “TAA”
        dna = "ATGGGATTT";
        System.out.println("DNA : " + dna);
        System.out.println(findSimpleGene(dna));
        // DNA with no “ATG” or “TAA”
        dna = "GAATTATTA";
        System.out.println("DNA : " + dna);
        System.out.println(findSimpleGene(dna));
        // DNA with ATG, TAA and the substring between them is a multiple of 3
        dna = "ATGCCGTAA";
        System.out.println("DNA : " + dna);
        System.out.println(findSimpleGene(dna));
        // DNA with ATG, TAA and the substring between them is not a multiple of 3
        dna = "ATGTTTAATAA";
        System.out.println("DNA : " + dna);
        System.out.println(findSimpleGene(dna));
        //
        dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA : " + dna);
        System.out.println(findSimpleGene(dna));
    }

    public static void main(String[] args) {
        Part1 inst = new Part1();
        inst.testFindSimpleGene();
    }
}
