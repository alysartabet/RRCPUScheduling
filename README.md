# Round Robin CPU Scheduling
![proj_logo](proj_image/cpuschedulerlogo.png)
## About
This Java-based simulator is a program that models the Round Robin CPU scheduling algorithm, a fundamental concept in operating systems. By reading process data from a CSV file and applying a user-defined time quantum, the simulator provides insights into various performance metrics.

### CPU Scheduling
CPU scheduling determines the order in which processes access the central processing unit (CPU). Effective CPU scheduling maximizes CPU utilization, as in multitasking environments, multiple processes may be ready to execute simultaneously, but the CPU can handle only one process at a time. Various algorithms are employed to achieve these objectives, each with thei advantages and trade-offs.

### Round Robin Scheduling 
Round Robin (RR) is a widely used CPU scheduling algorithm. It assigns a time quantum to each process in the ready queue, and processes are executed in a cyclic order, ensuring that each receives an equal share of CPU time.

### Priority Round Robin Scheduling (*EXTRA CREDIT)
This enhances the existing Round Robin CPU Scheduling Simulator by integrating a Priority Scheduling algorithm. Priority Scheduling assigns a priority level to each process, ensuring that processes with higher priorities are executed before those with lower priorities. This approach is particularly effective in scenarios where certain tasks require immediate attention over others.

## Project Files
``` 
RRCPUScheduling/
├── src/
│   ├── Target.java
│   ├── Metrics.java
│   ├── Scheduler.java
│   ├── Utils.java
│   ├── Process.java
│   └── PriorityScheduler.java
│ 
├── input/
│   ├── priorityrrprocess.csv
│   └── rrprocess.csv
│
├── screenshots/
│   ├── rrquantum_1.png
│   ├── rrquantum_2.png
│   ├── rrquantum_3.png
│   ├── rrquantum_4.png
│   ├── rrquantum_5.png
│   ├── prrquantum_1.png
│   ├── prrquantum_2.png
│   ├── prrquantum_3.png
│   ├── prrquantum_4.png
│   └── prrquantum_5.png
│
├── proj_image/
│   └── cpuschedulerlogo.png
│
├── bin/ (for compiled class files)
│
├── README.pdf
└── README.md
```

## Class Descriptions 
### Target
**File Path:** src/Target.java \
**Description:** The Target class acts as the main entry point for running the scheduling simulation. It handles error-checking for user input arguments and ensures that the time quantum is a positive integer, determines whether to run a Round Robin or Priority Round Robin scheduling simulation based on process data, and displays performance metrics. \
**main Methods:** Parses command-line arguments, validates input, reads process data from a file using Utils, and decides whether to run Round Robin or Priority scheduling. Outputs metrics after the simulation. 

### Scheduler
**File Path:** src/Scheduler.java \
**Description:** The Scheduler class implements the Round Robin scheduling algorithm, simulating process scheduling and calculating performance metrics. It sorts processes by arrival time and uses a ready queue to simulate process execution. \
**roundRobin Method:** Runs the Round Robin scheduling simulation, calculating various metrics such as CPU utilization, throughput, average turnaround time, average waiting time, and average response time. Returns a Metrics object.

### Utils
**File Path:** src/Utils.java \
**Description:** The Utils class provides utility functions essential for reading process data from a CSV file and printing metrics. \
**Methods:** 
* readProcesses(String filePath): Reads processes from a CSV file, parsing them into Process objects. Returns an ArrayList<Process>.
* printMetrics(Metrics metrics): Prints the values of the metrics in a formatted manner.

### Metrics
**File Path:** src/Metrics.java \
**Description:** The Metrics class encapsulates all performance metrics that result from a scheduling simulation. \
**Instance Variables:** 
   * double averageTurnaroundTime
   * double averageWaitingTime
   * double averageResponseTime
   * double cpuUtilization (percentage)
   * double throughput
   * int contextSwitches 

**Accessor Methods:**
   * double getAverageTurnaroundTime()
   * double getAverageWaitingTime()
   * double getAverageResponseTime()
   * double getCpuUtilization()
   * double getThroughput()
   * int getContextSwitches() 


**Mutator Methods:**
   * void setAverageTurnaroundTime(double averageTurnaroundTime)
   * void setAverageWaitingTime(double averageWaitingTime)
   * void setAverageResponseTime(double averageResponseTime)
   * void setCpuUtilization(double cpuUtilization)
   * void setThroughput(double throughput)
   * void setContextSwitches(int contextSwitches)


### Process
**File Path:** src/Process.java \
**Description:** The Process class represents a single process with attributes and states necessary for scheduling. \
**Instance Variables:** 
* int pid
* int arrivalTime
* int burstTime
* int priority
* int remainingTime
* int completionTime
* int turnaroundTime
* int waitingTime
* int responseTime
* boolean isStarted

**Constructor(s):** 
* Process(int pid, int arrivalTime, int burstTime)
* Process(int pid, int arrivalTime, int burstTime, int priority)

**Accessor Methods:**
* int getPid()
* int getArrivalTime()
* int getBurstTime()
* int getPriority()
* int getRemainingTime()
* int getCompletionTime()
* int getTurnaroundTime()
* int getWaitingTime()
* int getResponseTime()
* boolean isStarted()

**Mutator Methods:**
* void setRemainingTime(int remainingTime)
* void setCompletionTime(int completionTime)
* void setTurnaroundTime(int turnaroundTime)
* void setWaitingTime(int waitingTime)
* void setResponseTime(int responseTime)
* void setStarted(boolean started)

