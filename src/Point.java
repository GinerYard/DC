import java.util.ArrayList;



    public class Point {
        private int x;//设置私有变量x
        private int y;

        public void setX(int x) {
            this.x = x;
        }//将x公有化


        public void setY(int y) {
            this.y = y;
        }

        public void increment() {
            this.x++;//设置一个将私有变量x加一的函数
            this.y++;
        }

        public String getPoint() {
            return String.format("[%d,%d]", x, y);//获取坐标形式的[x,y]
        }

        public static void main(String[] args) {
            ArrayList<Point> points = new ArrayList<>();//定义一个以Point为指定类型的可扩容数组，数组名为points
            Point point = new Point();//定义一个新的变量类型Point，point是Point中的一个新地址
            point.setX(0);//定义x的值
            point.setY(0);
            points.add(point);//将地址point中储存的内容加入数组points中
            for (int i = 0; i < 3; i++) {
                Point p = new Point();
                p.setX(i + 1);
                p.setY(i - 1);
                points.add(p);//定义三个新的Point类型的元素，地址各不相同，分别是[1,-1][2,0][3,1]
            }
            points.add(point);//将地址point中储存的内容加入数组points中
            for (Point p : points) {
                p.increment();
            }//将points中的元素按地址执行函数（即每次对单独元素运算时，元素所在地址的所有元素也进行运算）
            for (Point p : points) {
                System.out.println(p.getPoint());
            }
        }
    }

