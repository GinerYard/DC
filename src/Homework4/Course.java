package Homework4;
import java.util.ArrayList;
public class Course {
    private String teacherName;
    private String courseName;
    private String courseID;
    private int classID;
    private ArrayList<SUSTechTime> timeList;
    private int capacity;


    public Course(String teacherName, String courseName, String courseID, int classID, ArrayList<SUSTechTime> timeList, int capacity){
        this.teacherName=teacherName;
        this.courseName=courseName;
        this.courseID=courseID;
        this.classID=classID;
        this.capacity=capacity;
        this.timeList=timeList;
    }
    public String getTeacherName(){return teacherName;}
    public String getCourseName(){return courseName;}
    public int getClassID(){return classID;}
    public String getCourseID(){return courseID;}
    public int getCapacity(){return capacity;}

    public ArrayList<SUSTechTime> getTimeList(){return timeList;}


    public String toString() {
        return "Course{" + this.getCourseID() + " " + this.getCourseName() + "-class " + this.getClassID() + " | " + this.getCapacity() + "}";
    }

}
