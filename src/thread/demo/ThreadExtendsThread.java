package thread.demo;

import java.util.*; //Để sử dụng random
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nhat
 */
public class ThreadExtendsThread extends Thread { // Thừa kế lại object Thread

    Random r = null;

    public ThreadExtendsThread() { //Hàm khởi tạo
        r = new Random();
        this.start(); //This = ThreadExtendsThread
    }

    @Override //Ghi đè lại phương thúc run
    public void run() {
        while(true){ //Chạy mãi mãi
            System.out.println("Ngau nhien : " + r.nextInt()); //Số nguyên ngẫu nhiên
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadExtendsThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    public static void main(String[] args) {
        new ThreadExtendsThread();
    }

}
