
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class Part2 {
    // 1
    public CSVRecord coldestHourInFile(CSVParser parser) {
        // coldest is null
        CSVRecord coldestRecord = null;
        for (CSVRecord currentRecord : parser) {
            // if coldest null coldest is first record
            // if (coldestRecord == null) {
            //     coldestRecord = currentRecord;
            // }
            // // coldest not colder than current, current is coldest
            // else {
            //     double coldestTemp = Double.parseDouble(coldestRecord.get("TemperatureF"));
            //     double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
            //     if (currentTemp < coldestTemp) {
            //         coldestRecord = currentRecord;
            //     }
            // }

            coldestRecord = getLowestOfTwo(coldestRecord, currentRecord, "TemperatureF");

        }
        return coldestRecord;
    }

    public CSVRecord getLowestOfTwo(CSVRecord lowestRecord, CSVRecord currentRecord, String columnName) {
        //
        if (lowestRecord == null) {
            lowestRecord = currentRecord;
        }
        else {
            
        }
    }

    public void testColdestHourInFile() {
        FileResource fr = new FileResource("nc_weather\\2014\\weather-2014-01-01.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println(coldest.get("TimeEST") + " " + coldest.get("TemperatureF"));

    }

    // 2.
    public String fileWithColdestTemperature() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord coldestRecord = null;
        String coldestFile = null;

        // loop to find file with coldest temperature
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRecord = coldestHourInFile(fr.getCSVParser());

            if (coldestRecord == null) {
                coldestRecord = currentRecord;
            } else {
                double coldestTemp = Double.parseDouble(coldestRecord.get("TemperatureF"));
                double currentTemp = Double.parseDouble(currentRecord.get("TemperatureF"));
                if (currentTemp < coldestTemp) {
                    coldestRecord = currentRecord;
                    coldestFile = f.getName();
                }
            }
        }

        // return file name
        return coldestFile;
    }

    public void testFileWithColdestTemperature() {
        String filename = fileWithColdestTemperature();
        FileResource fr = new FileResource("nc_weather\\2014\\" + filename);

        // print out
        System.out.println("Coldest day was in file " + filename);
        String coldestTemp = coldestHourInFile(fr.getCSVParser()).get("TemperatureF");
        System.out.println("Coldest temperature on that day was " + coldestTemp);
        System.out.println("All the Temperatures on the coldest day were:");

        for (CSVRecord currentRecord : fr.getCSVParser()) {
            System.out.println(currentRecord.get("DateUTC") + " " + currentRecord.get("TemperatureF"));
        }
    }

    // 3.
    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestRecord = null;
        for (CSVRecord currentRecord : parser) {

            if (lowestRecord.get("Humidity").equals("N/A")) {
                break;
            }

            if (lowestRecord == null) {
                lowestRecord = currentRecord;
            }
            double lowestHumidity = Double.parseDouble(lowestRecord.get("Humidity"));
            double currentHumidity = Double.parseDouble(currentRecord.get("Humidity"));

            if (currentHumidity < lowestHumidity) {
                lowestRecord = currentRecord;
            }
        }

        return lowestRecord;
    }

    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);

        // print result
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    // 4.
    public CSVRecord lowestHumidityInManyFiles() {
        DirectoryResource dr = new DirectoryResource();
        CSVRecord lowestRecord = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            CSVRecord currentRecord = lowestHumidityInFile(parser);
            if (lowestRecord == null) {
                lowestRecord = currentRecord;
            } else {
                double lowestHumidity = Double.parseDouble(lowestRecord.get("Humidity"));
                double currentHumidity = Double.parseDouble(currentRecord.get("Humidity"));

                if (currentHumidity < lowestHumidity) {
                    lowestRecord = currentRecord;
                }
            }

        }
        return lowestRecord;
    }

    public void testLowestHumidityInManyFiles() {
        CSVRecord lowestHumidity = lowestHumidityInManyFiles();
        String humidity = lowestHumidity.get("Humidity");
        String dateUTC = lowestHumidity.get("DateUTC");
        System.out.println("Lowest Humidity was " + humidity + " at " + dateUTC);
    }

    // 5.
    public double averageTemperatureInFile(CSVParser parser) {
        double totalTemp = 0;
        for (CSVRecord record : parser) {
            double currTemp = Double.parseDouble(record.get("TemperatureF"));
            totalTemp = totalTemp + currTemp;
        }
        // return divided average value
        return totalTemp / 24;
    }

    public void testAverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + avgTemp);
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double totalTemp = 0;
        int counter = 0;
        for (CSVRecord record : parser) {
            double currHumidity = Double.parseDouble(record.get("Humidity"));
            // humidity was greater than or equal to value
            if (currHumidity >= value) {
                double currTemp = Double.parseDouble(record.get("TemperatureF"));
                totalTemp = totalTemp + currTemp;
                counter++;
            }

        }
        // if no temp with high humidity
        if (counter == 0) {
            return 0;
        }

        return totalTemp / counter;

    }

    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avg = averageTemperatureWithHighHumidityInFile(parser, 80);
        if (avg == 0) {
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average Temp when high Humidity is " + avg);
        }
    }

    public static void main(String[] args) {
        Part2 inst = new Part2();
        // inst.testColdestHourInFile();
        // inst.testFileWithColdestTemperature();
        // inst.testLowestHumidityInFile();
        // inst.testLowestHumidityInManyFiles();
        // inst.testAverageTemperatureInFile();
        // inst.testAverageTemperatureWithHighHumidityInFile();
    }

}
