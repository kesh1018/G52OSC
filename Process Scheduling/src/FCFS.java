import java.util.Scanner;

public class FCFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		int waitingTime[], burstTime[], turnaroundTime[];
		float averageWTime = 0;
		
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
		
		waitingTime[0] = 0;
		
		for(int i = 1; i < n; i++) 
		{ 
			waitingTime[i]=waitingTime[i-1]+burstTime[i-1]; 
		} 
		
		for(int i = 0; i < n; i++) 
		{ 
			turnaroundTime[i] = waitingTime[i] + burstTime[i];
			averageWTime = averageWTime + waitingTime[i];
		} 
		
		System.out.println("Process BurstTime WaitingTime TurnAroundTime");
		
		for(int i = 0; i < n; i++){
			System.out.println("    "+ i +"           "+burstTime[i]+"           "+waitingTime[i]+"        "+turnaroundTime[i]);
		}
		
		System.out.println("Average Waiting Time "+ String.format("%.2f", (averageWTime = averageWTime/n)));
	}	

}
