package task_06;

import task_06.DBWorker;

public class Main {
    public static void main(String[] args) {
        DBWorker dbWorker = new DBWorker();
//        dbWorker.createTableCar();

        Car car1 = new Car(1, "Mazda", 10000, "Red");
        Car car2 = new Car(1, "Zaporozets", 1, "White");
        Car car3 = new Car(1, "BMW", 25000, "Black");
        Car car4 = new Car(1, "Mercedes", 75000, "Blue");
        Car car5 = new Car(1, "Audi", 50000, "Grey");
//        dbWorker.addCarToDB(car1);
//        dbWorker.addCarToDB(car2);
//        dbWorker.addCarToDB(car3);
//        dbWorker.addCarToDB(car4);
//        dbWorker.addCarToDB(car5);

        System.out.println(dbWorker.getAllAutoFromDB());

        dbWorker.deleteCarFromDBbyModel("BMWфывфыв");

        System.out.println(dbWorker.getAllAutoFromDB());

        dbWorker.updateCarInfoByCarID(123,"Subary",7777,"Purple");

        System.out.println(dbWorker.getAllAutoFromDB());
    }
}
