
/**
 * Write a description of Part2 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringa, String stringb) {
        int occurence = stringb.indexOf(stringa);
        int count = 0;
        // if (occurence != -1) { count++; }
        while (occurence != -1) {
            occurence = stringb.indexOf(stringa, occurence + stringa.length());
            // if (occurence != -1) {
                count++;
            // }
        }
        return count;
    }

    public static void main(String[] args) {
        Part2 instance = new Part2();
        int result = instance.howMany("GAA", "ATGAACGAATTGAATC");
        System.out.println(result);
        result = instance.howMany("AA", "ATAAAA");
        System.out.println(result);

        int num = 3;
        if (num % 2 == 1) { System.out.println("ok"); }
    }

}
