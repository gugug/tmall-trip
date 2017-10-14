package www.gdufs.tmall.bean;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 * Category 除了基本属性id和name的getter和setter外，还提供了一对多关系 products的 getter与setter。
 */
public class Category {

    private String name;
    private int id;
    private List<Product> products;
    private List<List<Product>> productsByRow;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<List<Product>> getProductsByRow() {
        return productsByRow;
    }

    public void setProductsByRow(List<List<Product>> productsByRow) {
        this.productsByRow = productsByRow;
    }
}
