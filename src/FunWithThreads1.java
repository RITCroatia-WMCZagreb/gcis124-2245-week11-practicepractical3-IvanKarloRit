public class FunWithThreads1 {


    //Constructor of FunWithThreads
    public FunWithThreads1(){
        System.out.println("MAIN START");
        Thread t1 = new Thread(new MyThread("Thread 1"));
        Thread t2 = new Thread(new MyThread("Thread 2"));
        t1.start();
        t2.start();
        System.out.println("MAIN END");
    }

    public static void main(String[] args) throws Exception {
        new FunWithThreads1();
    }

    class MyThread implements Runnable{
        private String name;

        public MyThread(String name){
            this.name = name;
        }

        @Override
        public void run() {
            for(int i=0;i<10;i++){
                System.out.println(this.name + " " + i);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }

    /*
     * 
     * 
     * Main Thread START
        Main Thread END
        Thread 1 0
        Thread 2 0
        Thread 1 1
        Thread 2 1
        Thread 1 2
        Thread 2 2
        Thread 1 3
        Thread 2 3
        Thread 1 4
        Thread 2 4
        Thread 1 5
        Thread 2 5
        Thread 1 6
        Thread 2 6
        Thread 1 7
        Thread 2 7
        Thread 1 8
        Thread 2 8
        Thread 1 9
        Thread 2 9
     */


}
