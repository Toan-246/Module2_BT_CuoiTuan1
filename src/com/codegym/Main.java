package com.codegym;
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
        Product[] products = new Product[2];
        products[0] = new Product(1, "Iphone 8", 10000000, "Old");
        products[1] = new Product(2, "Iphone 9", 12000000, "Old");
        do {
            menu();
            System.out.println("Mời bạn nhập lựa chọn");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    if (products.length == 0) {
                        System.out.println("Không có sản phẩm nào");
                    } else {
                        disPlayProducts(products);
                    }
                    break;
                }
                case 2: {
                    System.out.println("---Thêm sản phẩm---");
                    System.out.println("Nhập vị trí muốn thêm");
                    int index = scanner.nextInt();
                    if (index < 0 || index > products.length) {
                        System.out.println("Vị trí nhập không hợp lệ");
                    } else {
                        Product newProduct = inputProduct();
                        Product[] newProducts = addProduct(products, index, newProduct);
                        products = newProducts;
                    }

                    break;
                }
                case 3: {
                    System.out.println("---Cập nhật sản phẩm---");
                    System.out.println("Nhập vị trí muốn cập nhật");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= products.length) {
                        System.out.println("Vị trí nhập không hợp lệ");
                    } else {
                        Product newProduct = inputProduct();
                        products[index] = newProduct;
                    }
                    break;
                }
                case 4: {
                    System.out.println("---Xóa Sản Phẩm---");
                    System.out.println("Nhập vị trí muốn xóa");
                    int index = scanner.nextInt();
                    if (index < 0 || index >= products.length) {
                        System.out.println("Vị trí nhập không hợp lệ");
                    } else {
                        Product[] newProducts = removeProduct(products, index);
                        products = newProducts;
                    }
                    break;
                }
                case 5: {
                    System.out.println("---Sắp xếp sản phẩm theo tên---");
                    Product []newProducts = sortProducts(products);
                    products = newProducts;
                    break;
                }
                case 6: {
                    System.out.println("---Tìm kiếm sản phẩm theo tên");
                    scanner.nextLine();
                    System.out.println("Nhập tên SP muốn tìm");
                    String name = scanner.nextLine();
                    int index = -1;
                    for (int i = 0 ; i < products.length; i++){
                        if (products[i].getName().equalsIgnoreCase(name)){// thêm IgnoreCase để không phân biệt hoa thường
                            index = i;
                            break;
                        }
//                        if (products[i].getName().contains(name)){// Kiểm tra gần đúng => nhập iphone => hiển thị tất cả iphone
//                        }
                    }
                    if (index == -1) {
                        System.out.println("Không tìm thấy sản phẩm");
                    }
                    else {
//                        System.out.println("Thông tin sản phẩm là: " + products[index]);
                        System.out.println("Thông tin sản phẩm là: " + products[index]);
                    }
                    break;
                }
                default: {
                    System.out.println("Nhập số từ 0 - 6");
                    break;
                }
            }
        } while (choice != 0);
    }

    public static Product[] removeProduct(Product[] products, int index) {
        Product[] newProducts = new Product[products.length - 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = products[i];
            } else {
                newProducts[i] = products[i + 1];
            }
        }
        return newProducts;
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

    public static void disPlayProducts(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }
    }

    public static Product inputProduct() {
        System.out.println("Nhập thông tin sản phẩm");
        System.out.println("Nhập ID sản phẩm");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên của sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập giá của sản phẩm");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập Mô tả của sản phẩm");
        String discription = scanner.nextLine();
        Product newProduct = new Product(id, name, price, discription);
        return newProduct;
    }

    public static Product[] addProduct(Product[] products, int index, Product newProduct) {
        Product[] newProducts = new Product[products.length + 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = products[i];
            } else if (i == index) {
                newProducts[i] = newProduct;
            } else {
                newProducts[i] = products[i - 1];
            }
        }
        return newProducts;
    }
    public static Product[] sortProducts (Product[] products){
        for (int i =0; i< products.length; i++){
            for (int j =0; j< products.length; j++){
                if (products[i].getName().compareTo(products[j].getName()) < 0) {
                    Product temp = products [i];
                    products[i] = products [j];
                    products[j] = temp;
                }
            }
        }
        return products;
    }
}
