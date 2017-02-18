public class MagicSquare
{
    public boolean isSquare ( int[][] input )
    {
        if ( input.length == input [0].length && input.length * input[0].length / input.length == input[0].length )
        return true;
        else
        return false;

    }

    public boolean isMagicSquare ( int[][] input )
    {
        int comparedRow = 0;
        int sumRow = 0;
        int sumCol = 0;
        boolean value = true;

        for ( int row = 0; row < input.length; row++ )
        { 
            

            if ( sumRow != compareRow || sumCol != compareRow )
            {
                value = false;
                break;
            }
            else
                comparedRow = sumRow;

            for ( int col = 0; col < input[row].length; col++ )
            {  
                sumRow += input[row][col];

                int compareCol = 0;
                for ( int rowOf = 0; rowOf < input.length; rowOf ++ )
                {
                    
                    sumCol += input[rowOf][col];

                    if ( rowOf == input.length - 1 )
                    {
                        if ( compareCol == 0 )
                        {
                            compareCol = sumCol;
                        }
                        else if ( sumCol != compareCol )
                        {
                            value = false;
                            break;
                        }
                        else
                            compareCol = sumCol;

                    }
                
                }

            }  

        }
        
        return value;

    }

}