public class Rocket {
    private int altitude;
    private String stage;
    private boolean launchStarted;
    private int fuel;
    private int speed = 1000;
    private int counter = 1;

    public Rocket() {
        this.altitude = 0;
        this.stage = "Pre-Launch";
        this.launchStarted = false;
        this.fuel = 100;
    }

    public int getAltitude() {
        return altitude;
    }

    public String getStage() {
        return stage;
    }

    public boolean isLaunchStarted() {
        return launchStarted;
    }

    public int getFuel() {
        return fuel;
    }

    public void setLaunchStarted(boolean launchStarted) {
        this.launchStarted = launchStarted;
    }

    public void updateStatus() {
        if (fuel > 0) {
            fuel -= 10;
            altitude += 10;
            if (altitude >= 50 && counter == 1) {
                counter = 2;
                System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.\n");
            }
            System.out.println("Stage: " + counter + ", Fuel: " + fuel + "%, Altitude: " + altitude + " km, Speed: "
                    + speed + " km/h");
        }
        if (altitude >= 100) {
            stage = "Orbit Placement";
            System.out.println("Orbit achieved! Mission Successful.");
            launchStarted = false;

        }
    }

    public void fastForwardOneSecond() {
        // Simulate one second of time during fast forward
        altitude += 10;
        fuel -= 5;
    }
}
