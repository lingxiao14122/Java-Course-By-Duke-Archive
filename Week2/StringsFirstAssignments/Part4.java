
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class Part4 {
    void findWebLinks() {

        URLResource ul = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");

        for (String s : ul.words()) {
            String sFormat = s.toLowerCase();
            int youtubeOccurence = sFormat.indexOf("youtube.com");
            if (youtubeOccurence != -1) {
                int firstOccurence = sFormat.lastIndexOf("\"", youtubeOccurence);
                int secondOccurence = sFormat.indexOf("\"", youtubeOccurence);
                // System.out.println(youtubeOccurence);
                System.out.println(firstOccurence + " " + youtubeOccurence + " " + secondOccurence);
                // System.out.println(secondOccurence);
                String output = s.substring(firstOccurence, secondOccurence);
                System.out.println(output);
            }


        }
    }

    public static void main(String[] args) {
        Part4 instance = new Part4();
        instance.findWebLinks();
    }

}
