/****************************************
 * CSCI 330 M01 Fall 2024
 * @author Alysar Tabet 
 * Target Class
 * src/Target.java
 ****************************************/
import java.util.ArrayList;

public class Target {
    /**
     * The Target class handles user input, calls the Utils class which checks for priority,
     * and initiates the RR or Priority RR Scheduling simulation, displaying the performanc metrics.
     */
    // Main Method
    public static void main(String[] args) {
        // Validate argument count
        if (args.length != 2) {
            System.out.println("Usage: java Target <process_csv_file> <time_quantum>");
            System.exit(1);
        }

        String processFile = args[0];
        int timeQuantum = 0;

        // Parse time quantum
        try {
            timeQuantum = Integer.parseInt(args[1]);
            if (timeQuantum <= 0) {
                System.out.println("Time quantum must be a positive integer.");
                System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid time quantum. Time quantum must be an integer.");
            System.exit(1);
        }

        // Read processes from file
        ArrayList<Process> processes = Utils.readProcesses(processFile);

        /// Decide which scheduler to use based on the format
        boolean isPriorityScheduling = processes.size() > 0 && processes.get(0).getPriority() != -1;

        if (isPriorityScheduling) {
            PriorityScheduler priorityScheduler = new PriorityScheduler();
            for (Process process : processes) {
                priorityScheduler.addProcess(process);
            }
            priorityScheduler.executeProcesses();
        } else {
            Metrics metrics = Scheduler.roundRobin(processes, timeQuantum);
            Utils.printMetrics(metrics);
        }
    } // end main method
} // end Target class
