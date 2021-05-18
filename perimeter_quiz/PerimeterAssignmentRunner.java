import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int counterPoint = 0;
        // Use for loop to ierate all points
        for (Point p : s.getPoints()) {
            //increment the counter
            counterPoint++;
        }
        return counterPoint;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double ave;
        ave = getPerimeter(s)/getNumPoints(s);
        return ave;
    }

    public double getLargestSide(Shape s) {
        // Start with largestPerim = 0
        double largestPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            System.out.println(currDist);
            if (currDist > largestPerim) {
                largestPerim = currDist;
            }
        }
        return largestPerim;
    }

    public double getLargestX(Shape s) {
        double largestX = 0;
        
        for (Point point : s.getPoints()) {
            double p = point.getX();
            if (p > largestX) {
                largestX = p;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            System.out.println("currPerimeter: " + currPerimeter);
            if(currPerimeter > largestPerimeter) {
                largestPerimeter = currPerimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0;
        String fileWithLargestPerimeter = "";
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            System.out.println("currPerimeter: " + currPerimeter);
            System.out.println("largestPerimeter: " + largestPerimeter);
            System.out.println("f.getName(): " +  f.getName());
            if(currPerimeter > largestPerimeter) {
                largestPerimeter = currPerimeter;
                fileWithLargestPerimeter = f.getName();
            }
        }
        return fileWithLargestPerimeter;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("number of points = " + numPoints);
        double aveLength = getAverageLength(s);
        System.out.println("The average length of all sides is = " + aveLength);
        double largestSide = getLargestSide(s);
        System.out.println("The largest sides is = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("The largest X of all sides is = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeterMultipleFiles = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter in multiple files is: " + largestPerimeterMultipleFiles);
    }

    public void testFileWithLargestPerimeter() {
        String fileWithLargestPerimeter= getFileWithLargestPerimeter();
        System.out.println("Largest perimeter within multiple file is: " + fileWithLargestPerimeter);
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        //pr.testFileWithLargestPerimeter();
    }
}