**toString Method:** @Override public String toString(): Returns a string representation of the process. \
**Comparable Method:** @Override public int compareTo(Process other): Compares this process to another based on priority for use in PriorityQueue.


### PriorityScheduler (*Extra Credit)
**File Path:** src/PriorityScheduler.java \
**Description:** The PriorityScheduler class handles scheduling using a Priority Round Robin algorithm, executing processes based on their priority and displaying performance metrics.
**Key Enhancements:** 
   * **Priority Attribute:** The Process class includes a priority attribute to denote the importance of each process.
   * **PriorityScheduler Class:** A new class PriorityScheduler.java manages the scheduling logic, ensuring that higher-priority processes are allocated CPU time before lower- priority ones.
   * **Modified Scheduling Logic:**  The scheduler first selects processes based on priority, and within each priority level, it applies the Round Robin algorithm using the specified time quantum.

**Benefits:**
* **Improved Responsiveness:** Critical processes with higher priorities receive CPU time
more promptly.
* **Balanced Fairness:** While higher-priority processes are favored, lower-priority processes
still receive CPU time in a fair and cyclic manner.

**Instance Variables:** 
* PriorityQueue<Process> processQueue: Holds processes, prioritized by their priority values.
* List<Process> completedProcesses: Stores processes after they have been executed.
* int currentTime: Tracks the current time of the scheduler.
* int contextSwitches: Counts the number of context switches.
* int contextSwitchTime: Fixed time for context switches (default 1).

**Constructor:** 
* PriorityScheduler(): Initializes processQueue, completedProcesses, currentTime, and contextSwitches.

**Methods:** 
* addProcess(Process process): Adds a process to the priority queue.
* executeProcesses(): Executes processes in order of priority and updates performance metrics.
* displayMetrics(): Prints the performance metrics such as CPU utilization, throughput, average waiting time, average turnaround time, and average response time.

## Usage and Output (Still editing)
**Installation and Usage** \
   **1. Clone the Repository**

   **2. Compile the Java Source Files:**\
         ```javac -d bin src/*.java```\
      This command compiles all .java files in the src/ directory and places the .class files in a new bin/ directory.

      
   **3. Prepare the Input File:**\
      Ensure your Round Robin csv file (rrprocess.csv) is in the input/ directory and follows the format:\
      ```PID,ArrivalTime,BurstTime```

*If implementing Priority Scheduling, extend the format to include Priority (priorityrrprocess.csv):*\
      ```PID,ArrivalTime,BurstTime,Priority```
   
   **4. Run the Program:**\
Navigate to the project directory and execute the program using the java command:\
```java -cp bin Target input/<process_csv_file> <time_quantum>```\
Replace <process_csv_file> with either a Round Robin, or Priority Round Robin csv file. Replace <time_quantum> with the desired time quantum value (integer).\
Example:\
```java -cp bin Target input/rrprocess.csv```

   **5. View the Output:**\
The program will display the performance metrics in the terminal.\
Sample Output:
```CPU Utilization: 72.73%
Throughput: 0.18 processes/unit time
Average Waiting Time: 7.00
Average Turnaround Time: 12.50
Average Response Time: 5.00
Context Switches: 6
```

## Screenshots
### RR Scheduling:

### PRR Scheduling: 

## Analysis of Results
**CPU Utilization:**\
As the size of the Time Quantum grows, CPU utilization often improves due to the reduction in context switches. However, if the Time Quantum is too large compared to process burst times, it may lead to suboptimal CPU usage.\
**Throughput:**\
A larger Time Quantum generally boosts throughput since less time is spent on context switching and more time is allocated to process execution.\
**Impact of Priority Scheduling:**\
Adding priority-based scheduling can enhance the responsiveness for high-priority tasks without significantly disadvantaging lower-priority processes. This method improves system performance and user experience by managing process importance effectively.\
**Trade-offs:**\
Choosing the right Time Quantum size requires balancing system responsiveness with CPU efficiency. Implementing priority scheduling adds complexity but provides more nuanced control over process execution.\
**Small Time Quantum (e.g., 1 unit):**\
**Benefits:**
* Leads to a shorter average waiting time.
* Provides quicker response times for processes.

**Drawbacks:**
* Results in a higher number of context switches.
* Causes more CPU overhead due to frequent switching.
* Reduces overall CPU utilization.

**Large Time Quantum (e.g., 5 units):**

**Benefits:**
* Decreases the frequency of context switches.
* Enhances CPU utilization.
* Minimizes CPU overhead from switching.
  
**Drawbacks:**
* Increases the average waiting time.
* Slows down response time.
* Can make the system less responsive for interactive tasks.


## References
* **Youtube Tutorials:**
    * [OS | Process Management | RR example - Ravindrababu Ravula](https://www.youtube.com/watch?v=Sa600YsU16U&ab_channel=RavindrababuRavula)
    * [Round Robin CPU Scheduling Algorithm (RR) - Simple Snippets](https://www.youtube.com/watch?v=9hw-_qJ55K4&t=298s&ab_channel=SimpleSnippets)
* **Github Repository:** [roundrobinschedulingsimulator - tamzid2001](https://github.com/tamzid2001/roundrobincpuschedulingsimulator/tree/main)
* **TroubleShooting Help Site:** [Create a priority based round robin algorithm - StackOverFlow](https://stackoverflow.com/questions/46935140/create-a-priority-based-round-robin-algorithm)

