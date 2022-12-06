package Homework4;

import java.util.ArrayList;

public class Student {
    static ArrayList<Integer> id = new ArrayList<>();
    static ArrayList<Student> stu = new ArrayList<>();

    private int studentID;
    private ArrayList<Course> curriculum = new ArrayList<>();
    private ArrayList<Integer> cre = new ArrayList<>();
    private int remainingCredit = 100;


    public Student(int studentID) {
        this.studentID = studentID;
    }

    public static void add(Student s) {
        stu.add(s);
        id.add(s.getStudentID());
    }


    public void setCurriculum(ArrayList<Course> curriculum) {
        this.curriculum = curriculum;
    }

    public void setCre(ArrayList<Integer> cre) {
        this.cre = cre;
    }

    public int getStudentID() {
        return studentID;
    }

    public ArrayList<Course> getCurriculum() {
        return curriculum;
    }

    public int getRemainingCredit() {
        return remainingCredit;
    }

    public ArrayList<Integer> getCre() {
        return cre;
    }

    public int getR() {
        int s = 0;
        for (int c : cre) {
            s = s + c;
        }
        return s;
    }


    public boolean selectCourse(Course course, int credit) {
        int n = 0;
        ArrayList<SUSTechTime> t = course.getTimeList();
        if (curriculum.size() == 0) {
            curriculum.add(course);
            cre.add(credit);
            remainingCredit = 100 - getR();
            return true;
        } else {
            for (Course s : curriculum) {
                ArrayList<SUSTechTime> c = s.getTimeList();
                for (SUSTechTime c1 : c) {
                    for (SUSTechTime t1 : t) {
                        if (c1.getStartTime().equals(t1.getStartTime()) || c1.getEndTime().equals(t1.getEndTime())) {
                            n++;
                        }
                    }
                }
                if (course.getCourseID() == s.getCourseID()) {
                    n++;
                }
            }
            if (n == 0 && remainingCredit - credit >= 0) {
                curriculum.add(course);
                cre.add(credit);
                remainingCredit = 100 - getR();
                return true;
            } else {
                return false;
            }
        }
    }

    public void dropCourse(Course course) {
        curriculum.remove(course);
    }

    public void changeCredit(Course course, int credit) {
        int n = 0;
        for (Course c : curriculum) {
            if (c != course) {
                n++;
            }
        }
        cre.set(n, credit);
    }

}
