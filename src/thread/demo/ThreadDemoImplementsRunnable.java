package thread.demo;

import java.util.*; //Để sự dụng Random
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nhat
 */
public class ThreadDemoImplementsRunnable implements Runnable { //thực hiện thread từ 1 interface Runnable
    Random rd = null; // Khởi tạo đối tượng radom
    
    
    public ThreadDemoImplementsRunnable()    {
        rd = new Random();
        
        //Kích hoạt Thread
        Thread tr = new Thread(this); // This : chính là class ThreadDemoImplementsRunnable
        tr.start(); //Đưa thread vào lich trình CPU và gọi phương thức run
    }

    @Override
    public void run() {
            while(true){ //Chạy mãi mãi
                
                System.out.println("5 giay: " + rd.nextBoolean()); // Hiển thị lên màn hình số ngẫu nhiên
                try {
                    Thread.sleep(3000); //Sau 3 giây nghỉ rồi tiếp tục
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadDemoImplementsRunnable.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }

    public static void main(String[] args) { //Hàm main để chạy chương trình
            new ThreadDemoImplementsRunnable(); 
    }
}
