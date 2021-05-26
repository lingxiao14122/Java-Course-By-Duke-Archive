
/**
 * Write a description of Part2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2 {
    String findSimpleGene(String dna, String startCodon, String stopCodon) {
        // covert dna to uppercase
        String dnaUpper = dna.toUpperCase();

        boolean isLowerCase = false;
        // check if dna input is lower case
        if (dna != dnaUpper)
            isLowerCase = true;

        // find the index of ATG, number of startCodon is position of A
        int startIndex = dnaUpper.indexOf(startCodon);

        if (startIndex == -1)
            return "";

        // find the index of TAA, number of stopCodon is position of T
        int stopIndex = dnaUpper.indexOf(stopCodon, startIndex);

        if (stopIndex == -1)
            return "";

        String returnDna;
        if ((stopIndex - startIndex) % 3 == 0) {
            // if dnaUpper codons are nultiple of 3, return the dnaUpper as string
            if (isLowerCase) {
                // if lowercase, use original lowercase dna
                returnDna = dna.substring(startIndex, stopIndex + 3);
            } else {
                returnDna = dnaUpper.substring(startIndex, stopIndex + 3);
            }
            return returnDna;
        }
        // dna codon is not multiple of 3, return no string
        return "";
    }

    void testFindSimpleGene() {
        // DNA with no “ATG”
        String dna = "ATGGGTTAAGTC";
        System.out.println("DNA : " + dna);
        System.out.println(findSimpleGene(dna, "ATG", "TAA"));
        dna = "gatgctataat";
        System.out.println("DNA : " + dna);
        System.out.println(findSimpleGene(dna, "ATG", "TAA"));
    }

    public static void main(String[] args) {
        Part2 instance = new Part2();
        instance.testFindSimpleGene();
    }
}
