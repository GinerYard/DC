package Homework4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Administrator {
    private ArrayList<Student> studentList = new ArrayList<>();
    private CourseDatabase database = new CourseDatabase();

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setDatabase(CourseDatabase database) {
        this.database = database;
    }

    public CourseDatabase getDatabase() {
        return database;
    }

    public Administrator() {
    }


    public void addStudent(Student student) {
        studentList.add(student);
    }


    public void addStudent(int studentID) {
        int n = 0;
        for (int i : Student.id) {
            for (Student s : Student.stu) {
                if (s.getStudentID() != i) {
                    n++;
                }
                if (s.getStudentID() == i) {
                    studentList.add(s);
                }
            }
        }
    }


    public void generateCurriculum() {
        for (Course c : database.getCourseList()) {
            ArrayList<Integer> p = new ArrayList<>();
            for (Student s : studentList) {
                int k = 0;
                for (Course t : s.getCurriculum()) {
                    if (!t.equals(c)) {
                        k++;
                    }
                    if (t.equals(c)) {
                        p.add(s.getCre().get(k));
                    }
                }
            }
            if (p.size() > c.getCapacity()) {
                Collections.sort(p);
                int n = p.get(p.size() - c.getCapacity() - 1);
                for (Student s : studentList) {
                    for (int i  = 0;i< s.getCurriculum().size();i++) {
                        Course m = s.getCurriculum().get(i);
                        int k = 0;
                        if (!m.equals(c)) {
                            k++;
                        }
                        if (m.equals(c)) {
                            if (s.getCre().get(k) <= n) {
                                ArrayList<Course> a = s.getCurriculum();
                                a.remove(k);
                                s.setCurriculum(a);

                                ArrayList<Integer> b = s.getCre();
                                b.remove(k);
                                s.setCre(b);
                            }
                        }
                    }
                }
            }
        }
    }


}
