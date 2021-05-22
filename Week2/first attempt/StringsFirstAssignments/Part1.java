
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        String returnValue = "";
        if (startIndex == -1){
            returnValue = "";
        } else {
            int stopIndex = dna.indexOf("TAA",startIndex);
            if (stopIndex == -1){
                returnValue = "";
            } else {
                String dnaPrevalid = dna.substring(startIndex,stopIndex+3);
                System.out.println(dna + " " + startIndex + " " + stopIndex);
                if (dnaPrevalid.length()%3 == 0){
                    returnValue = dnaPrevalid;
                }
            }
        }
        
        
        return returnValue;
    }
    
    public void testSimpleGene(){
        //five dna string
        String dna1 = "ATTATTGATAA";
        System.out.println(dna1 + " " + findSimpleGene(dna1));
        String dna2 = "AAGATGATATAG";
        System.out.println(dna2 + " " + findSimpleGene(dna2));
        String dna3 = "ATAGTAGGGAAATTGG";
        System.out.println(dna3 + " " + findSimpleGene(dna3));
        String dna4 = "AAAAAATGATTTAGTGATAA";
        System.out.println(dna4 + " " + findSimpleGene(dna4));
        String dna5 = "ATGATTTAGTTAA";
        System.out.println(dna5 + " " + findSimpleGene(dna5));
    }

}
