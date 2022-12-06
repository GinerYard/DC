package Homework4;

import java.util.ArrayList;

public class CourseDatabase {
    private ArrayList<Course> courseList = new ArrayList<>();

    public CourseDatabase(){}

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course newCourse) {
        courseList.add(newCourse);
    }

    public void removeCourse(String courseID, int classID) {
        for (int i = 0;i< courseList.size();i++) {
            Course course = courseList.get(i);
            String c = course.getCourseID();
            int d = course.getClassID();
            if (c.equals(courseID)){
                if (d == classID) {
                    courseList.remove(course);
                }
            }
        }
    }


    public void removeCourse(Course course) {
        for (Course course1 : courseList) {
            if (course1.equals(course)) {
                courseList.remove(course);
            }
        }
    }

    public ArrayList<Course> searchCourseByID(String courseID) {
        ArrayList<Course> ID = new ArrayList<>();
        for (Course course : courseList) {
            String c = course.getCourseID();
            if (c.equals(courseID)) {
                ID.add(course);
            }
        }
        return ID;
    }

    public ArrayList<Course> searchCourseByTeacherName(String teacherName) {
        ArrayList<Course> TeacherName = new ArrayList<>();
        for (Course course : courseList) {
            String c = course.getTeacherName();
            if (c.equals(teacherName)) {
                TeacherName.add(course);
            }
        }
        return TeacherName;
    }

    public ArrayList<Course> searchCourseByCourseName(String courseName) {
        ArrayList<Course> CourseName = new ArrayList<>();
        for (Course course : courseList) {
            String c = course.getCourseName();
            if (c.equals(courseName)) {
                CourseName.add(course);
            }
        }
        return CourseName;
    }

    public ArrayList<Course> searchCourseByCourseTime(String startTime, String endTime) {
        ArrayList<Course> CourseTime = new ArrayList<>();
        for (Course course : courseList) {
            int n = 0;
            ArrayList<SUSTechTime> t = course.getTimeList();
            for (SUSTechTime t1 : t) {
                if (startTime.equals(t1.getStartTime()) || endTime.equals(t1.getEndTime())) {
                    n++;
                }
            }
            if (n != 0) {
                CourseTime.add(course);
            }
        }
        return CourseTime;
    }

}
