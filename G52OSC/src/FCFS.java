import java.util.Scanner;

public class FCFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int waitingTime[], burstTime[], turnaroundTime[];
		float averageWTime = 0, averageTATime = 0;
		
		System.out.println("===== First Come First Serve (FCFS) =====\n"); 
		
		Scanner num = new Scanner(System.in);
		System.out.println("Enter number of process:"); 
		n = num.nextInt();  //get the number of process
		
		waitingTime = new int[n];
		burstTime = new int[n];
		turnaroundTime = new int[n];
		
		for(int i = 0; i < n; i++){  //input the burst time for each processes
			System.out.println("Enter the burst time for process " +(i+1));  
			burstTime[i] = num.nextInt();
		}  

		long cputimeBefore = System.currentTimeMillis();  //Initialize the start time of CPU usage		
		
		waitingTime[0] = 0;
		
		/*  ======= FCFS Algorithm ====== */
		
		for(int i = 1; i < n; i++){ 
			waitingTime[i] = waitingTime[i-1]+ burstTime[i-1];  //calculate the waiting for each process
		} 
		
		for(int i = 0; i < n; i++){ 
			turnaroundTime[i] = waitingTime[i] + burstTime[i];  //calculate turn around time for each process
			averageWTime += waitingTime[i];		//calculate average waiting time
		} 
		
		for(int j = 0; j < n; j++){
			averageTATime += turnaroundTime[j]; //calculate average turn around time
		}
		
		/*  ======= END ====== */
		
		System.out.println("\n====================== TABLE =========================");

		System.out.print(" ____________________________________________________\n");
		System.out.println("| Process | BurstTime | WaitingTime | TurnAroundTime |");	
		
		for(int i = 0; i < n; i++){
			System.out.println("      "+ (i+1) +" \t"+burstTime[i]+"\t     "+waitingTime[i]+"\t\t    "+turnaroundTime[i]);
		}
		
		System.out.println("\n======================================================");
		
		System.out.println("Average Waiting Time "+ String.format("%.2f", (averageWTime = averageWTime/n)));
		
		System.out.println("Average Turn Around Time "+ String.format("%.2f", (averageTATime = averageTATime/n)));
		
		long cputimeAfter = System.currentTimeMillis();  //Get the end time of CPU usage during the program
		
		long cputimeDifference = cputimeAfter - cputimeBefore; // Calculate CPU usage
		
		System.out.println("CPU Time " + cputimeDifference);
	}	

}
