import java.util.Scanner;

public class RocketLaunchSimulator {
    private IRocketBehavior behavior;

    public RocketLaunchSimulator() {
        this.behavior = new RocketBehavior();
    }

    public void startChecks() {
        behavior.startChecks();
    }

    public void launch() {
        behavior.launch();
    }

    public void fastForward(int seconds) {
        behavior.fastForward(seconds);
    }

    public static void main(String[] args) {
        RocketLaunchSimulator simulator = new RocketLaunchSimulator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is Rocket Launch Simulator\n");

        while (true) {
            System.out.print("Enter a command (start_checks, launch, fast_forward X, or exit): ");
            String command = scanner.nextLine().trim();

            if (command.equals("start_checks")) {
                simulator.startChecks();
            } else if (command.equals("launch")) {
                simulator.launch();
            } else if (command.startsWith("fast_forward")) {
                try {
                    int seconds = Integer.parseInt(command.split(" ")[1]);
                    simulator.fastForward(seconds);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid command. Use 'fast_forward X' where X is the number of seconds.");
                }
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command. Please enter a valid command.");
            }
        }

        scanner.close();
    }
}
