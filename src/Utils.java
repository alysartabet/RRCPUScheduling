/****************************************
 * CSCI 330 M01 Fall 2024
 * @author Alysar Tabet 
 * Utils Class
 * src/Utils.java
 ****************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    /**
     * Reads processes from a CSV file.
     * Provides utility functions essential for the simulator's operation, 
     * such as reading input files and printing metrics.
     *
     * @param filePath Path to the CSV file.
     * @return List of Process objects.
     */
    
    public static ArrayList<Process> readProcesses(String filePath) {
        ArrayList<Process> processes = new ArrayList<>();
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read and skip the header line
            String header = br.readLine();
            if (header == null) {
                System.out.println("Empty file or missing header: " + filePath);
                System.exit(1);
            }

            // Start reading data from the second line onward
            while ((line = br.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(splitBy);
                try {
                    if (parts.length == 4) {
                        // Handle PID, ArrivalTime, BurstTime, Priority format
                        int pid = Integer.parseInt(parts[0].trim());
                        int arrivalTime = Integer.parseInt(parts[1].trim());
                        int burstTime = Integer.parseInt(parts[2].trim());
                        int priority = Integer.parseInt(parts[3].trim());
                        processes.add(new Process(pid, arrivalTime, burstTime, priority));
                    } else if (parts.length == 3) {
                        // Handle PID, ArrivalTime, BurstTime format
                        int pid = Integer.parseInt(parts[0].trim());
                        int arrivalTime = Integer.parseInt(parts[1].trim());
                        int burstTime = Integer.parseInt(parts[2].trim());
                        // Default priority value when not provided (indicates non-priority)
                        processes.add(new Process(pid, arrivalTime, burstTime, -1));
                    } else {
                        System.out.println("Invalid line format in process file: " + line);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in process file line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the process file: " + e.getMessage());
            System.exit(1);
        }

        return processes;
    }

    /**
     * Prints the metrics in a formatted way.
     *
     * @param metrics A Metrics object containing all performance metrics.
     */
    public static void printMetrics(Metrics metrics) {
        System.out.println("CPU Utilization: " + String.format("%.2f", metrics.getCpuUtilization()) + "%");
        System.out.println("Throughput: " + String.format("%.2f", metrics.getThroughput()) + " processes/unit time");
        System.out.println("Average Waiting Time: " + String.format("%.2f", metrics.getAverageWaitingTime()));
        System.out.println("Average Turnaround Time: " + String.format("%.2f", metrics.getAverageTurnaroundTime()));
        System.out.println("Average Response Time: " + String.format("%.2f", metrics.getAverageResponseTime()));
        System.out.println("Context Switches: " + metrics.getContextSwitches());
    }
}