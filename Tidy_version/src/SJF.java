import java.util.Scanner;

public class SJF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		int waitingTime[], burstTime[], turnaroundTime[];
		float averageWTime = 0, averageTATime = 0;
		
		System.out.println("===== Shortest Job First (SJF) =====\n"); 

		
		Scanner num = new Scanner(System.in);
		System.out.println("Enter number of process"); 
		n = num.nextInt();
		
		waitingTime = new int[n+1];
		burstTime = new int[n+1];
		turnaroundTime = new int[n+1];
		
		//System.out.println("Enter number of process?");
		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the burst time for process " +(i+1));
			burstTime[i] = num.nextInt();
		}
		
		for(int i = 0; i < n; i++){
			waitingTime[i]=0;
			turnaroundTime[i]=0;
		}
		
		int temp; 
		
		for(int i = 0; i < n; i++){
			for(int j=0;j<n-1;j++){ 	
				if(burstTime[j] > burstTime[j+1]){
					temp = burstTime[j]; 
					burstTime[j] = burstTime[j+1]; 
					burstTime[j+1] = temp; 
					
					temp = waitingTime[j]; 
					waitingTime[j] = waitingTime[j+1]; 
					waitingTime[j+1] = temp; 
				}
			}
		} 
		
		for(int i=0;i < n; i++){
			turnaroundTime[i] = burstTime[i]+ waitingTime[i]; 
			waitingTime[i+1] = turnaroundTime[i]; 
		} 
		turnaroundTime[n] = waitingTime[n]+ burstTime[n]; 
		
		System.out.println("\n====================== TABLE =========================");

		System.out.print(" ____________________________________________________\n");
		System.out.println("| Process | BurstTime | WaitingTime | TurnAroundTime |");	
		
		for(int i = 0; i < n; i++){
			System.out.println("      "+ i +" \t"+burstTime[i]+"\t     "+waitingTime[i]+"\t\t    "+turnaroundTime[i]);
		}
		
		System.out.println("\n======================================================");
			
		for(int j = 0; j < n; j++){
			averageWTime += waitingTime[j]; 
		}
		
		for(int j = 0; j < n; j++){
			averageTATime += turnaroundTime[j]; 
		}
		
		
		System.out.println("Average Waiting Time "+ String.format("%.2f", (averageWTime = averageWTime/n)));
		System.out.println("Average TurnAround Time "+ String.format("%.2f", (averageTATime/n)));

		
	}
}
