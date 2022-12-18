package Project;

import javax.swing.*;

public class SetImg {
    public static ImageIcon setImg(int i,int j,int[][] board, int[][] state){
        if(state[i][j]==0){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\0.png");
            return img;
        }
        if(board[i][j]==1){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\1.png");
            return img;
        }
        if(board[i][j]==2){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\2.png");
            return img;
        }
        if(board[i][j]==3){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\3.png");
            return img;
        }
        if(board[i][j]==4){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\4.png");
            return img;
        }
        if(board[i][j]==5){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\5.png");
            return img;
        }
        if(board[i][j]==6){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\6.png");
            return img;
        }
        if(board[i][j]==7){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\7.png");
            return img;
        }
        if(board[i][j]==-1){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\-1.png");
            return img;
        }
        if(board[i][j]==-2){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\-2.png");
            return img;
        }
        if(board[i][j]==-3){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\-3.png");
            return img;
        }
        if(board[i][j]==-4){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\-4.png");
            return img;
        }
        if(board[i][j]==-5){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\-5.png");
            return img;
        }
        if(board[i][j]==-6){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\-6.png");
            return img;
        }
        if(board[i][j]==-7){
            ImageIcon img = new ImageIcon("D:\\Project\\Chess\\-7.png");
            return img;
        }
        else {
            return null;
        }
    }
}
