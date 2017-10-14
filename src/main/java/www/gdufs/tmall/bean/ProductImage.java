package www.gdufs.tmall.bean;

/**
 * Created by gu on 2017/10/14.
 */
public class ProductImage {
    private int id;
    private Product product;
    private String type;

    public ProductImage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
