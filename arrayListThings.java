import java.util.*;

public class arrayListThings
{
    public static void main ( String[] args ) 
    {
        List<Integer> theNums = new ArrayList<Integer>();

        int counter = 0;
        for ( int num = 1; num <= 8; num++ )
        {
            if ( counter % 2 == 0 )
            {
                for ( int numLoop = 1; numLoop < 3; numLoop++ )
                    theNums.add( new Integer ( num ) );
            }
            else
            {
                for ( int numLoop = 1; numLoop < 4; numLoop++ )
                    theNums.add( new Integer ( num ) );
            }
            counter++;

        }

        int sum = 0;
        for ( Integer i : theNums )
        {
            sum += i;
        }
        System.out.println ( sum );

        for ( int index = 0; index < 20; index ++ )
        {
            if ( theNums.get( index ) % 2 != 0 )
                theNums.set ( index , theNums.get ( index ) * 2 ); 
        }
        

    }

}
