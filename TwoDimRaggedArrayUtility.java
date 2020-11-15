/**
 * @author Almamy Aguibou Bah
 */
package sample;
import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

    /**
     * The default constructor to instantiate the class
     * @throws IOException
     */
    public TwoDimRaggedArrayUtility() throws IOException {

    }

    /**
     * To read all the element in a file
     * @param file
     * @return the information in the file
     * @throws FileNotFoundException
     */
    public static double[][] readFile(File file) throws FileNotFoundException{

        int count=0;// to count the number of row in the file

        Scanner inputFile= new Scanner(file); // Scanner object to read the file

        //To find the number of row in the array
        while (inputFile.hasNextLine()){
            inputFile.nextLine();
            count++;
        }

        //A ragged array to hold the information retrieved in the file
        double [] [] ragged=new double[count][];

        // To reset the scanner at the beginning because of the while loop
        //that run it all the way to the end
        try{
            inputFile= new Scanner(file);
        }catch (IOException exception){
            System.out.println(exception);
            return null;
        }

        //A nested for loop to go through all the element of the file
        for(int i=0; i<count; i++){
            //To read a line of the file
            String s=inputFile.nextLine();

            //To split the different element of the file in order
            //To number of element in each column
            String [] tokens= s.split(" ");

            //Setting the size of each row
            ragged [i]= new double[tokens.length];

            //Filling the array
            for(int j=0; j<ragged[i].length; j++){
                ragged[i][j]= Double.parseDouble(tokens[j]);
            }

        }

        //Closing the file
        inputFile.close();
        return ragged;
    }

    /**
     * To write in a file
     * @param data
     * @param file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void writeToFile(double [] [] data, File file) throws FileNotFoundException, IOException {

        //Creating a fileWriter and printWriter to write into the file
        FileWriter fileWriter= new FileWriter(file,true);
        PrintWriter printWriter= new PrintWriter(fileWriter);


        //A nested for loop to go through all the element of the file
        for(int i=0; i<data.length; i++){

            for(int j=0; j<data[i].length; j++){
                printWriter.print((data[i][j])+ " ");
            }
            printWriter.println();
        }

        //Closing the file;
        fileWriter.close();
    }

    /**
     * To return the average value of the array
     * @param data
     * @return
     */
    public static double getAverage(double [][] data){

        //Accumulator
        double total=0;

        //To get the number of element in the array
        int count=0;

        //A nested loop to go through the jagged array
        for(int i=0; i<data.length; i++){
            for (int j=0; j<data [i].length; j++){
                total+=data[i][j];
                count ++;
            }
        }

        //Returning the average;
        return total/count;
    }

    /**
     * a static method to find the total in a specific column
     * @param data
     * @param col
     * @return
     */
    public static double getColumnTotal(double [][] data, int col) {
        //Accumulator
        double totalInColumn=0;

        //For loop to go through the different column
        for(int i=0; i<data.length; i++) {

            //To avoid an out of bound error
            if (col >= data[i].length) {
                continue;
            }

            totalInColumn += data[i][col];
        }

        //Returning the value find
        return totalInColumn;
    }

    /**
     * To find the highest element in the array
     * @param data
     * @return
     */
    public static double getHighestInArray(double [][] data){

        //To hold the value of the higest value in the array
        double higest= Integer.MIN_VALUE;


        //Loop to go through all the array
        for(int i=0; i<data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                //if statement to compare the values
                if (data[i][j] > higest) {
                    higest = data[i][j];
                }
            }
        }
        //returning the highest element
        return higest;
    }

    /**
     * To find the highest element in a given column
     * @param data
     * @param col
     * @return
     * @throws ArrayIndexOutOfBoundsException
     */
    public static double getHighestInColumn(double [][] data, int col)throws ArrayIndexOutOfBoundsException{

        //To hold the highest value in the column
        double highestInColumn= Integer.MIN_VALUE;

        //A loop to go through the array
        for(int i=0; i<data.length; i++) {

            //To avoid an out of bound exception
            if (col >= data[i].length){
                continue;
            }
            //Comparing the differents values in the array
            else if(highestInColumn<data[i][col]){
                highestInColumn= data[i][col];
            }
        }

        //Returning the higest element
        return highestInColumn;
    }

    /**
     * to return the index of the highest element in a column
     * @param data
     * @param col
     * @return
     */
    public static int getHighestInColumnIndex(double[][]data, int col){
        //To hold the highest value in the column
        double highestInColumn= Integer.MIN_VALUE;

        //To hold the index of the highest element
        int highestInColumnIndex=0;

        //A loop to go through the array
        for(int i=0; i<data.length; i++) {

            //to avoid an out of bound exception
            if(col>=data[i].length){
                continue;
            }

            //Comparing all the element of the column
            else if(highestInColumn<data[i][col]){
                highestInColumn=data[i][col];
                highestInColumnIndex= i;
            }
        }

        //Returning the index of the highest element
        return highestInColumnIndex;
    }

    /**
     * a static method to find the value of the highest number in a row
     * @param data the ragged array
     * @param row
     * @return the highest value in the row
     */
    public static double getHighestInRow (double [][]data, int row){

        //To hold the highest number in the row
        double highestInRow=Integer.MIN_VALUE;

        //To go through all the different element of the row
        for(int i=0; i<data[row].length; i++){

            //Comparing the different element of the row
            if(highestInRow<data[row][i]){
                highestInRow=data[row][i];
            }
        }
        //Returning the highest element
        return highestInRow;
    }

    /**
     * Find the highest element index in a row
     * @param data
     * @param row
     * @return the highest index in a row
     */
    public static int getHighestInRowIndex(double[] [] data, int row){

        //To hold the highest element in the row
        double highestInRow=data[row][0];

        int highestInRowIndex=0; //To hold the index of the higest element

        //To go through the different column of a specific row
        for(int i=0; i<data[row].length; i++){
            if(highestInRow<data[row][i]){
                highestInRow=data[row][i];
                highestInRowIndex=i;
            }
        }
        return highestInRowIndex;
    }

    /**
     * to return the value of the lowest number in the array
      * @param data
     * @return the lowest value in the array
     */
    public static double getLowestInArray(double[][] data){
        //To hold the value of the lowest value in the array
        double lowest= data[0][0];

        //Loop to go through all the array
        for(int i=0; i<data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                //if statement to compare the values
                if (data[i][j] < lowest) {
                    lowest = data[i][j];
                }
            }
        }
        //returning the lowest element
        return lowest;

    }

    /**
     *  to find the value of the lowest number in a column
      * @param data
     * @param col
     * @return the lowest element in a column
     */
    public static double getLowestInColumn(double[][]data, int col){

//To hold the lowest value in the column
        double lowestInColumn= Integer.MAX_VALUE;

        for(int i=0; i<data.length; i++) {
            if(col>=data[i].length){
                continue;
            }

            else if(lowestInColumn>data[i][col]){
                lowestInColumn=data[i][col];
            }
        }
        return lowestInColumn;
    }

    /**
     *  to return the index of the lowest element in a column
      * @param data
     * @param col
     * @return the lowest index in the column
     */
    public static int getLowestInColumnIndex(double [][]data, int col){

        //To hold the lowest  value in the column
        double LowestInColumn= Integer.MAX_VALUE;
        int highestInColumnIndex=0;

        for(int i=0; i<data.length; i++) {

            //To avoid an out of bound error
            if(col>=data[i].length){
                continue;
            }

            //Comparing the different element in a column
            else if(LowestInColumn>data[i][col]){
                LowestInColumn=data[i][col];
                highestInColumnIndex= i;
            }
        }
        return highestInColumnIndex;
    }

    /**
     * a static method to find the lowest element in a row
     * @param data
     * @param row
     * @return the lowest element in a row
     */
    public static double getLowestInRow(double [][]data, int row){
        //To hold the lowest element in the row
        double lowestInRow=data[row][0];

        //To go through the different column of a specific row
        for(int i=0; i<data[row].length; i++){

            //Comparing the different element of a row
            if(lowestInRow>data[row][i]){
                lowestInRow=data[row][i];
            }
        }
        return lowestInRow;
    }

    /**
     * to return the index of the lowest element in a row
     * @param data
     * @param row
     * @return the index of the lowest element in a row
     */
    public static int getLowestInRowIndex(double [][]data, int row){
        //To hold the lowest element in the row
        double lowestInRow=data[row][0];

        int lowestIndex=0; //To hold the index of the lowest element

        //To go through the different column of a specific row
        for(int i=0; i<data[row].length; i++){
            if(lowestInRow>data[row][i]){
                lowestInRow=data[row][i];
                lowestIndex=i;
            }
        }
        return lowestIndex;
    }

    /**
     * to return the sum all the element  of a row
     * @param data
     * @param row
     * @return the total in a row
     */
    public static double getRowTotal(double [][]data, int row){

        double totalRow=0;// Accumulator To hold the total in the row;


        //To go through the different column of a specific row
        for(int i=0; i<data[row].length; i++){
            totalRow+=data[row][i];
        }

        //Returning the total
        return totalRow;
    }

    /**
     * to return the sum of all the element in the array
     * @param data
     * @return
     */
    public static double getTotal(double [][]data){
        //Accumulator
        double total=0;

        //A nested loop to go through all the element of the array
        for(int i=0; i<data.length; i++){
            for (int j=0; j<data [i].length; j++){
                total+=data[i][j];
            }
        }
        //Returning the total ;
        return total;
    }
}
