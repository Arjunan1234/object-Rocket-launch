public class RocketBehavior implements IRocketBehavior {

    private Rocket rocket;

    public RocketBehavior() {
        this.rocket = new Rocket();
    }

    @Override
    public void startChecks() {
        System.out.println("Performing system checks...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All systems are 'Go' for launch.");
    }

    @Override
    public void launch() {

        if (rocket.getAltitude() >= 100) {
            System.out.println("Already launched rocket");
        } else if (rocket.getStage().equals("Pre-Launch")) {
            System.out.println("Rocket launch initiated.");
            rocket.setLaunchStarted(true);

            while (rocket.getAltitude() < 100 && rocket.getFuel() > 0) {
                rocket.updateStatus();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (rocket.getFuel() <= 0 && rocket.getAltitude() < 100) {
                    System.out.println("Mission Failed due to insufficient fuel.");
                    break;
                }
            }
        } else {
            System.out.println("Cannot launch, initiate start_checks");
        }
    }

    @Override
    public void fastForward(int seconds) {
        System.out.println("Fast forwarding " + seconds + " seconds...");

        for (int i = 0; i < seconds; i++) {
            // Simulate time passing
            try {
                Thread.sleep(1000); // Simulate 1 second of time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Fast forward completed.");
    }
}
