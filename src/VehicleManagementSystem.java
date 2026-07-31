import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    int id;
    String ownerName;
    String vehicleNo;
    String vehicleType;
    String brand;
    String regDate;
    String insurance;
    String serviceHistory;
    String driverName;

    Vehicle(int id, String ownerName, String vehicleNo,
            String vehicleType, String brand,
            String regDate, String insurance,
            String serviceHistory, String driverName) {

        this.id = id;
        this.ownerName = ownerName;
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
        this.brand = brand;
        this.regDate = regDate;
        this.insurance = insurance;
        this.serviceHistory = serviceHistory;
        this.driverName = driverName;
    }

    void display() {
        System.out.println("-----------------------------------");
        System.out.println("Vehicle ID      : " + id);
        System.out.println("Owner Name      : " + ownerName);
        System.out.println("Vehicle Number  : " + vehicleNo);
        System.out.println("Vehicle Type    : " + vehicleType);
        System.out.println("Brand           : " + brand);
        System.out.println("Register Date   : " + regDate);
        System.out.println("Insurance       : " + insurance);
        System.out.println("Service History : " + serviceHistory);
        System.out.println("Driver Name     : " + driverName);
    }
}
class VehicleManagementSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    static boolean login() {

        System.out.println("===== ADMIN LOGIN =====");

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        if(user.equals("admin") && pass.equals("1234")) {
            System.out.println("Login Successful");
            return true;
        }

        System.out.println("Invalid Login");
        return false;
    }

    static void addVehicle() {

        System.out.print("Vehicle ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Owner Name: ");
        String owner = sc.nextLine();

        System.out.print("Vehicle Number: ");
        String number = sc.nextLine();

        System.out.print("Vehicle Type: ");
        String type = sc.nextLine();

        System.out.print("Brand: ");
        String brand = sc.nextLine();

        System.out.print("Registration Date: ");
        String date = sc.nextLine();

        System.out.print("Insurance Details: ");
        String insurance = sc.nextLine();

        System.out.print("Service History: ");
        String service = sc.nextLine();

        System.out.print("Driver Name: ");
        String driver = sc.nextLine();

        vehicles.add(new Vehicle(id, owner, number, type,
                brand, date, insurance, service, driver));

        System.out.println("Vehicle Added Successfully.");
    }

    static void viewVehicles() {

        if(vehicles.isEmpty()) {
            System.out.println("No Vehicles Found.");
            return;
        }

        for(Vehicle v : vehicles) {
            v.display();
        }
    }

    static void searchVehicle() {

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        boolean found = false;

        for(Vehicle v : vehicles) {

            if(v.vehicleNo.equalsIgnoreCase(number)) {
                v.display();
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Vehicle Not Found.");
        }
    }

    static void updateVehicle() {

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        for(Vehicle v : vehicles) {

            if(v.vehicleNo.equalsIgnoreCase(number)){
                System.out.print("New Owner Name: ");
                v.ownerName = sc.nextLine();

                System.out.print("New Insurance: ");
                v.insurance = sc.nextLine();

                System.out.print("New Service History: ");
                v.serviceHistory = sc.nextLine();

                System.out.println("Vehicle Updated.");
                return;
            }
        }

        System.out.println("Vehicle Not Found.");
    }
    static void deleteVehicle() {

        System.out.print("Enter Vehicle Number: ");
        String number = sc.nextLine();

        for (int i = 0; i < vehicles.size(); i++) {

            if (vehicles.get(i).vehicleNo.equalsIgnoreCase(number)) {

                vehicles.remove(i);
                System.out.println("Vehicle Deleted Successfully.");
                return;
            }
        }

        System.out.println("Vehicle Not Found.");
    }

    static void totalVehicles() {

        System.out.println("Total Vehicles : " + vehicles.size());
    }

    public static void main(String[] args) {

        if (!login()) {
            return;
        }

        int choice;

        do {

            System.out.println("\n===== VEHICLE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Update Vehicle");
            System.out.println("5. Delete Vehicle");
            System.out.println("6. Total Vehicles");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addVehicle();
                    break;

                case 2:
                    viewVehicles();
                    break;

                case 3:
                    searchVehicle();
                    break;

                case 4:
                    updateVehicle();
                    break;

                case 5:
                    deleteVehicle();
                    break;

                case 6:
                    totalVehicles();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}