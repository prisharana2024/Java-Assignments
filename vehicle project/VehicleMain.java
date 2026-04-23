public class VehicleMain {

    public static void main(String[] args) {

        Vehicle v1 = new Vehicle(
                "Honda", "Accord", "Blue",
                1500000, "Petrol", 500,
                5, "XYZ12345"
        );

        v1.start();
        v1.drive();
        v1.honk();

        float newSpeed = v1.changeSpeed(30);
        System.out.println("New Speed: " + newSpeed + " km/h");

        v1.displayLowFuelWarning();
        v1.stop();

        Vehicle v2 = new Vehicle();
        v2.brandName = "Toyota";
        v2.modelName = "Camry";
        v2.color = "Red";
        v2.price = 1800000;
        v2.fuelType = "Diesel";
        v2.load = 600;
        v2.sittingCapacity = 5;
        v2.setMfgCode("ABC54321");

        Vehicle v3 = new Vehicle(v2);
        v3.sittingCapacity = 7;
        v3.setMfgCode("COPY777");

        Vehicle v4 = new Vehicle(
                "Hyundai", "i20", "Black",
                300000, "Petrol", 400,
                5, "HYU12345"
        );

        // Array of Vehicle objects
        Vehicle[] vehicles = { v1, v2, v3, v4 };
        System.out.println("\nBrand\t\tModel\t\tPrice\t\tFuel Type\tMileage");
        System.out.println("----------------------------------------------------------------");

        for (Vehicle v : vehicles) {
            System.out.println(
                v.brandName + "\t\t" +
                v.modelName + "\t\t" +
                v.price + "\t\t" +
                v.fuelType + "\t\t" +
                v.getMileageByFuelType()
            );
        }
    }
}
