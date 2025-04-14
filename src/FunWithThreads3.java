public class FunWithThreads3 {

    //ONE COMMON COUNTER, TWO THREADS ARE ADDING 1 40,000 TIMES
    //THE FINAL RESULT SHOULD BE 80,000

    private int counter;
    private Object lock;


    //Constructor of FunWithThreads
    public FunWithThreads3(){
        System.out.println("MAIN START");
        counter=0;
        this.lock = new Object();

        //Creating threads
        Thread t1 = new Thread(new MyThread("1"));
        Thread t2 = new Thread(new MyThread("2"));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("COUNTER:" + this.counter);
       

        
        System.out.println("MAIN END");
    }

    public static void main(String[] args) throws Exception {
        
        new FunWithThreads3();

    }

    class MyThread implements Runnable{
        private String name;

        public MyThread(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread start: " + this.name);
            for(int i=0;i<40000;i++){
                synchronized(lock){
                    counter++;
                }
            }
            System.out.println("Thread end: " + this.name);
        }
        
    }

    
}

