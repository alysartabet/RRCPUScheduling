/****************************************
 * CSCI 330 M01 Fall 2024
 * @author Alysar Tabet 
 * PriorityScheduler Class
 * src/PriorityScheduler.java
 ****************************************/

 import java.util.PriorityQueue;
 import java.util.List;
 import java.util.ArrayList;
 
 public class PriorityScheduler {
    /**
     * The PriorityScheduler implements the Priority Round Robin scheduling algorithm 
     * and displays performance metrics.
     */
    /**Instance Variables */
     private PriorityQueue<Process> processQueue;
     private List<Process> completedProcesses;
     private int currentTime;
     private int contextSwitches;
     private int contextSwitchTime = 1;
    
     /**Constructor*/
     public PriorityScheduler() {
         // Initialize the priority queue; it will use the compareTo method in Process
         processQueue = new PriorityQueue<>();
         completedProcesses = new ArrayList<>();
         currentTime = 0;
         contextSwitches = 0;
     }


     //Methods
     public void addProcess(Process process) {
         processQueue.add(process);
     }
 
     public void executeProcesses() {
         while (!processQueue.isEmpty()) {
             Process currentProcess = processQueue.poll();
 
             if (currentProcess.getArrivalTime() > currentTime) {
                 currentTime = currentProcess.getArrivalTime();
             }
 
             // Set the response time if the process is starting for the first time
             if (!currentProcess.isStarted()) {
                 currentProcess.setResponseTime(currentTime - currentProcess.getArrivalTime());
                 currentProcess.setStarted(true);
             }
 
             // Calculate start, completion, turnaround, and waiting times
             currentProcess.setCompletionTime(currentTime + currentProcess.getBurstTime());
             currentProcess.setTurnaroundTime(currentProcess.getCompletionTime() - currentProcess.getArrivalTime());
             currentProcess.setWaitingTime(currentProcess.getTurnaroundTime() - currentProcess.getBurstTime());
 
             currentTime += currentProcess.getBurstTime();
             completedProcesses.add(currentProcess);
             contextSwitches++;
         }
         displayMetrics();
     }
 
     private void displayMetrics() {
        int totalTurnaroundTime = 0;
        int totalWaitingTime = 0;
        int totalResponseTime = 0;
        int totalBurstTime = 0;
    
        for (Process process : completedProcesses) {
            totalTurnaroundTime += process.getTurnaroundTime();
            totalWaitingTime += process.getWaitingTime();
            totalResponseTime += process.getResponseTime();
            totalBurstTime += process.getBurstTime();
        }
    
        int numProcesses = completedProcesses.size();
        double averageTurnaroundTime = (double) totalTurnaroundTime / numProcesses;
        double averageWaitingTime = (double) totalWaitingTime / numProcesses;
        double averageResponseTime = (double) totalResponseTime / numProcesses;
    
        // Calculate CPU utilization using context switch time
        double cpuUtilization = 1 - ((contextSwitchTime * contextSwitches) / (double) currentTime);
        double throughput = (double) numProcesses / currentTime;
        
        System.out.printf("CPU Utilization: %.2f%%\n", cpuUtilization * 100);
        System.out.printf("Throughput: %.2f processes/unit time\n", throughput);
        System.out.printf("Average Waiting Time: %.2f\n", averageWaitingTime);
        System.out.printf("Average Turnaround Time: %.2f\n", averageTurnaroundTime);
        System.out.printf("Average Response Time: %.2f\n", averageResponseTime);
        System.out.printf("Context Switches: %d\n", contextSwitches);
    }
}//end PriorityScheduler class
