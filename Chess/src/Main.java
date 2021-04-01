public class Main 
{
    //#region vars
    static final int maxWidth = 8;
    static final int maxHeight = 8;
    static char[][] board = new char[maxWidth][maxHeight];
    //#endregion

    public static void main(String[] args)
    {
        boolean gameOver = false;
        createBoard();
        displayBoard();
        while(!gameOver)
        {
            turnA();
            turnB();
        }
    }

    static void createBoard()
    {
        for(int i = 0; i < maxWidth; i++)
        {
            for(int j = 0; j < maxHeight; j++)
            {
                if((i == 0 || i == 7) && (j == 0 || j == 7))
                {
                    board[i][j] = 'R';
                }
                else if((i == 0 || i == 7) && (j == 1 || j == 6))
                {
                    board[i][j] = 'K';
                }
                else if((i == 0 || i == 7) && (j == 2 || j == 5))
                {
                    board[i][j] = 'B';
                }
                else if(i == 1 || i == 6)
                {
                    board[i][j] = 'P';
                }
                else if(i == 0 && j == 3 || i == 7 && j == 4)
                {
                    board[i][j] = 'Q';
                }
                else if(i == 0 && j == 4 || i == 7 && j == 3)
                {
                    board[i][j] = 'S';
                }
                else
                {
                    board[i][j] = '.';
                }
            }
        }
    }

    static void displayBoard()
    {
        for(int i = 0; i < maxWidth; i++)
        {
            for(int j = 0; j < maxHeight; j++)
            {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println("");
        }
    }
    
    static void turnA()
    {

    }
    
    static void turnB()
    {

    }
}
