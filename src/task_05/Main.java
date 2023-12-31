package task_05;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DBWorker dbWorker = new DBWorker();

        System.out.println("-------------------------");
        System.out.println("Таблица и имя/контакт");
        List<EmpContact> empContacts = dbWorker.getAllEmpContacts();
        showListInConsole(empContacts);

        System.out.println("-------------------------");
        System.out.println("Таблица семья/др/адрес");
        List<EmpFamily> empFamilys = dbWorker.getAllEmpFamilys();
        showListInConsole(empFamilys);

        System.out.println("-------------------------");
        System.out.println("Таблица должность/зарплата");
        List<EmpSalary> empSalarys = dbWorker.getAllEmpSalarys();
        showListInConsole(empSalarys);
    }

    private static <T> void showListInConsole(List<T> empContacts) {
        for (T empContact : empContacts) {
            System.out.println(empContact);
        }
    }


}