import java.util.Scanner;
import java.util.InputMismatchException;
// Abstract Class (Abstraction)
abstract class Game {
    abstract void startGame();
}
// Parent Class
class ChessPiece {
    void move() {
        System.out.println("Chess Piece is Moving...");
    }
}
// Child Class (Inheritance)
class King extends ChessPiece {
    @Override
    void move() {
        System.out.println("King moves one square in any direction.");
    }
}
// Chess Game Class
class ChessGame extends Game {
    // Encapsulation
    private String currentTurn = "White";
    Scanner sc = new Scanner(System.in);
    // Abstraction
    @Override
    void startGame() {
        System.out.println("New Chess Game Started!");
    }
    void displayBoard() {
        char[][] board = {
                {'r','n','b','q','k','b','n','r'},
                {'p','p','p','p','p','p','p','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'P','P','P','P','P','P','P','P'},
                {'R','N','B','Q','K','B','N','R'}
        };
        System.out.println("\nChess Board:");
        for(int i=0;i<8;i++) {
            System.out.print((8-i)+" ");
            for(int j=0;j<8;j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }
    // Polymorphism (Method Overloading)
    void makeMove() throws Exception {

        System.out.print("Enter Source Position: ");
        String from = sc.next();

        System.out.print("Enter Destination Position: ");
        String to = sc.next();
        // Exception Handling using throw
        if(from.length()!=2 || to.length()!=2){
            throw new Exception("Invalid Chess Position!");
        }
         System.out.println("Move : " + from + " -> " + to);
         if(currentTurn.equals("White"))
            currentTurn = "Black";
        else
            currentTurn = "White";
    }
    void makeMove(String move){
        System.out.println("Move Played : " + move);
    }
    void gameStatus(){
        System.out.println("\nCurrent Turn : " + currentTurn);
        System.out.println("King Status  : Safe");
        System.out.println("Check        : No");
    }
}
public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         ChessGame game = new ChessGame();
         King king = new King();           
          int choice = 0;
          do {
            try {
                System.out.println("\n==================================");
                System.out.println("      CHESS GAME ENGINE");
                System.out.println("==================================");
                System.out.println("1. Start Game");
                System.out.println("2. Display Board");
                System.out.println("3. Make Move");
                System.out.println("4. King Move");
                System.out.println("5. Game Status");
                System.out.println("6. Exit");
                System.out.print("Enter Choice: ");
                choice = sc.nextInt();
                switch(choice){
                    case 1:
                        game.startGame();
                        break;

                    case 2:
                        game.displayBoard();
                        break;

                    case 3:
                        game.makeMove();
                        break;

                    case 4:
                        king.move();
                        break;

                    case 5:
                        game.gameStatus();
                        break;

                    case 6:
                        System.out.println("Thank You!");
                        break;

                    default:
                        throw new Exception("Invalid Menu Choice!");
                }

            }
            catch(InputMismatchException e){
                System.out.println("Please enter numbers only!");
                sc.nextLine();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
            finally{
                System.out.println("Program Executed Successfully.");
            }
            }while(choice!=6);
            sc.close();
    }
}