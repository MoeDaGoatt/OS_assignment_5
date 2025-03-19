package org.example;

import java.util.Arrays;
import java.util.Comparator;

class Process {
    int id;
    int burstTime;
    int waitingTime;
    int turnaroundTime;

    public Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }
}

public class SchedulingAlgorithms {

    public static void fcfs(Process[] processes) {
        int n = processes.length;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        processes[0].waitingTime = 0;
        processes[0].turnaroundTime = processes[0].burstTime;

        for (int i = 1; i < n; i++) {
            processes[i].waitingTime = processes[i - 1].waitingTime + processes[i - 1].burstTime;
            processes[i].turnaroundTime = processes[i].waitingTime + processes[i].burstTime;

            totalWaitingTime += processes[i].waitingTime;
            totalTurnaroundTime += processes[i].turnaroundTime;
        }

        System.out.println("----------------- FCFS -----------------");
        System.out.println("Process ID | Waiting Time | Turnaround Time");
        for (Process process : processes) {
            System.out.println("     " + process.id + "         |     " + process.waitingTime + "         |       " + process.turnaroundTime);
        }
        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) n));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / (double) n));
    }

    public static void sjf(Process[] processes) {
        int n = processes.length;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        Arrays.sort(processes, Comparator.comparingInt(p -> p.burstTime));

        processes[0].waitingTime = 0;
        processes[0].turnaroundTime = processes[0].burstTime;

        for (int i = 1; i < n; i++) {
            processes[i].waitingTime = processes[i - 1].waitingTime + processes[i - 1].burstTime;
            processes[i].turnaroundTime = processes[i].waitingTime + processes[i].burstTime;

            totalWaitingTime += processes[i].waitingTime;
            totalTurnaroundTime += processes[i].turnaroundTime;
        }

        System.out.println("----------------- SJF -----------------");
        System.out.println("Process ID | Waiting Time | Turnaround Time");
        for (Process process : processes) {
            System.out.println("     " + process.id + "         |     " + process.waitingTime + "         |       " + process.turnaroundTime);
        }
        System.out.println("Average Waiting Time: " + (totalWaitingTime / (double) n));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / (double) n));
    }

    public static void main(String[] args) {
        Process[] processesFCFS = {
                new Process(1, 8),
                new Process(2, 5),
                new Process(3, 3),
                new Process(4, 6)
        };

        Process[] processesSJF = {
                new Process(1, 8),
                new Process(2, 5),
                new Process(3, 3),
                new Process(4, 6)
        };

        fcfs(processesFCFS);
        System.out.println();
        sjf(processesSJF);
    }
}
