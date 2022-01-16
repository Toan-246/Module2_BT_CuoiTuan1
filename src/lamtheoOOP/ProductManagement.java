package lamtheoOOP;

public class ProductManagement {
    private Product[] products = new Product[0];

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public void disPlayAllProduct() {
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + "\t" + products[i]);
        }
    }

    public void addNewProduct(int index, Product newProduct) {
        Product[] newProducts = new Product[this.products.length + 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = this.products[i];
            } else if (i == index) {
                newProducts[i] = newProduct;
            } else newProducts[i] = this.products[i - 1];
        }
        this.products = newProducts;
    }

    public void removeProduct(int index) {
        Product[] newProducts = new Product[this.products.length - 1];
        for (int i = 0; i < newProducts.length; i++) {
            if (i < index) {
                newProducts[i] = products[i];
            } else {
                newProducts[i] = products[i + 1];
            }
        }
        this.products = newProducts;
    }

    public void updateProduct(int index, Product newProduct) {
        this.products[index] = newProduct;
    }

    public void sortProduct() {
        for (int i = 0; i < this.products.length; i++) {
            for (int j = 0; j < this.products.length; j++) {
                if (this.products[i].getName().compareTo(this.products[j].getName()) < 0) {
                    Product temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
    }
    public void findProduct (int index, String name){
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i].getName().equalsIgnoreCase(name)){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("Không tìm thấy sản phẩm");
        }
        else {
            System.out.println("Thông tin sản phẩm là " + this.products[index]);
        }
    }
}
