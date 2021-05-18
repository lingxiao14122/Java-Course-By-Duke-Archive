
/**
 * Write a description of Part3 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb) {
        // first occurence
        int stringbFirst = stringb.indexOf(stringa);
        //System.out.println(stringbFirst);
        // second occurence
        int stringbSecond = stringb.indexOf(stringa, stringbFirst+stringa.length());
        //System.out.println(stringbSecond);
        if(stringbSecond == -1)
            return false;
        return true;
    }
    
    public String lastPart(String stringa, String stringb) {
        int occurence = stringb.indexOf(stringa);
        if (occurence == -1) {
            return stringb;
        }
        return stringb.substring(occurence, occurence+3);
    }

    public void testTwoOccurences() {
        System.out.println(twoOccurrences("by", "A story by Abby Long"));
        System.out.println(twoOccurrences("a", "banana"));
        System.out.println(twoOccurrences("atg", "ctgtatgta"));
        System.out.println(lastPart("an", "banana"));
        System.out.println(lastPart("zoo", "forest"));
    }


}
