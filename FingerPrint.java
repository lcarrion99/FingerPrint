import java.util.Scanner;        
import java.io.IOException;      
import java.io.File;             

public class FingerPrint {
    private String[][] data;
    private String name;
    private int year;
    private int rows;
    private int cols;

    public FingerPrint(String filename) throws IOException {

        Scanner in = new Scanner(new File(filename));

        this.name = in.nextLine();                   
        this.year = Integer.parseInt(in.nextLine()); 
        this.rows = Integer.parseInt(in.nextLine().trim());
        this.cols = Integer.parseInt(in.nextLine().trim());

        this.data = new String[this.rows][this.cols];

        for (int i = 0; i < this.rows; i++) {
            String[] line = in.nextLine().split("");
            for (int j = 0; j < this.cols; j++) {
                this.data[i][j] = line[j];
            }
        }

        in.close();
    }

    public FingerPrint(String[][] data, String name, int year, int rows, int cols) {
        this.data = data;
        this.name = name;
        this.year = year;
        this.rows = rows;
        this.cols = cols;
    }

    public boolean equals(FingerPrint other) {

        if (this.rows != other.rows || this.cols != other.cols) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!this.data[i][j].equals(other.data[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public String toString() {
        return "Fingerprint for " + name +
               ". Year registered: " + year +
               ". Number of pixels: " + getNumberOfPixels();
    }

    public int getNumberOfPixels() {
        return rows * cols;
    }

    public void getImage() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }

    public String[][] getData() { return data; }
    public String getName() { return name; }
    public int getYear() { return year; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }

 
    public void setData(String[][] data) { this.data = data; }
    public void setName(String name) { this.name = name; }
    public void setYear(int year) { this.year = year; }
    public void setRows(int rows) { this.rows = rows; }
    public void setCols(int cols) { this.cols = cols; }
}
