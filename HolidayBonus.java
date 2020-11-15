package sample;

public class HolidayBonus {

    /**
     * a default constructor to instantiate the class
     */
    public HolidayBonus() {
    }

    /**
     * a double static method to give the bonus that each store obtained
     * @param data
     * @param high
     * @param low
     * @param other
     * @return the bonus on each row
     */
    public static double [] calculateHolidayBonus(double [][] data, double high, double low, double other){

        //The array that will return the bonus of each store
        double [] bonus= new double[data.length];

        //Nested for loop to go through all the array
        for (int i=0; i<data.length; i++){
            for(int j=0; j<data[i].length; j++){

                //To avoid an out of bound exception
                if(data[i][j]<0){
                    continue;
                }

                //if else statement to give the bonus depending of how much they made
             if(i==TwoDimRaggedArrayUtility.getHighestInColumnIndex(data,j)){
                 bonus[i]+=high;
             }
             else if( i==TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,j)){
                 bonus[i]+=low;
             }
             else
                 bonus[i]+=other;
           }
        }

        //Returning the one dimensional array
        return bonus;
    }

    /**
     * a double method to return the sum of all the bonuses given
     * @param data
     * @param high
     * @param low
     * @param other
     * @return the total of all the bonuses
     */
    public static double calculateTotalHolidayBonus(double [][]data, double high, double low, double other){

     //Using the array filled by the previous method.
      double [] bonus=calculateHolidayBonus(data, high, low, other);

      //accumulator
      double total=0;

      //A for loop to go through all the element of the array
        for(int i=0; i<data.length; i++){
           total+= bonus[i];
        }

        //To return the total of all the bonuses
        return total;
    }
}
