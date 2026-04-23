public class Vehicle {

    public String brandName;
    public String modelName;
    public String color;
    public double price;
    private String mfgCode;
    public String fuelType;
    public double load;
    public int sittingCapacity;

    // Default constructor
    public Vehicle() {
        brandName = "Mercedes";
        modelName = "Class C";
        color = "Black";
        price = 5000000;
        fuelType = "Diesel";
        load = 1000;
        sittingCapacity = 5;
        mfgCode = "LMN98765";
    }

    // Parameterized constructor
    public Vehicle(String bName, String mName, String clr,
                   double prc, String fType, double ld,
                   int sitCap, String mfgCde) {

        brandName = bName;
        modelName = mName;
        color = clr;
        price = prc;
        fuelType = fType;
        load = ld;
        sittingCapacity = sitCap;
        mfgCode = mfgCde;
    }

    // Copy constructor
    public Vehicle(Vehicle v) {
        brandName = v.brandName;
        modelName = v.modelName;
        color = v.color;
        price = v.price;
        fuelType = v.fuelType;
        load = v.load;
        sittingCapacity = v.sittingCapacity;
        mfgCode = v.mfgCode;
    }

    public void start() {
        System.out.println("Vehicle Started");
    }

    public void drive() {
        System.out.println("Vehicle in motion");
    }

    public void stop() {
        System.out.println("Vehicle Stopped");
    }

    public void honk() {
        System.out.println("Beep Beep");
    }

    public float changeSpeed(float initSp) {
        return (initSp < 20) ? initSp + 20 : initSp - 20;
    }

    public float calcMileage(float distance, float fuelConsumed) {
        return distance / fuelConsumed;
    }

    public void displayLowFuelWarning() {
        float fuelLevel = 10.0f;
        if (fuelLevel < 15.0f) {
            System.out.println("Warning: Low Fuel Level!");
        }
    }

    public void setMfgCode(String mfgCode) {
        this.mfgCode = mfgCode;
    }

    public String getMfgCode() {
        return mfgCode;
    }

    public static void printVehicleDetails(Vehicle v) {
        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Brand Name: " + v.brandName);
        System.out.println("Model Name: " + v.modelName);
        System.out.println("Color: " + v.color);
        System.out.println("Price: " + v.price);
        System.out.println("Manufacturing Code: " + v.getMfgCode());
        System.out.println("Fuel Type: " + v.fuelType);
        System.out.println("Load Capacity: " + v.load);
        System.out.println("Sitting Capacity: " + v.sittingCapacity);
    }

    // ✅ ONLY NEW METHOD ADDED
    public double getMileageByFuelType() {

        if (fuelType.equalsIgnoreCase("Petrol")) {
            return 15.0;
        }
        else if (fuelType.equalsIgnoreCase("Diesel")) {
            return 20.0;
        }
        else if (fuelType.equalsIgnoreCase("CNG")) {
            return 25.0;
        }
        else {
            return 0.0;
        }
    }
}
