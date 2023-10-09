package exam_advance_3;

import java.util.LinkedList;
import java.util.Queue;

import static Exam_Advance_1.ra.run.ProductManagement.scanner;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU**************");
            System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
            System.out.println("2. Phụ huynh tiếp theo");
            System.out.println("3. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("nhập tên phụ huynh:");
                    String parentName = scanner.nextLine();
                    queue.offer(parentName);
                    break;
                case 2:
                    if(!queue.isEmpty()){
                    System.out.println("Phụ huynh tiếp theo:" + queue.poll());
                    }else {
                        System.out.println("không có phụ huynh tiếp theo");
                    }
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
