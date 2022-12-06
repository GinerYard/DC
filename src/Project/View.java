package Project;

public class View {
    public static void method(int x,int y,int[][] board,int[][] state,int round, int c, Var flagdo){
        if ((x != 0 && x != 1 && x != 2 && x != 3 && x != 4 && x != 5 && x != 6 && x != 7) || (y != 0 && y != 1 && y != 2 && y != 3)) {
            System.out.println("这不是棋盘中的位置！");
            Var.flagdo = 1;
        }
        if (board[x][y] == 100) {
           return;
        }
        if (board[x][y] != 100 && state[x][y] == 1) {
            if (!ColorJudge.cj(x, y, c, round, board)) {
                System.out.println("你必须选择属于你颜色的棋子或是翻面的棋子！");
                Var.flagdo = 1;
            }
            if (ColorJudge.cj(x, y, c, round, board)) {
                if (Math.abs(board[x][y]) != 7 && board[x][y] != 100) {
                    MoveOperator.move(x, y, board, state, flagdo);
                }
                if (Math.abs(board[x][y]) == 7) {
                    CannonOperator.cannon(x, y, board, state, flagdo);
                }
            }
        }
        if (state[x][y] == 0) {
            TurnOperator.turn(x, y, state, flagdo);
        }
        if (round == 2) {
            if (board[x][y] > 0) {
                System.out.printf("先手是红色方\n");
            }
            if (board[x][y] < 0) {
                System.out.printf("先手是黑色方\n");
            }
            c = board[x][y];
        }
        Menu.redraw(board,state);
    }


}
