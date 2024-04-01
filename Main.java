import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char board[][] = new char[3][3];
        boolean player1Turn = true;
        boolean gameEnded=false;
        drawBoard(board);
        while (!gameEnded){



            System.out.println("player one pls make a turn");
            System.out.println("enter collumn");
            int coll = in.nextInt()-1;
            System.out.println("enter row");
            int row = in.nextInt()-1;

            if (player1Turn&&board[coll][row]!='X'&&board[coll][row]!='O'){
                board[coll][row] ='X';
                player1Turn=false;
            }
            else if (!player1Turn&&board[coll][row]!='X'&&board[coll][row]!='O'){
                board[coll][row] ='O';
                player1Turn=true;
            }
            String player;
            drawBoard(board);
            if (player1Turn){//one and two are switched because i want to know who won
                player="2";
            }
            else {
                player="1";
            }

            //winnings check
            if (isWin(board)){
                gameEnded=true;
                System.out.println("game has ended player "+player+" has won");
            }
            if (isDraw(board)){
                gameEnded=true;
                System.out.println("this game is a draw");
            }
        }


    }
    public static void drawBoard(char board[][]){
        int rows = board.length;
        int colms = board[0].length;
        for (int j=0;j<colms;j++){
            for(int i=0;i<rows;i++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }
    public static boolean isWin(char board[][]){
        return (board[0][0]==board[0][1]&&board[0][1]==board[0][2]&&board[0][0]!=0||
                board[1][0]==board[1][1]&&board[1][1]==board[1][2]&&board[1][0]!=0||
                board[2][0]==board[2][1]&&board[2][1]==board[2][2]&&board[2][0]!=0||

                board[0][0]==board[1][0]&&board[1][0]==board[2][0]&&board[0][0]!=0||
                board[0][1]==board[1][1]&&board[1][1]==board[2][1]&&board[0][1]!=0||
                board[0][2]==board[1][2]&&board[1][2]==board[2][2]&&board[0][2]!=0||

                board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0]!=0||
                board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[0][2]!=0);
    }
    public static boolean isDraw(char board[][]){
        return (board[0][0]!=0&&board[0][1]!=0&&board[0][2]!=0&&
                board[1][0]!=0&&board[1][1]!=0&&board[1][2]!=0&&
                board[2][0]!=0&&board[2][1]!=0&&board[2][2]!=0);
    }


}