/*
    Skeleton Program for the AQA A1 Summer 2019 examination
    this code should be used in conjunction with the Preliminary Material
    written by the AQA AS1 Programmer Team
    developed in NetBeans IDE 8.2 environment
    
    Version number: 0.0.2
    
 */
package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AQABoardGame {

    final String SPACE = "     ";
    final String UNUSED = "XXXXX";
    final int BOARD_SIZE = 8;
    final int NUMBER_OF_PIECES = 12;
    final int MAX_MOVES = 50;
    final int ROW = 0;
    final int COLUMN = 1;
    final int DAME = 2;

    class MoveRecord {
        String piece = "";
        int newRow = -1;
        int newColumn = -1;
        boolean canJump = false;
    }

    int[][] loadPieces(BufferedReader fileHandle, int[][] playersPieces) {
        try {
            for (int index = 0; index < NUMBER_OF_PIECES + 1; index++) {
                playersPieces[index][ROW] = Integer.parseInt(fileHandle.readLine());
                playersPieces[index][COLUMN] = Integer.parseInt(fileHandle.readLine());
                playersPieces[index][DAME] = Integer.parseInt(fileHandle.readLine());
            }
        } catch (IOException | NumberFormatException e) {
        }
        return playersPieces;
    }

    String[][] createNewBoard(String[][] board) {
        for (int thisRow = 0; thisRow < BOARD_SIZE; thisRow++) {
            for (int thisColumn = 0; thisColumn < BOARD_SIZE; thisColumn++) {
                if ((thisRow + thisColumn) % 2 == 0) {
                    board[thisRow][thisColumn] = UNUSED;
                } else {
                    board[thisRow][thisColumn] = SPACE;
                }
            }
        }
        return board;
    }

    String[][] addPlayerA(String[][] board, int[][] a) {
        for (int index = 1; index < NUMBER_OF_PIECES + 1; index++) {
            int pieceRow = a[index][ROW];
            int pieceColumn = a[index][COLUMN];
            int pieceDame = a[index][DAME];
            if (pieceRow > -1) {
                if (pieceDame == 1) {
                    board[pieceRow][pieceColumn] = "A" + index;
                } else {
                    board[pieceRow][pieceColumn] = "a" + index;
                }
            }
        }
        return board;
    }

    String[][] addPlayerB(String[][] board, int[][] b) {
        for (int index = 1; index < NUMBER_OF_PIECES + 1; index++) {
            int pieceRow = b[index][ROW];
            int pieceColumn = b[index][COLUMN];
            int pieceDame = b[index][DAME];
            if (pieceRow > -1) {
                if (pieceDame == 1) {
                    board[pieceRow][pieceColumn] = "B" + index;
                } else {
                    board[pieceRow][pieceColumn] = "b" + index;
                }
            }
        }
        return board;
    }

    void displayErrorCode(int errorNumber) {
        Console.writeLine("Error " + errorNumber);
    }

    boolean setUpBoard(String[][] board, int[][] a, int[][] b, boolean fileFound) 
    {
        String fileName = "game1.txt";
        Console.write("Do you want to load a saved game? (Y/N): ");
        String answer = Console.readLine();
        if (answer.equals("Y") || answer.equals("y")) {
            Console.write("Enter the filename: ");
            fileName = Console.readLine();
        }
        try {
            BufferedReader fileHandle = new BufferedReader(new FileReader(fileName));
            fileFound = true;
            a = loadPieces(fileHandle, a);
            b = loadPieces(fileHandle, b);
            fileHandle.close();
            createNewBoard(board);
            addPlayerA(board, a);
            addPlayerB(board, b);
        } catch (IOException e) {
            displayErrorCode(4);
        }
        return fileFound;
    }

    void printHeading() {
        Console.write("    ");
        for (int boardColumn = 0; boardColumn < BOARD_SIZE; boardColumn++) {
            Console.write(String.format("%3s", Integer.toString(boardColumn)) + "   ");
        }
        Console.writeLine();
    }

    void printRow(String[][] board, int thisRow) {
        Console.write("   |");
        for (int boardColumn = 0; boardColumn < BOARD_SIZE; boardColumn++) {
            if (board[thisRow][boardColumn].equals(UNUSED)) {
                Console.write(board[thisRow][boardColumn] + "|");
            } else {
                Console.write(SPACE + "|");
            }
        }
        Console.writeLine();
    }

    void printMiddleRow(String[][] board, int thisRow) {
        Console.write(String.format("%2s",Integer.toString(thisRow)) + " |");
        for (int boardColumn = 0; boardColumn < BOARD_SIZE; boardColumn++) {
            if (board[thisRow][boardColumn].equals(UNUSED) || board[thisRow][boardColumn].equals(SPACE)) {
                Console.write(board[thisRow][boardColumn] + "|");
            } else {
                Console.write(String.format("%4s", board[thisRow][boardColumn]) + " |");
            }
        }
        Console.writeLine();
    }

    void printLine() {
        Console.write("   ");
        for (int boardColumn = 0; boardColumn < BOARD_SIZE; boardColumn++) {
            Console.write("------");
        }
        Console.writeLine("-");
    }

    void displayBoard(String[][] board) {
        printHeading();
        printLine();
        for (int thisRow = 0; thisRow < BOARD_SIZE; thisRow++) {
            printRow(board, thisRow);
            printMiddleRow(board, thisRow);
            printRow(board, thisRow);
            printLine();
        }
    }

    void printPlayerPieces(int[][] a, int[][] b) {
        Console.writeLine();
        Console.writeLine("Player A:");
        Console.write("[");
        for (int index = 0; index < NUMBER_OF_PIECES; index++) {
            Console.write("[" + a[index][ROW] + ", " + a[index][COLUMN] + ", " + a[index][DAME] + "], ");
        }
        Console.writeLine("[" + a[NUMBER_OF_PIECES][ROW] + ", " + a[NUMBER_OF_PIECES][COLUMN] + ", " + a[NUMBER_OF_PIECES][DAME] + "]]");
        Console.writeLine("Player B:");
        Console.write("[");
        for (int index = 0; index < NUMBER_OF_PIECES; index++) {
            Console.write("[" + b[index][ROW] + ", " + b[index][COLUMN] + ", " + b[index][DAME] + "], ");
        }
        Console.writeLine("[" + b[NUMBER_OF_PIECES][ROW] + ", " + b[NUMBER_OF_PIECES][COLUMN] + ", " + b[NUMBER_OF_PIECES][DAME] + "]]");
        Console.writeLine();
    }

    MoveRecord[] clearList(MoveRecord[] listOfMoves) {
        for (int index = 0; index < MAX_MOVES; index++) {
            listOfMoves[index] = new MoveRecord();
            listOfMoves[index].piece = "";
            listOfMoves[index].newRow = -1;
            listOfMoves[index].newColumn = -1;
            listOfMoves[index].canJump = false;
        }
        return listOfMoves;
    }

    boolean validMove(String[][] board, int newRow, int newColumn) {
        boolean valid = false;
        if (newRow >= 0 && newRow < BOARD_SIZE
                && newColumn >= 0 && newColumn < BOARD_SIZE) {
            if (board[newRow][newColumn].equals(SPACE)) {
                valid = true;
            }
        }
        return valid;
    }

    boolean validJump(String[][] board, int[][] playersPieces, String piece, int newRow, int newColumn) {
        boolean valid = false;
        String oppositePiecePlayer, middlePiecePlayer, player, middlePiece;
        int index, currentRow, currentColumn, middlePieceRow, middlePieceColumn;
        player = piece.substring(0, 1).toLowerCase();
        index = Integer.parseInt(piece.substring(1));
        if (player.equals("a")) {
            oppositePiecePlayer = "b";
        } else {
            oppositePiecePlayer = "a";
        }
        if (newRow >= 0 && newRow < BOARD_SIZE
                && newColumn >= 0 && newColumn < BOARD_SIZE) {
            if (board[newRow][newColumn].equals(SPACE)) {
                currentRow = playersPieces[index][ROW];
                currentColumn = playersPieces[index][COLUMN];
                middlePieceRow = (currentRow + newRow) / 2;
                middlePieceColumn = (currentColumn + newColumn) / 2;
                middlePiece = board[middlePieceRow][middlePieceColumn];
                middlePiecePlayer = middlePiece.substring(0, 1).toLowerCase();
                if (!middlePiecePlayer.equals(oppositePiecePlayer)
                        && !middlePiecePlayer.equals(" ")) {
                    valid = true;
                }
            }
        }
        return valid;
    }

    MoveRecord[] listPossibleMoves(String[][] board, int[][] playersPieces,
            String nextPlayer, MoveRecord[] listOfMoves) {
        int direction, numberOfMoves, currentColumn, leftColumn, rightColumn,
                jumpLeftColumn, jumpRightColumn, i, currentRow, newRow, jumpRow;
        String piece;
        if (nextPlayer.equals("a")) {
            direction = 1;
        } else {
            direction = -1;
        }
        numberOfMoves = 0;
        for (i = 1; i < NUMBER_OF_PIECES + 1; i++) {
            piece = nextPlayer + i;
            currentRow = playersPieces[i][ROW];
            currentColumn = playersPieces[i][COLUMN];
            if (playersPieces[i][DAME] == 1) {
                piece = piece.toUpperCase();
            }
            newRow = currentRow + direction;
            leftColumn = currentColumn - 1;
            rightColumn = currentColumn + 1;
            if (validMove(board, newRow, leftColumn)) {
                Console.writeLine(piece + " can move to " + newRow + " , " + leftColumn);
                numberOfMoves += 1;
                listOfMoves[numberOfMoves].piece = piece;
                listOfMoves[numberOfMoves].newRow = newRow;
                listOfMoves[numberOfMoves].newColumn = leftColumn;
                listOfMoves[numberOfMoves].canJump = false;
            }
            if (validMove(board, newRow, rightColumn)) {
                Console.writeLine(piece + " can move to " + newRow + " , " + rightColumn);
                numberOfMoves += 1;
                listOfMoves[numberOfMoves].piece = piece;
                listOfMoves[numberOfMoves].newRow = newRow;
                listOfMoves[numberOfMoves].newColumn = rightColumn;
                listOfMoves[numberOfMoves].canJump = false;
            }
            jumpRow = currentRow + direction + direction;
            jumpLeftColumn = currentColumn - 2;
            jumpRightColumn = currentColumn + 2;
            if (validJump(board, playersPieces, piece, jumpRow, jumpLeftColumn)) {
                Console.writeLine(piece + " can jump to " + jumpRow + " , " + jumpLeftColumn);
                numberOfMoves += 1;
                listOfMoves[numberOfMoves].piece = piece;
                listOfMoves[numberOfMoves].newRow = jumpRow;
                listOfMoves[numberOfMoves].newColumn = jumpLeftColumn;
                listOfMoves[numberOfMoves].canJump = true;
            }
            if (validJump(board, playersPieces, piece, jumpRow, jumpRightColumn)) {
                Console.writeLine(piece + " can jump to " + jumpRow + " , " + jumpRightColumn);
                numberOfMoves += 1;
                listOfMoves[numberOfMoves].piece = piece;
                listOfMoves[numberOfMoves].newRow = jumpRow;
                listOfMoves[numberOfMoves].newColumn = jumpRightColumn;
                listOfMoves[numberOfMoves].canJump = true;
            }
        }
        Console.writeLine("There are " + numberOfMoves + " possible moves");
        return listOfMoves;
    }

    boolean listEmpty(MoveRecord[] listOfMoves) {
        return listOfMoves[1].piece.equals("");
    }

    int selectMove(MoveRecord[] listOfMoves) {
        boolean validPiece = false, endOfList;
        int index = 0, newRow, newColumn;
        boolean found;
        String rowString, columnString, piece = "";
        while (!validPiece) {
            index = 0;
            found = false;
            endOfList = false;
            Console.write("Which piece do you want to move? ");
            piece = Console.readLine();
            if (piece.equals("")) {
                endOfList = true;
            }
            while (!found && !endOfList) {
                index += 1;
                if (listOfMoves[index].piece.equals(piece)) {
                    found = true;
                } else if (listOfMoves[index].piece.equals("")) {
                    endOfList = true;
                    displayErrorCode(1);
                }
            }
            if (found) {
                validPiece = true;
            }
        }
        int chosenpieceIndex = index;
        boolean validMove = false;
        while (!validMove) {
            Console.print("Which row do you want to move to? ");
            rowString = Console.readLine();
            Console.print("Which column do you want to move to? ");
            columnString = Console.readLine();
            try {
                newRow = Integer.parseInt(rowString);
                newColumn = Integer.parseInt(columnString);
                found = false;
                endOfList = false;
                index = chosenpieceIndex - 1;
                while (!found && !endOfList) {
                    index += 1;
                    if (!listOfMoves[index].piece.equals(piece)) {
                        endOfList = true;
                        displayErrorCode(2);
                    } else if (listOfMoves[index].newRow == newRow && listOfMoves[index].newColumn == newColumn) {
                        found = true;
                    }
                }
                validMove = found;
            } catch (NumberFormatException ex) {
                displayErrorCode(3);
            }
        }
        return index;
    }

    int[] moveDame(String[][] board, String player, int newRow, int newColumn) {
        if (player.equals("a")) {
            for (int i : new int[] {1, 3, 5, 7}) {
                if (board[0][i].equals(SPACE)) {
                    newColumn = i;
                    newRow = 0;
                    break;
                }
            }
        } else {
            for (int i : new int[] {0, 2, 4, 6}) {
                if (board[BOARD_SIZE - 1][i].equals(SPACE)) {
                    newColumn = i;
                    newRow = BOARD_SIZE - 1;
                    break;
                }
            }
        }
        return new int[]{newRow, newColumn};
    }

    void movePiece(String[][] board, int[][] playersPieces, String chosenPiece, int newRow, int newColumn) {
        int index = Integer.parseInt(chosenPiece.substring(1));
        int currentRow = playersPieces[index][ROW];
        int currentColumn = playersPieces[index][COLUMN];
        board[currentRow][currentColumn] = SPACE;
        String player;

        if (newRow == BOARD_SIZE - 1 && playersPieces[index][DAME] == 0) {
            player = "a";
            playersPieces[0][1] += 1;
            playersPieces[index][DAME] = 1;
            chosenPiece = chosenPiece.toUpperCase();
            int[] rtnInts = moveDame(board, player, newRow, newColumn);
            newRow = rtnInts[0];
            newColumn = rtnInts[1];
        } else if (newRow == 0 && playersPieces[index][DAME] == 0) {
            player = "b";
            playersPieces[0][1] += 1;
            playersPieces[index][DAME] = 1;
            chosenPiece = chosenPiece.toUpperCase();
            int[] rtnInts = moveDame(board, player, newRow, newColumn);
            newRow = rtnInts[0];
            newColumn = rtnInts[1];
        }
        playersPieces[index][ROW] = newRow;
        playersPieces[index][COLUMN] = newColumn;
        board[newRow][newColumn] = chosenPiece;
    }

    void makeMove(String[][] board, int[][] playersPieces,
            int[][] opponentsPieces, MoveRecord[] listOfMoves, int pieceIndex) {
        playersPieces[0][0] += 1;
        if (pieceIndex > 0) {
            String piece = listOfMoves[pieceIndex].piece;
            int newRow = listOfMoves[pieceIndex].newRow;
            int newColumn = listOfMoves[pieceIndex].newColumn;
            int playersPieceIndex = Integer.parseInt(piece.substring(1));
            int currentRow = playersPieces[playersPieceIndex][ROW];
            int currentColumn = playersPieces[playersPieceIndex][COLUMN];
            boolean jumping = listOfMoves[pieceIndex].canJump;
            movePiece(board, playersPieces, piece, newRow, newColumn);
            if (jumping) {
                int middlePieceRow = (currentRow + newRow) / 2;
                int middlePieceColumn = (currentColumn + newColumn) / 2;
                String middlePiece = board[middlePieceRow][middlePieceColumn];
                Console.writeLine("jumped over " + middlePiece);
            }
        }
    }

    String swapPlayer(String nextPlayer) {
        if (nextPlayer.equals("a")) {
            return "b";
        } else {
            return "a";
        }
    }

    void printResult(int[][] a, int[][] b, String nextPlayer) {
        Console.writeLine("Game ended");
        Console.writeLine(nextPlayer + " lost this game as they cannot make a move");
        printPlayerPieces(a, b);
    }

    void game() {
        int[][] a = new int[NUMBER_OF_PIECES + 1][3];
        int[][] b = new int[NUMBER_OF_PIECES + 1][3];
        String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
        MoveRecord[] listOfMoves = new MoveRecord[MAX_MOVES];
        boolean gameEnd = false;
        boolean fileFound = false;
        String nextPlayer = "a";
        int pieceIndex;
        fileFound = setUpBoard(board, a, b, fileFound);
        if (!fileFound) {
           gameEnd = true;
        }
        while (!gameEnd) {
            printPlayerPieces(a, b);
            displayBoard(board);
            Console.writeLine("Next player: " + nextPlayer);
            listOfMoves = clearList(listOfMoves);
            if (nextPlayer.equals("a")) {
                listOfMoves = listPossibleMoves(board, a, nextPlayer, listOfMoves);
                if (!listEmpty(listOfMoves)) {
                    pieceIndex = selectMove(listOfMoves);
                    makeMove(board, a, b, listOfMoves, pieceIndex);
                    nextPlayer = swapPlayer(nextPlayer);
                } else {
                    gameEnd = true;
                }
            } else {
                listOfMoves = listPossibleMoves(board, b, nextPlayer, listOfMoves);
                if (!listEmpty(listOfMoves)) {
                    pieceIndex = selectMove(listOfMoves);
                    makeMove(board, b, a, listOfMoves, pieceIndex);
                    nextPlayer = swapPlayer(nextPlayer);
                } else {
                    gameEnd = true;
                }
            }
        }
        if (fileFound) {
            printResult(a, b, nextPlayer);
        }
    }

    public static void main(String[] args) {
        AQABoardGame boardgame = new AQABoardGame();
        boardgame.game();
    }
}
