# Round Robin CPU Scheduling
![proj_logo](proj_image/cpuschedulerlogo.png)
## About
This Java-based simulator is a program that models the Round Robin CPU scheduling algorithm, a fundamental concept in operating systems. By reading process data from a CSV file and applying a user-defined time quantum, the simulator provides insights into various performance metrics.

### CPU Scheduling
CPU scheduling determines the order in which processes access the central processing unit (CPU). Effective CPU scheduling maximizes CPU utilization, as in multitasking environments, multiple processes may be ready to execute simultaneously, but the CPU can handle only one process at a time. Various algorithms are employed to achieve these objectives, each with thei advantages and trade-offs.

### Round Robin Scheduling 
Round Robin (RR) is a widely used CPU scheduling algorithm. It assigns a time quantum to each process in the ready queue, and processes are executed in a cyclic order, ensuring that each receives an equal share of CPU time.

### Priority Round Robin Scheduling (*EXTRACREDIT)
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

## Class Descriptions (still editing)
### Target
**File Path:** src/Target.java \
**Description:** src/Main.java \
**Instance Variables:** src/Main.java \
**Constructor(s):** src/Main.java \
**Accessor and Mutator Methods:** src/Main.java \
**toString Method:** src/Main.java 

### Scheduler
**File Path:** src/Main.java \
**Description:** src/Main.java \
**Instance Variables:** src/Main.java \
**Constructor(s):** src/Main.java \
**Accessor and Mutator Methods:** src/Main.java \
**toString Method:** src/Main.java 

### Utils
**File Path:** src/Main.java \
**Description:** src/Main.java \
**Instance Variables:** src/Main.java \
**Constructor(s):** src/Main.java \
**Accessor and Mutator Methods:** src/Main.java \
**toString Method:** src/Main.java 


### Metrics
**File Path:** src/Main.java \
**Description:** src/Main.java \
**Instance Variables:** src/Main.java \
**Constructor(s):** src/Main.java \
**Accessor and Mutator Methods:** src/Main.java \
**toString Method:** src/Main.java 


### Process
**File Path:** src/Main.java \
**Description:** src/Main.java \
**Instance Variables:** src/Main.java \
**Constructor(s):** src/Main.java \
**Accessor and Mutator Methods:** src/Main.java \
**toString Method:** src/Main.java 


### PriorityScheduler (*Extra Credit)
**File Path:** src/Main.java \
**Description:** src/Main.java \
**Instance Variables:** src/Main.java \
**Constructor(s):** src/Main.java \
**Accessor and Mutator Methods:** src/Main.java \
**toString Method:** src/Main.java 


## Usage and Output (Still editing)

### Screenshots

### Analysis of Results

## References
* **Youtube Tutorials:**
    * [OS | Process Management | RR example - Ravindrababu Ravula](https://www.youtube.com/watch?v=Sa600YsU16U&ab_channel=RavindrababuRavula)
    * [Round Robin CPU Scheduling Algorithm (RR) - Simple Snippets](https://www.youtube.com/watch?v=9hw-_qJ55K4&t=298s&ab_channel=SimpleSnippets)
* **Github Repository:** [roundrobinschedulingsimulator - tamzid2001](https://github.com/tamzid2001/roundrobincpuschedulingsimulator/tree/main)
* **TroubleShooting Help Site:** [Create a priority based round robin algorithm - StackOverFlow](https://stackoverflow.com/questions/46935140/create-a-priority-based-round-robin-algorithm)

