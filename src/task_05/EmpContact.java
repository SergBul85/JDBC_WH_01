package task_05;

public class EmpContact {
    int id_empCont;
    String name;
    String telNumber;

    public EmpContact(int id, String name, String telNumber) {
        this.id_empCont = id;
        this.name = name;
        this.telNumber = telNumber;
    }

    public int getId() {
        return id_empCont;
    }

    public String getName() {
        return name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    @Override
    public String toString() {
        return "EmpContact{" +
                "id=" + id_empCont +
                ", name='" + name + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
