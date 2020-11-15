package sample;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggesArrayUtilityTestSTUDENT {

    private double[][] dataSet1 = {{1, 2, 3}, {4, 5}, {6, 7, 8}};
    private double[][] dataSet2 = {{5, 0, 7, 2}, {3}, {6, -1, 1}, {9, 4, 5, 0}};//The 2 ragged array that will be tested

    private File inputFile, outputFile;//To hold the file input and output

    @Before
    public void setUP() throws Exception {
        outputFile = new File("new.txt");//Creating a new file
    }

    @After
    public void tearDown() throws Exception {
        dataSet1 = dataSet2 = null;
        inputFile = outputFile = null;
    }

    /**
     * Test getTotal method
     * Returns the total of all the elements in the two dimensional array
     */
    @Test
    public void testGetTotal() {
        assertEquals(36.0, TwoDimRaggedArrayUtility.getTotal(dataSet1), .001);
        assertEquals(41.0, TwoDimRaggedArrayUtility.getTotal(dataSet2), .001);
    }

    /**
     * Test getAverage method
     * Returns the average of all the elements in the two dimensional array
     */
    @Test
    public void testGetAverage() {
        assertEquals(4.5, TwoDimRaggedArrayUtility.getAverage(dataSet1), .001);
        assertEquals(3.417, TwoDimRaggedArrayUtility.getAverage(dataSet2), .001);
    }

    /**
     * Test getRowTotal method
     * Returns the total of all the elements of the row.
     * Row 0 refers to the first row in the two dimensional array
     */
    @Test
    public void testGetRowTotal() {
        assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(dataSet1, 0), 0.01);
        assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(dataSet2, 2), 0.01);
    }

    /**
     * Test getColumnTotal method
     * Returns the total of all the elements in the column. If a row in the two dimensional array
     * doesn't have this column index, it is not an error, it doesn't participate in this method.
     * Column 0 refers to the first column in the two dimensional array
     */
    @Test
    public void testGetColumnTotal() {
        assertEquals(11, TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, 0), 0.01);
        assertEquals(3, TwoDimRaggedArrayUtility.getColumnTotal(dataSet2, 1), 0.01);
    }

    /**
     * Test getHighestInRow method
     * Returns the largest of all the elements in the row.* Row 0 refers to the first row in the two dimensional array
     */
    @Test
    public void testGetHighestInRow() {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0), .001);
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet2, 2), .001);

    }

    /**
     * Test getHighestInRowIndex method
     * Returns the index of the largest of all the elements in the row.
     * Row 0 refers to the first row in the two dimensional array
     */
    @Test
    public void testGetHighestInRowIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2, 2));
    }

    /**
     * Test getLowestInRowIndex method
     * Returns the index of the smallest of all the elements in the row.
     * Row 0 refers to the first row in the two dimensional array
     */
    @Test
    public void testGetLowestInRowIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2, 2));
    }

    /**
     * Test getLowestInRow method
     * Returns the smallest of all the elements in the row.
     * Row 0 refers to the first row in the two dimensional array
     */
    @Test
    public void testGetLowestInRow() {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 2), .001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet2, 1), .001);
    }

    /**
     * Test getHighestInColumn method
     * Returns the largest of all the elements in the column. If a row in the two dimensional array
     * doesn't have this column index, it is not an error, it doesn't participate in this method.
     * Column 0 refers to the first column in the two dimensional array
     */
    @Test
    public void testGetHighestInColumn() {
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 2), .001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2, 1), .001);
    }

    /**
     * Test getHighestInColumn method
     * Returns the index of the largest of all the elements in the column. If a row in the two dimensional array
     * doesn't have this column index, it is not an error, it doesn't participate in this method.
     * Column 0 refers to the first column in the two dimensional array
     */
    @Test
    public void testGetHighestInColumnIndex() {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 2));
        assertEquals(3, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2, 1));
    }

    /**
     * Test getLowestInColumn method
     * Returns the smallest of all the elements in the column. If a row in the two dimensional array
     * doesn't have this column index, it is not an error, it doesn't participate in this method.
     * Column 0 refers to the first column in the two dimensional array
     */

    @Test
    public void testGetLowestInColumn() {
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 1), .001);
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2, 2), .001);
    }

    /**
     * Test getLowestInColumnIndex method
     * Returns the index of the smallest of all the elements in the column. If a row in the two dimensional array
     * doesn't have this column index, it is not an error, it doesn't participate in this method.
     * Column 0 refers to the first column in the two dimensional array
     */

    @Test
    public void testGetLowestInColumnIndex() {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2, 2));
    }

    /**
     * Test getHighestInArray method
     * Returns the largest of all the elements in the two dimensional array.
     */
    @Test
    public void testGetHighestInArray() {
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet1), .001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet2), .001);

    }

    /**
     * Test getLowestInArray method
     * Returns the smallest of all the elements in the two dimensional array.
     */
    @Test
    public void testGetLowestInArray() {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet1), .001);
        assertEquals(-1, TwoDimRaggedArrayUtility.getLowestInArray(dataSet2), .001);
    }

    /**
     * Test the writeToFile method
     * write the array to the outputFile File
     * then read it back to make sure formatted correctly to read
     *
     */
    @Test
    public void testWriteToFile() throws FileNotFoundException {
        double[][] array=null;
        try {
            TwoDimRaggedArrayUtility.writeToFile(dataSet1, outputFile);
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
        array = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertEquals(1, array[0][0],.001);
        assertEquals(2, array[0][1],.001);
        assertEquals(3, array[0][2],.001);
        assertEquals(4, array[1][0],.001);
        assertEquals(5, array[1][1],.001);
        assertEquals(6, array[2][0],.001);
        assertEquals(7, array[2][1],.001);
        assertEquals(8, array[2][2],.001);

    }
    /**
     * Test the readFile method
     * reads from a file and then test that the returned two dimensional array of doubles
     * is ragged.
     */
    @Test
    public void testReadFile() {
        double[][] array=null;
        try {
            inputFile = new File("Test1.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.print("1 2 3\n" +
                    "4 5\n" +
                    "6 7 8 ");
            inFile.close();
            array = TwoDimRaggedArrayUtility.readFile(inputFile);
            assertEquals(1, array[0][0],.001);
            assertEquals(2, array[0][1],.001);
            assertEquals(3, array[0][2],.001);
            assertEquals(4, array[1][0],.001);
            assertEquals(5, array[1][1],.001);
            assertEquals(6, array[2][0],.001);
            assertEquals(7, array[2][1],.001);
            assertEquals(8, array[2][2],.001);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            fail("This should not have caused an FileNotFoundException");
        }

        //testing that the array is a ragged array
        try{
            assertEquals(0.0, array[1][2],.001);
            fail("This should have caused a ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e){

            assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            fail("This should not have caused an Exception");
        }

        //testing that the array is a ragged array
        try{
            assertEquals(0.0, array[2][3],.001);
            fail("This should have caused a ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e){

            assertTrue("Correctly threw ArrayIndexOutOfBoundsException", true);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            fail("This should not have caused an Exception");
        }
    }

}