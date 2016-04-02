package deadlock;

public class Deadlock {
 
    public static void main(String[] args) {
    	
        Deadlock demo = new Deadlock();
 
        final A resource1 = demo.new A();
        final B resource2 = demo.new B();
 
        // Thread-1
        Runnable block1 = new Runnable() {
            public void run() {
                synchronized (resource1) {
                	System.out.println("Thread1 acquired lock A");
                    try {
                        // Adding delay so that both threads can start trying to
                        // lock resources
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Thread-1 have A but need B also
                    synchronized (resource2) {
                    	System.out.println("Thread1 acquired lock B");
                    }
                }
            }
        };
        
        
        
        // Thread-2
        Runnable block2 = new Runnable() {
            public void run() {
                synchronized (resource2) {
                	System.out.println("Thread2 acquired lock B");
                    // Thread-2 have B but need A also
                    synchronized (resource1) {
                    	System.out.println("Thread2 acquired lock A");
                    }
                }
            }
        };
        new Thread(block1).start();
        new Thread(block2).start();
    }
    
    // Resource A
    private class A {
        private int i = 5;
 
        public int getI() {
            return i;
        }
 
        public void setI(int i) {
            this.i = i;
        }
    }
 
    // Resource B
    private class B {
        private int i = 2;
 
        public int getI() {
            return i;
        }
 
        public void setI(int i) {
            this.i = i;
        }
    }
}