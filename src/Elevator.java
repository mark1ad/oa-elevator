import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 * 1) Assumes that floor numbers can be negative and that the first floor is 0.
 */
public class Elevator {

    public static final String FLOORS_OPTION = "-floors";
    public static final String START_OPTION = "-start";

    public static void main(String[] args) {
        int startingFloor = getStartingFloor(args);
        List<Integer> floors = getFloorsToVisit(args);
    }

    /**
     * Gets the floor number for the starting floor option.
     * @param args  arguments passed into program
     * @return      starting floor number
     */
    private static int getStartingFloor(String[] args) {
        int startingFloor = 0;
        boolean argFound = false;

        for (int i = 0; i < args.length; i++) {
            // Look for -start and convert the next arg to a number for the start floor
            if (args[i].equals(START_OPTION) && i < args.length - 1) {
                argFound = true;
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
        if (!argFound) {
            System.out.println("ERROR: -start option not specified\n");
            printUsage();
        }

        return startingFloor;
    }

    /**
     * Get the list of floors to visit.
     * @param args  arguments passed into program
     * @return      List of floors to visit
     */
    private static List<Integer> getFloorsToVisit(String[] args) {
        List<String> floorsStrList;
        List<Integer> floorsList = null;

        for (int i = 0; i < args.length; i++) {
            // Look for -floors and convert the next arg to a list of integers for the floors
            // that the elevator will visit.
            if (args[i].equals(FLOORS_OPTION) && i < args.length - 1) {
                floorsStrList = new ArrayList<String>(Arrays.asList( args[i+1].split(",")));
                floorsList = new ArrayList<Integer>();
                for (String floor: floorsStrList) {
                    try {
                        floorsList.add(Integer.parseInt(floor));
                    }
                    catch (NumberFormatException e) {
                        System.out.println("ERROR: -floors option values must all be numbers");
                        printUsage();
                    }
                }
            }
        }

        // Check if floors option was found.
        if (floorsList == null) {
            System.out.println("ERROR: -floors option not found.");
            printUsage();
        }

        return floorsList;
    }

    /**
     * Print out the program's usage message and exit with a value of 1.
     */
    private static void printUsage() {
        System.out.println("usage: elevator -start n -floors x,y,...");
        System.out.println("\t-start n\tspecify the floor that the elevator starts on.");
        System.out.println("\t-floors x,y,...\tThe floors the elevator will stop at. Value is a comma separated list of numbers. Can be a single number.");
        System.exit(1);

    }
}
