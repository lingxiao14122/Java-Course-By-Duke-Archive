
/**
 * Write a description of parsing_export here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class Part1 {
    public String countryInfo(CSVParser parser, String country) {
        // loop over all row
        for (CSVRecord record : parser) {
            // get country column
            String colCountry = record.get("Country");
            if (colCountry.contains(country)) {
                // country : list of export : export value
                String exports = record.get("Exports");
                String value = record.get("Value (dollars)");
                return country + " : " + exports + " : " + value;
            }
        }
        // finished loop but no return yet
        return "NOT FOUND";
    }

    public void listExportersTwoProdicts(CSVParser parser, String exportItem1, String exportItem2) {
        // loop all row
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
        // end of loop
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int numOfCountry = 0;
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                numOfCountry++;
            }
        }
        return numOfCountry;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            if (value.length() > amount.length()) {
                String country = record.get("Country");
                System.out.println( country + " " + value );
            }
        }
        //end of loop
    }

    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();

        System.out.println( countryInfo(parser, "Germany") );
        
        parser = fr.getCSVParser();
        listExportersTwoProdicts(parser, "gold", "diamonds");

        parser = fr.getCSVParser();
        System.out.println( numberOfExporters(parser, "gold") );

        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    }

    public void quiz() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();

        // System.out.println( countryInfo(parser, "Germany") );
        System.out.println( countryInfo(parser, "Nauru") );
        
        parser = fr.getCSVParser();
        listExportersTwoProdicts(parser, "gold", "diamonds");

        parser = fr.getCSVParser();
        System.out.println( numberOfExporters(parser, "sugar") );

        parser = fr.getCSVParser();
        // bigExporters(parser, "$999,999,999");

        bigExporters(parser, "$999,999,999,999");
    }

    public static void main(String[] args) {
        Part1 inst = new Part1();
        inst.tester();
    }

}
