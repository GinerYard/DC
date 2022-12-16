package Project;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ShowBoardList {
    public static void showList(ArrayList<int[][]> BL,ArrayList<int[][]> SL) {

        int[][] pub = new int[8][4];
        for (int k = 0; k < BL.size(); k++) {

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (SL.get(k)[i][j] == 0) {
                        pub[i][j] = 0;
                    }
                    if (SL.get(k)[i][j] == 1) {
                        pub[i][j] = BL.get(k)[i][j];
                    }
                }
            }





            if ((k % 2 == 0)) {
                System.out.printf("第%d回合：\n", k / 2 + 1);
                if(k/2+1==1){
                    View.textArea.append("\n第1回合：\n");
                }else{
                String s = String.valueOf(k/2+1);
                View.textArea.append("第"+s+"回合：\n");}
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.printf("%s  ", Convert.convert(pub[i][j]));
                    View.textArea.append(Convert.convertGUI(pub[i][j])+" ");
                }
                System.out.printf("\n");
                View.textArea.append("\n");
            }
            if(k%2==0) {
                System.out.printf("-----------------------------------\n");
                View.textArea.append("---------------------------\n");
            }
            if(k%2==1) {
                System.out.printf("-----------------------------------\n");
                System.out.printf("\n");
                System.out.printf("-----------------------------------\n");
                View.textArea.append("---------------------------\n");
                View.textArea.append("\n");
                View.textArea.append("xxxxxxxxxxxxxxxxxxxx\n");
            }
        }
    }
}
