package Project;

public class Convert {
    public static String convert(int s) {
        switch (s) {
            case 1:
                return(Color.color2("帥", 31));
            case 2:
                return(Color.color2("仕", 31));
            case 3:
                return(Color.color2("相", 31));
            case 4:
                return(Color.color2("俥", 31));
            case 5:
                return(Color.color2("傌", 31));
            case 6:
                return(Color.color2("兵", 31));
            case 7:
                return(Color.color2("炮", 31));
            case -1:
                return(Color.color2("將", 0));
            case -2:
                return(Color.color2("仕", 0));
            case -3:
                return(Color.color2("象", 0));
            case -4:
                return(Color.color2("車", 0));
            case -5:
                return(Color.color2("馬", 0));
            case -6:
                return(Color.color2("卒", 0));
            case -7:
                return(Color.color2("砲", 0));
            case 100:
                return(Color.color1("空", 37, 1, 47));
            case 0:
                return(Color.color1("暗", 30, 1, 40));
        }

        return null;
    }
    public static String convertGUI(int s) {
        switch (s) {
            case 1:
                return("红帅");
            case 2:
                return("红士");
            case 3:
                return("红相");
            case 4:
                return("红车");
            case 5:
                return("红马");
            case 6:
                return("红兵");
            case 7:
                return("红炮");
            case -1:
                return("黑将");
            case -2:
                return("黑士");
            case -3:
                return("黑象");
            case -4:
                return("黑车");
            case -5:
                return("黑马");
            case -6:
                return("黑卒");
            case -7:
                return("黑炮");
            case 100:
                return("空白");
            case 0:
                return("暗棋");
        }

        return null;
    }
}
