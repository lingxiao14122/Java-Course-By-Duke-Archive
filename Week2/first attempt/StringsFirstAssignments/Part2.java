/**
 * Write a description of Part2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        boolean isLower = false;
        if (dna == dna.toLowerCase()) {
            isLower = true;
            dna = dna.toUpperCase();
        }
        int startIndex = dna.indexOf(startCodon);
        int stopIndex = dna.indexOf(stopCodon, startIndex);
        String returnValue = "";
        if (startIndex == -1 || stopIndex == -1) {
            returnValue = "";
        } else {
            String dnaPrevalid = dna.substring(startIndex, stopIndex + 3);
            if (dnaPrevalid.length() % 3 == 0) {
                System.out.println(dna + " " + startIndex + " " + stopIndex);
                returnValue = dnaPrevalid;
            }
        }
        
        if(isLower) {
            returnValue = returnValue.toLowerCase();
        }

        return returnValue;
    }

    public void testSimpleGene() {

        // five dna string
        String dna1 = "ATTATTGATAA";
        System.out.println(dna1 + " " + findSimpleGene(dna1, "ATG", "TAA"));
        String dna2 = "AAGATGATATAG";
        System.out.println(dna2 + " " + findSimpleGene(dna2, "ATG", "TAA"));
        String dna3 = "ATAGTAGGGAAATTGG";
        System.out.println(dna3 + " " + findSimpleGene(dna3, "ATG", "TAA"));
        String dna4 = "AAAAAATGATTTAGTGATAA";
        System.out.println(dna4 + " " + findSimpleGene(dna4, "ATG", "TAA"));
        String dna5 = "ATGATTTAGTTAA";
        System.out.println(dna5 + " " + findSimpleGene(dna5, "ATG", "TAA"));
        
        String dna6 = "atgctataa";
        System.out.println(dna6 + " " + findSimpleGene(dna6, "ATG", "TAA"));
        String dna7 = "gatgctataat";
        System.out.println(dna7 + " " + findSimpleGene(dna7, "ATG", "TAA"));
    }
    
}
