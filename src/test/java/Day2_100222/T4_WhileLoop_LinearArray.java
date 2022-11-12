package Day2_100222;

public class T4_WhileLoop_LinearArray {

    public static void main(String[] args) {

        //declare and define linear array for street number
        int[] streetNumber = new int[]{111,333,444,555,666,777};
        //iterate through all street number by while loop
        //set the initializer
        int i = 0;
        //now set the condition for while loop
        //linear array gets the county by using .length command
        while(i < streetNumber .length) {
            System.out.println("Street Number: + streetNumber[i]");

            //incrementation goes at the end of the while loop
            i++;

        }//end of while loop

    }//end of main
}//end of java class
