
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part4 {
    public void findUrlYt() {
        URLResource dukeUrl = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        int counter = 1;

        for (String s : dukeUrl.lines()) {
            // System.out.println(s);
            int findYoutube = s.toLowerCase().indexOf("youtube.com");
            if (findYoutube != -1) {
                int headOccurence = s.lastIndexOf("\"", findYoutube);
                int tailOccurence = s.indexOf("\"", findYoutube);
                String fullUrl = s.substring(headOccurence + 1, tailOccurence);
                // System.out.println(findYoutube + " " + headOccurence + " " + tailOccurence);
                // System.out.println("Line : " + counter + " " + fullUrl); 
                System.out.println(fullUrl); 
                

            }
            counter++;
        }

    }
}
