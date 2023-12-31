package task_05;

public class EmpFamily {
    int id_empFam;
    boolean maried;
    String dob;
    String address;

    public EmpFamily(int id_empFam, boolean maried, String dob, String address) {
        this.id_empFam = id_empFam;
        this.maried = maried;
        this.dob = dob;
        this.address = address;
    }

    public int getId_empFam() {
        return id_empFam;
    }

    public boolean isMaried() {
        return maried;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "EmpFamily{" +
                "id_empFam=" + id_empFam +
                ", maried=" + maried +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
