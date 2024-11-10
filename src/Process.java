/****************************************
 * CSCI 330 M01 Fall 2024
 * @author Alysar Tabet 
 * Process Class
 * src/Process.java
 ****************************************/

public class Process implements Comparable<Process> {
    /**Instance Variables */
    private int pid;
    private int arrivalTime;
    private int burstTime;
    private int priority; //for Priority Scheduling
    private int remainingTime;
    private int completionTime;
    private int turnaroundTime;
    private int waitingTime;
    private int responseTime;
    private boolean isStarted;


    /**RR Constructor */
    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.completionTime = 0;
        this.turnaroundTime = 0;
        this.waitingTime = 0;
        this.responseTime = -1; // Indicates not yet started
        this.isStarted = false;
    }

    /**Priority RR Constructor */
    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingTime = burstTime;
        this.completionTime = 0;
        this.turnaroundTime = 0;
        this.waitingTime = 0;
        this.responseTime = -1; // Indicates not yet started
        this.isStarted = false;
    }

    //Accessor Methods
    public int getPid() { return this.pid; }
    public int getArrivalTime() { return this.arrivalTime; }
    public int getBurstTime() { return this.burstTime; }
    public int getPriority() { return this.priority; }
    public int getRemainingTime() { return this.remainingTime; }
    public int getCompletionTime() { return this.completionTime; }
    public int getTurnaroundTime() { return this.turnaroundTime; }
    public int getWaitingTime() { return this.waitingTime; }
    public int getResponseTime() { return this.responseTime; }
    public boolean isStarted() { return this.isStarted; }

    //Mutator Methods
    public void setRemainingTime(int remainingTime) { this.remainingTime = remainingTime; }
    public void setCompletionTime(int completionTime) { this.completionTime = completionTime; }
    public void setTurnaroundTime(int turnaroundTime) { this.turnaroundTime = turnaroundTime; }
    public void setWaitingTime(int waitingTime) { this.waitingTime = waitingTime; }
    public void setResponseTime(int responseTime) { this.responseTime = responseTime; }
    public void setStarted(boolean started) { isStarted = started; }

    @Override
    public String toString() {
        return "PID:" + pid + ", AT:" + arrivalTime + ", BT:" + burstTime;
    }

    @Override
    public int compareTo(Process other) {
        return Integer.compare(this.priority, other.priority);
    }
}