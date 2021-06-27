import java.io.IOException;

public class start 
{
    public static void main(String[] args) throws IOException
    {
        Thread t1 = new tserver();
        Thread t2 = new tclient();
        t1.start();
        t2.start();
    }

    public static class tserver extends Thread 
    {
        public void run() 
        {
            try{server server = new server();}
            catch(IOException ex){}
        }
    }

    public static class tclient extends Thread
    {
        public void run()
        {
            try{client client = new client();}
            catch(IOException ex){}
        }
    }
}