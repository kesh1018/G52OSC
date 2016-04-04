import java.util.Scanner;

public class Banker_Algorithm {
	
	private static int i;
	private static int j;

	public static void main (String[] args){
		
		int[][] current = new int[5][5];
		int[][] maxclaim = new int[5][5];
		int[] avl = new int[5];
		int[] alloc = {0,0,0,0,0};
		int[] maxres = new int[5];
		int[] running = new int[5];
		
		int count = 0;
		
		System.out.println("Enter number of processes:");
		Scanner input = new Scanner(System.in);
		int process = input.nextInt();
		
		for (i=0;i < process;i++){
			running[i] = 1;	
			count++;
		}
		
		System.out.println("Enter number of resources:");
		int resource = input.nextInt();
		
		System.out.println("Enter claim vector:");
		for(i = 0; i < resource;i++){
			maxres[i] = input.nextInt();
			
		}
		
		System.out.println("Enter Allocated Resource Table:");
		for (i=0; i<process;i++){
			for(j=0;j<resource;j++){
				current[i][j]=input.nextInt();
				
			}
		}
		
		System.out.println("Enter Maximum Claim Table:");
		for (i=0;i<process;i++){
			for(j=0;j<resource;j++){
				maxclaim[i][j] = input.nextInt();
			}
		}
			
		System.out.print("The claim vector:");
		for(i = 0; i < resource;i++){
			System.out.print(""+maxres[i]+" ");
			
		}	
		
		System.out.println("\nThe Allocated Resource Table:");
		for(i = 0; i < process;i++){
			for(j=0;j<resource;j++){
				System.out.print(""+current[i][j]+" ");

			}
			
			System.out.print("\n");
			
		}
		
		System.out.println("\nThe Maximum Claim Table:");
		for(i = 0; i < process;i++){
			for(j=0;j<resource;j++){
				System.out.print(""+maxclaim[i][j]+" ");

			}
			
			System.out.print("\n");
			
		}
		
		for(i = 0; i < process;i++){
			for(j=0;j<resource;j++){
				alloc[j] += current[i][j];
			}
		}
			
		System.out.print("\nAllocated resources:");
		for(i = 0; i < resource;i++){
			System.out.print(""+alloc[i]+" ");
			
		}	
		
		for(i=0;i<resource;i++){
			avl[i] = maxres[i] - alloc[i];
		}
		
		System.out.print("\nAvailable resources:");
		for(i=0;i<resource;i++){
			System.out.print(""+avl[i]+" ");
		}
		
		System.out.print("\n");
		
		while(count != 0){
			int safe = 0;
			for (i=0;i<process;i++){
				if(running[i]==1){
					int exec = 1;
					for(j=0;j<resource;j++){
						if (maxclaim[i][j] - current[i][j] > avl[j]){
							exec = 0;
							break;	
						}
					}
					
					if(exec!=0){
						System.out.println("Process "+(i+1)+" is executing");
						running[i] = 0;
						count--;
						safe = 1;
						
						for(j = 0;j < resource;j++){
							avl[j] += current[i][j];
						}
						
						break;
						
					}
				}
			}
			
			if (safe == 0){
				System.out.println("\nThe processes are in unsafe state.");
				break;	
			}else {
				System.out.println("\nThe process is in safe state");
				System.out.print("Available vector:");
				
				for(i=0; i < resource; i++){
					System.out.print(""+avl[i]+" ");
					
				}
				
				System.out.print("\n");
			}
			
		}		
		
	}

}
