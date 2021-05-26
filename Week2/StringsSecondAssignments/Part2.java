
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    int howMany(String stringa, String stringb) {
        int occurence = stringb.indexOf(stringa);
        int count = 0;
        while (occurence != -1) {
            count ++;
            occurence = stringb.indexOf(stringa, occurence + stringa.length());
        }
        return count;
    }

    void testHowMany() {
        System.out.println( howMany("GAA", "ATGAACGAATTGAATC") );
        System.out.println( howMany("AA", "ATAAAA") );
        System.out.println( howMany("ABC", "ABCABCABCABCABCABCABCABCABCABC") );
    }

    public static void main(String[] args) {
        Part2 inst = new Part2();
        inst.testHowMany();
    }
}
