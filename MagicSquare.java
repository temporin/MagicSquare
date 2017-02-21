import java.util.*;

//Takes user inputted array; Check if it is a Magic Square 
//Jonathan Nguyen Per 4A

//start class MagicSquare
public class MagicSquare
{
    //checks if initial dimensions are in square shape
    //start method isSquare
    public boolean isSquare ( int[][] input )
    {
        if ( input.length == input [0].length && input.length * input[0].length / input.length == input[0].length )
        return true;
        else
        return false;

    }//end method isSquare

    //sums together a row/col/diag/ect as long as it is in array form
    //start method sum
    public int sum ( int[] input )
    {
        int sum = 0;
        for ( int i : input )
            sum += i;
        
        return sum;
    }//end method sum

    //employs previous two methods to check if it is a magic square
    //start method isMagicSquare
    public boolean isMagicSquare ( int[][] input )
    {
        boolean value = false;

        if ( isSquare( input ) )
        {
            int length = input.length; //ease of use; saves time from retyping
            int [] values = new int [ length ]; //populates an array that contains the index locations

            //implements the location array
            for ( int counter = 0; counter < length; counter++ )
                values [ counter ] = counter;


            for ( int row = 0; row < length; row++ )
            { 
                int [] rowNum = new int [ length ]; //each section gets an array to be passed into sum method
                int [] colNum = new int [ length ]; //^^
                int [] diagNum = new int [ length ]; //^^
                int [] reverseDiag = new int [ length ]; //^^

                //populates the above arrays
                for ( int index = 0; index < length; index ++ )
                {
                    rowNum [ index ] = input [row][ values [ index ] ];
                    colNum [ index ] = input [ values [ index ] ][row];
                    diagNum [ index ] = input [ values [ index ] ][ values [ index ] ];
                    reverseDiag [ index ] = input [ values [ index ] ][ values [ length - 1 - index ] ];
                }
          
                //compares the output to check if it is a magic square
                // if not:
                if ( sum(rowNum) != sum(colNum) || sum(rowNum) != sum(diagNum) || sum(rowNum) != sum(reverseDiag) || sum(colNum) != sum(reverseDiag) )
                    break;

                //fail safe against logical errors; only sets the returned value to true if it completes the entire loop
                if ( row == length - 1 )
                    value = true;

            }
        }
        
         return value;

    }//end method isMagicSquare

    //start main method
    public static void main ( String[] args )
    {
        int lengthX = 0;
        int lengthY = 0;

        Scanner ss = new Scanner ( System.in );
        MagicSquare obj = new MagicSquare();

        System.out.println ( "What is the x dimension of your array?" );
        lengthX = ss.nextInt();
        System.out.println ( "What is the y dimension of your array?" );
        lengthY = ss.nextInt();

       int[][] square = new int [lengthX][lengthY];

       //initial check for square shape
        if ( !obj.isSquare ( square ) )
            System.out.println ( "Warning: The inputed array isn't a square" );
        else
        {

            //populates the array one location at a time
            for ( int x = 0; x < square.length; x ++ )
            {
                for ( int y = 0; y < square [ 0 ].length; y++ )
                {
                    System.out.println ( "Please input a value for location: " + x + " " + y );
                    square [ x ][ y ] = ss.nextInt();
                }
            }
        
            //interprets the result of isMagicSquare and returns a message accordingly
            if ( !obj.isMagicSquare ( square ) )
                System.out.println ( "Sorry this isn't a magic sqaure. " );
            else
                System.out.println ( "This is a magic square! " );

           //print the square
            for ( int[] a : square )
            {
                int counter = 0;
                for ( int i : a)
                {
                    counter++;
                    if ( counter == square.length )
                        System.out.println ( i );
                    else
                        System.out.print ( i + "\t" );
                }
            }
        
        }

    }//end main method

}//end class MagicSquare