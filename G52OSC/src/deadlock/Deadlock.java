package deadlock;

import java.util.Scanner;

public class Deadlock {
	 
	private int p, r, needMatrix[][], allocateMatrix[][], maxMatrix[][], availMatrix[][];

	public static void main(String[] args) {
	
			new Deadlock().checkDeadlock();
		
	}
	      
    private void input(){
    	 Scanner input = new Scanner(System.in);
     
	     System.out.print("Enter no. of processes and resources : ");
	     
	     p = input.nextInt();  //no. of process
	     r = input.nextInt(); //no. of resources
	     
	     needMatrix = new int[p][r];  //initializing arrays
	     maxMatrix = new int[p][r];
	     allocateMatrix = new int[p][r];
	     availMatrix = new int[1][r];
	      
	     System.out.println("Enter allocation matrix : ");
	     
	     for(int i = 0; i < p; i++){
	    	 for(int j = 0; j < r; j++){
	    		 allocateMatrix[i][j] = input.nextInt();  //allocation matrix
	  	       
	          }
	     }
	          
	     System.out.println("Enter max matrix : ");
	     
	     for(int i = 0;i < p; i++){
	    	 for(int j = 0; j < r; j++){
	    		 maxMatrix[i][j] = input.nextInt();  //max matrix
	    	 }
	    	 
	     }
	
	     System.out.println("Enter available matrix : ");
	     
	     for(int j = 0; j < r; j++){
	    	 availMatrix[0][j] = input.nextInt();  //available matrix
	     }

    }

    public void checkDeadlock(){
    	
 	   input();
       calculateNeedMatrix();
       
       boolean done[] = new boolean[p];
       int j=0;
       
       while(j < p){  //until all process allocated
    	   
    	   boolean allocated = false;
	       
	       for(int i = 0;i < p; i++)
	    	   if(!done[i] && check(i)){
	    		   for(int k = 0;k < r; k++)
	    			   availMatrix[0][k] = availMatrix[0][k] - needMatrix[i][k] + maxMatrix[i][k];

	    		   System.out.println("Allocated process : "+i);
	    		   allocated = done[i] = true;
	               j++;
	    	   }    
	          if(!allocated) break;  //if no allocation
       }
       
       if(j == p) //if all processes are allocated
    	   System.out.println("\nSafely allocated");
       else
    	   System.out.println("Deadlock Occured"); 
       
    }
    
    private int[][] calculateNeedMatrix(){
    	
       for(int i = 0; i < p; i++){
    	   for(int j = 0; j < r; j++){ //calculating need matrix
          	 needMatrix[i][j] = maxMatrix[i][j] - allocateMatrix[i][j];
           }
       }
         
       return needMatrix;
    }
  
    private boolean check(int i){
       //check all process can be allocated
       for(int j = 0; j < r; j++) 
    	   if(availMatrix[0][j] < needMatrix[i][j])
    		   return false;
       
       return true;
    }

}
