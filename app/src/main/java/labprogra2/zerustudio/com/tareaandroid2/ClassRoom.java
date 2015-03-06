package labprogra2.zerustudio.com.tareaandroid2;

import java.util.ArrayList;

/**
 * Created by zerokull on 03-05-15.
 */
public class ClassRoom {
    private ArrayList<Student> students = new ArrayList<>();

    public Student search(int cuenta){
        for (Student s:students){
            if(s.getCuenta()==cuenta)
                return s;
        }
        return null;
    }

    public boolean addStudent(String n, int c){
        if(search(c)==null){
            students.add(new Student(n,c));
            return true;
        }
        return false;
    }

    //throws NullPointerException
    public boolean refreshGrade(int cuenta, double nota){
        if(nota>=0 && nota<=100){
            search(cuenta).setNotaFinal(nota);
            return true;
        }
        return false;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}
