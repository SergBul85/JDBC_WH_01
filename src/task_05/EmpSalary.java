package task_05;

public class EmpSalary {
    int id_empSal;
    String position;
    double salary;

    public EmpSalary(int id_empSal, String position, double salary) {
        this.id_empSal = id_empSal;
        this.position = position;
        this.salary = salary;
    }

    public int getId_empSal() {
        return id_empSal;
    }

    public void setId_empSal(int id_empSal) {
        this.id_empSal = id_empSal;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmpSalary{" +
                "id_empSal=" + id_empSal +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
