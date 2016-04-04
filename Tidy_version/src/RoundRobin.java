import java.util.Scanner;

public class RoundRobin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, sum, timeQuantum;
		int waitingTime[], burstTimeInput[], turnaroundTime[], burstTimeOutput[];
		float averageWTime = 0;
		float averageTATime = 0;
		
		System.out.println("===== Round Robin =====\n"); 

		
		Scanner num = new Scanner(System.in);
		System.out.println("Enter number of process"); 
		n = num.nextInt();
		
		waitingTime = new int[n];
		burstTimeInput = new int[n];
		turnaroundTime = new int[n];
		burstTimeOutput = new int[n];
		
		//System.out.println("Enter number of process?");

		
		for(int i = 0; i < n; i++){
			System.out.println("Enter the burst time for process " +(i+1));
			burstTimeInput[i] = num.nextInt();
		}
		
		System.out.println("Enter time quantum?");
		
		timeQuantum = num.nextInt();
		
		for(int i = 0; i < n; i++){
			burstTimeOutput[i] = burstTimeInput[i];
		}
		
		for(int i = 0; i < n; i++){
			waitingTime[i] = 0;
		}
		
		do {
			for(int i = 0; i < n; i++){
				if(burstTimeInput[i] > timeQuantum){
					burstTimeInput[i] -= timeQuantum;
					
					for(int j = 0; j < n; j++){
						if((j != i) && (burstTimeInput[j] != 0 )){
							waitingTime[j] += timeQuantum;
						}
					}
				}else{
					for(int j = 0; j < n; j++){
						if((j != i) && (burstTimeInput[j] != 0)){
							waitingTime[j] += burstTimeInput[i];
						}
					
					}
					burstTimeInput[i]=0;
				}
			}
			
			sum = 0;
			
			for(int k = 0; k < n; k++){
				sum = sum + burstTimeInput[k]; 
			}
			
		}while(sum != 0);
		
		for(int i = 0; i < n; i++){
			turnaroundTime[i] = waitingTime[i] + burstTimeOutput[i];
		}
		
		System.out.println("\n====================== TABLE =========================");

		System.out.print(" ____________________________________________________\n");
		System.out.println("| Process | BurstTime | WaitingTime | TurnAroundTime |");	
		
		for(int i = 0; i < n; i++){
			System.out.println("      "+ i +" \t"+burstTimeOutput[i]+"\t     "+waitingTime[i]+"\t\t    "+turnaroundTime[i]);
		}
		
		System.out.println("\n======================================================");
			
		for(int j = 0; j < n; j++){
			averageWTime += waitingTime[j]; 
		}
		
		for(int j = 0; j < n; j++){
			averageTATime += turnaroundTime[j]; 
		}
		
		System.out.println("Average Waiting Time : "+ String.format("%.2f", (averageWTime = averageWTime/n)));
		System.out.println("Average Turn Around Time : "+ String.format("%.2f", (averageTATime = averageTATime/n)));

		
	}

}
