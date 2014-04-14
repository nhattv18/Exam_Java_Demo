package employee.arraylist;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Employee e;
        int choice;
        HashSet<Employee> hs = new HashSet();
        ArrayList<Employee> empList = new ArrayList();
        do {
            choice = menu();
            switch (choice) {
                //Thêm nhan vien
                case 1:
                    e = new Employee();

                    String idRegex = "^EMP\\d{3}$";
                    String nameRegex = "[A-Z]{3}";
                    String emailRegex = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
                    String birthDayRegex = "^\\d-\\d-\\d{4}$";

                    System.out.println("Nhap ID: ");
                    do {

                        e.setEmpID(kb.nextLine());
                        Pattern pID = Pattern.compile(idRegex, Pattern.CASE_INSENSITIVE);
                        Matcher mID = pID.matcher(e.getEmpID());
                        if (mID.find()) {
                            break;
                        } else {
                            System.out.println("Nhap lai ID: ");
                        }

                    } while (true);

                    System.out.println("Nhap ten: ");
                    do {
                        e.setFullName(kb.nextLine());
                        Pattern pName = Pattern.compile(nameRegex, Pattern.CASE_INSENSITIVE);
                        Matcher mName = pName.matcher(e.getFullName());
                        if (mName.find()) {
                            break;
                        } else {
                            System.out.println("Nhap lai ten: ");
                        }
                    } while (true);

                    System.out.println("Nhap Email: ");
                    do {
                        e.setEmail(kb.nextLine());
                        Pattern pEmail = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
                        Matcher mEmail = pEmail.matcher(e.getEmail());

                        if (mEmail.find()) {
                            break;
                        } else {
                            System.out.println("Nhap lai Email: ");
                        }
                    } while (true);

                    System.out.println("Nhap ngay sinh theo dang (d-m-yyyy): ");
                    do {
                        e.setBirthday(kb.nextLine());
                        Pattern pBirth = Pattern.compile(birthDayRegex);
                        Matcher mBirth = pBirth.matcher(e.getBirthday());

                        if (mBirth.find()) {
                            break;
                        } else {
                            System.out.println("Nhap lai ngay sinh theo dang d-m-y: ");
                        }
                    } while (true);

                    System.out.println("Nhap tien: ");
                    do {
                        e.setSalary(kb.nextDouble());
                        if (e.checkSalary() == true) {
                            break;
                        } else {
                            System.out.println("Nhap lai tien > 0: ");
                        }
                    } while (true);
                    empList.add(e);
                    System.out.println("Da them thanh cong! ");
                    break;

                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    for(int i=0; i<empList.size(); i++) {
                        System.out.println("ID " + empList.get(i).empID + " Ten: " + empList.get(i).fullName);
                    }
                    

                    break;
                case 0:
                    break;

            }
        } while (choice
                != 0);
    }

    public static int menu() {

        System.out.println("\n_____________________________________");
        System.out.println("1. Them nhan vien");
        System.out.println("2. Sửa tên nhân viên");
        System.out.println("3. Xóa tài khoản");
        System.out.println("4. Tìm kiếm ");
        System.out.println("5. Hiển thị toàn bộ nhân viên");
        System.out.println("0. Kết thúc");
        System.out.println("_____________________________________");

        Scanner kb = new Scanner(System.in);
        int input = -1;

        while (input < 0 || input > 5) {
            System.out.print("-> Lựa chọn của bạn: ");
            if (kb.hasNextInt()) {
                input = kb.nextInt();
            } else {
                System.out.println("* Không hợp lệ, vui lòng thử lại.");
            }
            kb.nextLine();
        }
        return input;
    }
}
