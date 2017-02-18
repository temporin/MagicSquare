import java.util.*;

public class MagicSquare
{
    public boolean isSquare ( int[][] input )
    {
        if ( input.length == input [0].length && input.length * input[0].length / input.length == input[0].length )
        return true;
        else
        return false;

    }

    public int sum ( int[] input )
    {
        int sum = 0;
        for ( int i : input )
            sum += i;
        
        return sum;
    }

    public boolean isMagicSquare ( int[][] input )
    {
        boolean value = false;

        if ( isSquare( input ) )
        {
            int comparedValue = 0;
            int length = input.length;
            int [] values = new int [ length ];

            for ( int counter = 0; counter < length; counter++ )
                values [ counter ] = counter;


            for ( int row = 0; row < length; row++ )
            { 
                int [] rowNum = new int [ length ];
                int [] colNum = new int [ length ];
                int [] diagNum = new int [ length ];

                for ( int index = 0; index < length; index ++ )
                {
                    rowNum [ index ] = input [row][ values [ index ] ];
                    colNum [ index ] = input [ values [ index ] ][row];
                    diagNum [ index ] = input [ values [ index ] ][ values [ index ] ];

                }

                if ( sum(rowNum) != sum(colNum) || sum(rowNum) != sum(diagNum) )
                    break;

                if ( row == length - 1 )
                    value = true;

            }
        }
        
         return value;

    }

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
        if ( !obj.isSquare ( square ) )
            System.out.println ( "Warning: The inputed array isn't a square" );
        else
        {
            for ( int x = 0; x < square.length; x ++ )
            {
                for ( int y = 0; y < square [ 0 ].length; y++ )
                {
                    System.out.println ( "Please input a value for location: " + x + " " + y );
                    square [ x ][ y ] = ss.nextInt();
                }
            }
        
            if ( !obj.isMagicSquare ( square ) )
                System.out.println ( "Sorry this isn't a magic sqaure. " );
            else
                System.out.println ( "This is a magic square! " );
        }

    }

}