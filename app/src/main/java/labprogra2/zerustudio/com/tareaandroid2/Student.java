package labprogra2.zerustudio.com.tareaandroid2;

/**
 * Created by KenyStev on 03-05-15.
 */
public class Student {
    private int cuenta;
    private double notaFinal;
    private String name;

    public Student(String name, int cuenta){
        this.name=name;
        this.cuenta=cuenta;
        notaFinal=0;
    }

    public String getName() {
        return name;
    }

    public int getCuenta() {
        return cuenta;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return String.format("No. "+ cuenta + "\nNombre: " + name);
    }
}
