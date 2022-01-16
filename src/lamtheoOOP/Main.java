package lamtheoOOP;
/*
* Bài tập về nhà

Cho một mảng các sản phẩm(Sản phẩm có các thuộc tín: id, name, price, description) thực hiện các công việc sau:
1.	Xây dựng hàm thị danh sách các sản phẩm có trong mảng lên màn hình
2.	Xây dựng hàm thêm một sản phẩm vào mảng
3.	Xây dựng hàm xóa một sản phẩm khỏi mảng
4.	Xây dựng hàm tìm kiếm một sản phẩm trong mảng theo tên của sản phẩm đó.
5.	Xây dựng hàm sắp xếp các sản phẩm trong mảng theo thứ tự A->Z
6.	Xây dựng hàm cập nhật sản phẩm
*/

import java.util.Scanner;

/*
 * Làm theo dạng Menu
 * ---MENU QUẢN LÝ SẢN PHẨM---
 * 1. Hiển thị danh sách sản phẩm
 * 2. Thêm sản phẩm
 * 3. Cập nhật sản phẩm
 * 4. Xóa sản phẩm
 * 5. Sắp xêm sản phẩm theo tên
 * 6. Tìm kiếm sản phẩm theo tên
 * 0. Thoát
 * Mời bạn nhập lựa chọn
 * */
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        ProductManagement productManagement = new ProductManagement();
        do {
            menu();
            System.out.println("Mời bạn nhập lựa chọn");
            choice = scanner.nextInt();
            switch (choice){
                case 1: {
                    System.out.println("---Danh sách sản phẩm---");
                    if (productManagement.getProducts().length==0){
                        System.out.println("Không có sản phẩm nào");
                    }
                    else productManagement.disPlayAllProduct();
                    break;
                }
                case 2: {
                    System.out.println("---Thêm sản phẩm---");
                    System.out.println("Nhập vị trí muốn thêm");
                    int index = scanner.nextInt();
                    if (index < 0 || index > productManagement.getProducts().length){
                        System.out.println("Vị trí nhập không hợp lệ");
                    }
                    else {
                        Product product = inputProduct();
                        productManagement.addNewProduct(index, product);
                    }
                    break;
                }
                case 3:{
                    System.out.println("---Cập nhật sản phẩm---");
                    System.out.println("Nhập vị trí cập nhật");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= productManagement.getProducts().length) {
                        System.out.println("Vị trí nhập không hợp lệ");
                    }
                    else {
                        Product product = inputProduct();
                        productManagement.updateProduct(index, product);
                    }
                    break;
                }
                case 4: {
                    System.out.println("---Xóa sản phẩm---");
                    System.out.println("Nhập vị trí muốn xóa");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= productManagement.getProducts().length) {
                        System.out.println("Vị trí nhập không hợp lệ");
                    }
                    else {
                        productManagement.removeProduct(index);
                    }
                    break;
                }
                case 5:{
                    System.out.println("---Sắp xếp sản phẩm theo tên");
                    productManagement.sortProduct();
                    break;
                }
                case 6:{
                    System.out.println("---Tìm kiếm sản phẩm theo tên");
                    scanner.nextLine();
                    System.out.println("Nhập tên SP muốn tìm");
                    String name = scanner.nextLine();
                    int index = -1;
                    productManagement.findProduct(index,name);
                    break;
                }
                default:{
                    System.out.println("Nhập số trong khoảng từ 1 -> 6");
                }
            }
        } while (choice != 0);

    }

    public static void menu() {
        System.out.println("1. Hiển thị danh sách sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Cập nhật sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Sắp xêm sản phẩm theo tên");
        System.out.println("6. Tìm kiếm sản phẩm theo tên");
        System.out.println("0. Thoát chương trình");
    }
    public static Product inputProduct (){
        System.out.println("Nhập thông tin sản phẩm");
        System.out.println("Nhập ID sản phẩm");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm");
        String discription = scanner.nextLine();
        Product product = new Product(id, name, price, discription);

        return product;
    }

}
