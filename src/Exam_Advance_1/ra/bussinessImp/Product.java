package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;
import Exam_Advance_1.ra.run.ProductManagement;

import java.util.Comparator;

import static Exam_Advance_1.ra.run.ProductManagement.catalogs;
import static Exam_Advance_1.ra.run.ProductManagement.scanner;

public class Product implements IShop, Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        if (!catalogs.isEmpty()) {
            System.out.println("Nhập id sản phẩm:");
            this.productId = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tên sản phẩm:");
            this.productName = scanner.nextLine();
            System.out.println("Nhập tiêu đề sản phẩm:");
            this.title = scanner.nextLine();
            System.out.println("Nhập mô tả sản phẩm:");
            this.descriptions = scanner.nextLine();
            System.out.println("Nhập giá nhập sản phẩm:");
            this.importPrice = Float.parseFloat(scanner.nextLine());
            this.exportPrice = RATE * this.importPrice;
            System.out.println("Nhập trạng thái sản phẩm:");
            this.productStatus = Boolean.parseBoolean(scanner.nextLine());
            while (this.catalog == null) {
                System.out.println("Chọn danh mục sản phẩm theo mã:");
                ProductManagement.displayCatalog();
                int categorySelect = Integer.parseInt(scanner.nextLine());
                if (rstCatalog(categorySelect) != null) {
                    this.catalog = rstCatalog(categorySelect);
                } else {
                    System.out.println("Mã sản phẩm không hợp lệ, hãy nhập lại");
                }
            }

        } else {
            System.out.println("hiện chưa có danh mục sản phẩm, hãy thêm 1 danh mục sản phẩm trước.");
        }
    }

    private Catalog rstCatalog(int categorySelect) {

        for (Catalog catalog : catalogs
        ) {
            if (catalog.getCatalogId() == categorySelect) {
                return catalog;
            }
        }
        return null;
    }

    ;

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %d - Tên sản phẩm: %s - tiêu đề: %s\n", this.productId, this.productName, this.title);
        System.out.printf("Giá nhập: %.2f - Giá bán: %.2f - mô tả: %s\n", this.importPrice, this.exportPrice, this.descriptions);
        System.out.printf("danh mục: %s - trạng thái: %s\n", this.catalog.getCatalogName(), this.productStatus ? "đang bán" : "ngừng bán");
    }

    @Override
    public int compareTo(Product o) {
        if (this.exportPrice - o.getExportPrice() > 0) {
            return 1;
        } else if (this.exportPrice - o.getExportPrice() < 0) {
            return -1;
        }
        return 0;
    }
}
