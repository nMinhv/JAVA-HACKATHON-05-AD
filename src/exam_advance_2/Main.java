package exam_advance_2;

import java.util.Stack;

import static Exam_Advance_1.ra.run.ProductManagement.scanner;

public class Main {

    static Stack<String> stringStack = new Stack<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU**************");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    inputString();
                    break;
                case 2:
                    reversString();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    private static void reversString() {
        StringBuilder revers = new StringBuilder();
        int size = stringStack.size();
        for (int i = 0; i < size; i++) {
            revers.append(stringStack.pop()).append(" ");

        }
        System.out.println("Chuỗi đảo ngược:");
        System.out.println(revers);
    }

    public static void inputString() {
        System.out.println("nhập vào 1 chuỗi:");
        String str = scanner.nextLine();
        System.out.println("Nhập vào: " + str);
        String[] arrStr = str.split(" ");
        for (String s : arrStr
        ) {
            stringStack.push(s);
        }

    }

}
