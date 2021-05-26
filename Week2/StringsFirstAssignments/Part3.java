
/**
 * Write a description of Part3 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part3 {
    boolean twoOccurrences(String stringa, String stringb) {
        int firstOccurence = stringb.indexOf(stringa);
        if (firstOccurence == -1)
            return false;

        int secondOccurence = stringb.indexOf(stringa, firstOccurence);
        if (secondOccurence == -1)
            return false;

        // second occurence is not -1, means more than one occurence happened
        return true;

    }
    
    String lastPart(String stringa, String stringb) {
        int firstOccurence = stringb.indexOf(stringa);
        if (firstOccurence == -1)
            return stringb;
        return stringb.substring(firstOccurence + stringa.length());
    }

    void testMethod() {
        // twoOccurrences
        System.out.println( twoOccurrences("by", "A story by Abby Long") );
        System.out.println( twoOccurrences("a", "banana") );
        System.out.println( twoOccurrences("atg", "ctgtatgta") );
        // last part
        System.out.println( lastPart("an", "banana") );
        System.out.println( lastPart("zoo", "forest") );
    }

    public static void main(String[] args) {
        Part3 inst = new Part3();
        inst.testMethod();
    }
}
