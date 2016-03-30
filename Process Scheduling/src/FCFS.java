import java.util.Scanner;

public class FCFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int waitingTime[], burstTime[], turnaroundTime[];
		float averageWTime = 0, averageTATime = 0;
		
		System.out.println("===== First Come First Serve (FCFS) =====\n"); 
		
		Scanner num = new Scanner(System.in);
		System.out.println("Enter no of process"); 
		n = num.nextInt();
		
		waitingTime = new int[n];
		burstTime = new int[n];
		turnaroundTime = new int[n];
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the burst time for process " +(i+1));
			burstTime[i] = num.nextInt();
		}
		
		long cputimeBefore = System.currentTimeMillis();
		
		waitingTime[0] = 0;
		
		for(int i = 1; i < n; i++){ 
			waitingTime[i] = waitingTime[i-1]+ burstTime[i-1];
		} 
		
		for(int i = 0; i < n; i++){ 
			turnaroundTime[i] = waitingTime[i] + burstTime[i];
			averageWTime += waitingTime[i];
		} 
		
		for(int j = 0; j < n; j++){
			averageTATime += turnaroundTime[j]; 
		}
		
		System.out.println("\n====================== TABLE =========================");

		System.out.print(" ____________________________________________________\n");
		System.out.println("| Process | BurstTime | WaitingTime | TurnAroundTime |");	
		
		for(int i = 0; i < n; i++){
			System.out.println("      "+ i +" \t"+burstTime[i]+"\t     "+waitingTime[i]+"\t\t    "+turnaroundTime[i]);
		}
		
		System.out.println("\n======================================================");
		
		System.out.println("Average Waiting Time "+ String.format("%.2f", (averageWTime = averageWTime/n)));
		
		System.out.println("Average Turn Around Time "+ String.format("%.2f", (averageTATime = averageTATime/n)));
		
		long cputimeAfter = System.currentTimeMillis();
		
		long cputimeDifference = cputimeAfter - cputimeBefore;
		
		System.out.println("CPU Time " + cputimeDifference);
	}	

}
