/****************************************
 * CSCI 330 M01 Fall 2024
 * @author Alysar Tabet 
 * Metrics Class
 * src/Metrics.java
 ****************************************/

public class Metrics {
    /** 
     * The Metrics class encapsulates all performance evaluation metrics
     * calculated after the Round Robin scheduling simulation.
     */
    /**Instance variables */
    private double averageTurnaroundTime;
    private double averageWaitingTime;
    private double averageResponseTime; 
    private double cpuUtilization; //percentage
    private double throughput;
    private int contextSwitches;

    //Accessor and Mutator Methods
    public double getAverageTurnaroundTime() { return averageTurnaroundTime; }
    public void setAverageTurnaroundTime(double averageTurnaroundTime) { this.averageTurnaroundTime = averageTurnaroundTime; }
    public double getAverageWaitingTime() { return averageWaitingTime; }
    public void setAverageWaitingTime(double averageWaitingTime) { this.averageWaitingTime = averageWaitingTime; }
    public double getAverageResponseTime() { return averageResponseTime; }
    public void setAverageResponseTime(double averageResponseTime) { this.averageResponseTime = averageResponseTime; }
    public double getCpuUtilization() { return cpuUtilization; }
    public void setCpuUtilization(double cpuUtilization) { this.cpuUtilization = cpuUtilization; }
    public double getThroughput() { return throughput; }
    public void setThroughput(double throughput) { this.throughput = throughput; }
    public int getContextSwitches() { return contextSwitches; }
    public void setContextSwitches(int contextSwitches) { this.contextSwitches = contextSwitches; }
}