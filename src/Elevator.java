/**
 * Provide code that simulates an elevator. You are free to use any language.
 * Upload the completed project to GitHub for discussion during interview.
 * Document all assumptions and any features that weren’t implemented.
 * The result should be an executable, or script, that can be run with the following inputs and generate the following outputs.
 *                   Inputs: [list of floors to visit] (e.g. elevator start=12 floor=2,9,1,32)
 *                   Outputs: [total travel time, floors visited in order] (e.g. 560 12,2,9,1,32)
 *                   Program Constants: Single floor travel time: 10
 *
 * Assumptions:
 * 1) All floor numbers are positive with 1 being the ground floor.
 */
public class Elevator {

    public static final String START_OPTION = "-start";

    public static void main(String[] args) {
        int startingFloor = getStartingFloor(args);
    }

    /**
     * Gets the floor number for the starting floor option
     * @param args  arguments passed into program
     * @return      starting floor number
     */
    private static int getStartingFloor(String[] args) {
        int startingFloor = -1;
        for (int i = 0; i < args.length; i++) {
            // Look for -start and convert the next arg to a number for the start floor
            if (args[i].equals(START_OPTION) && i < args.length - 1) {
                try {
                    startingFloor = Integer.valueOf(args[i + 1]);
                }
                catch (NumberFormatException e) {
                    System.out.println("ERROR: -start option value must be a number");
                    printUsage();
                }
            }
        }

        // -start not found, print error
        if (startingFloor == -1) {
            System.out.println("ERROR: -start option not specified\n");
            printUsage();
        }

        return startingFloor;
    }

    /**
     * Print out the program's usage message and exit with a value of 1.
     */
    private static void printUsage() {
        System.out.println("usage: elevator -start n");
        System.out.println("\t-start n\tspecify the floor that the elevator starts on.");
        System.exit(1);

    }
}
