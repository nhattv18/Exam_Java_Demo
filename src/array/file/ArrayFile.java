/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package array.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
 
class HocSinh implements Serializable {
 
    private String ten;
    private int tuoi;
 
    public String getTen() {
        return ten;
    }
 
    public void setTen(String ten) {
        this.ten = ten;
    }
 
    public int getTuoi() {
        return tuoi;
    }
 
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
 
public class ArrayFile {
 
    public static void main(String[] args) throws IOException {
        ArrayList<HocSinh> listHS = new ArrayList(); // Khai báo 1 đối tượng ArrayList, các phần tử tạo ra từ lớp HocSinh
 
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số học sinh: ");
        int n = input.nextInt();
 
        //Lấy dữ liệu và ghi vào file
 
        for (int i = 0; i < n; i++) {
            HocSinh x = new HocSinh(); //Tạo đối tượng x để lưu tạm thời dữ liệu
            System.out.println("Học sinh thứ " + i + ": ");
            input.nextLine(); //Dòng này để tránh bị trượt dòng!
 
            System.out.print("Tên: ");
            String tenX = input.nextLine();
 
            System.out.print("Tuổi: ");
            int tuoiX = input.nextInt();
 
            x.setTen(tenX);
            x.setTuoi(tuoiX);
 
            listHS.add(x);
 
        }
 
 
        try {
            FileOutputStream f = new FileOutputStream("E:\\hocsinh.txt");
            ObjectOutputStream oOT = new ObjectOutputStream(f); // Sử dụng để ghi file theo từng Object
            oOT.writeObject(listHS); // Ghi  Object là đối tượng x xuống file
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArrayFile.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 
        //Đọc dữ liệu từ file, lấy các object ra rồi gán vào ListHS
 
        ArrayList<HocSinh> listHS2 = new ArrayList(); // Khai báo 1 đối tượng ArrayList thứ 2, các phần tử tạo ra từ lớp HocSinh
        //Dùng để lưu dữ liệu riêng khi ta đọc file!                   
        try {
            FileInputStream f2 = new FileInputStream("E:\\hocsinh.txt");
            ObjectInputStream oIT = new ObjectInputStream(f2); // Sử dụng để đọc file theo từng Object
            listHS2 = (ArrayList<HocSinh>) oIT.readObject(); //Ép kiểu đối tượng lấy từ file ra về dạng ArrayList<HocSinh>
            oIT.close();
            f2.close();
        } catch (IOException io) {
            System.out.println("Có lỗi xảy ra!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Không tìm thấy class");
        }
 
        //In thông tin ra ngoài! Thông tin lấy từ đối tượng ListHS2 vừa đọc từ file
        System.out.println("Thông tin danh sách vừa nhập vào là: ");
        for (int i = 0; i < listHS2.size(); i++) {
            System.out.print("Học sinh thứ " + i);
            System.out.print(" - Tên " + listHS2.get(i).getTen() + " Tuổi: " + listHS2.get(i).getTuoi() + "\n");
        }
 
 
    }
}