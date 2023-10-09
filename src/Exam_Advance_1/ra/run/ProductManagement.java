package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Catalog> catalogs = new LinkedList<>();
    public static List<Product> products = new LinkedList<>();

    public static void main(String[] args) {
        catalogs.add(new Catalog(1, "catalog1", 1, "desc1", true));
        catalogs.add(new Catalog(2, "catalog2", 1, "desc3", true));
        catalogs.add(new Catalog(3, "catalog3", 1, "desc2", true));
        products.add(new Product(1, "product1", "product1", "descProduct1", catalogs.get(1), 1, 2, true));
        products.add(new Product(2, "product2", "product2", "descProduct2", catalogs.get(1), 1, 4, true));
        products.add(new Product(3, "product3", "product3", "descProduct3", catalogs.get(1), 1, 3, true));
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU**************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator)");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm ");
            System.out.println("5. Thoát ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    searchProductByCatalog();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
            }
        }
    }

    public static void addCatalog() {
        System.out.println("Nhập số danh mục muốn thêm: ");
        int addCatalogs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < addCatalogs; i++) {
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            catalogs.add(newCatalog);
        }
    }

    public static void addProduct() {
        System.out.println("Nhập số sản phẩm muốn thêm:");
        int addProducts = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < addProducts; i++) {
            Product newProduct = new Product();
            newProduct.inputData();
            products.add(newProduct);
            newProduct.displayData();
        }
        displayProduct();
    }

    public static void sortProductByPrice() {
        products.sort(Product::compareTo);
        displayProduct();

    }

    public static void searchProductByCatalog() {
        System.out.println("Nhập tên danh mục sản phẩm muốn tìm:");
        String findCatalog = scanner.nextLine();
        boolean found = false;
        for (Product product : products
        ) {
            if (product.getCatalog().getCatalogName().trim().toLowerCase().contains(findCatalog.toLowerCase())) {
                product.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.printf("không tìm thấy sản phẩm nào thuộc danh mục %s\n", findCatalog);
        }
    }

    public static void displayProduct() {
        for (Product product : products
        ) {
            product.displayData();
            System.out.println("----------");
        }
    }
    public static void displayCatalog(){
        for (Catalog catalog: catalogs
             ) {
            catalog.displayData();
        }
    }
}
