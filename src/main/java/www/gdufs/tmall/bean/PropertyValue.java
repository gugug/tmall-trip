package www.gdufs.tmall.bean;

/**
 * Created by gu on 2017/10/14.
 */
public class PropertyValue {
    private int id;
    private Product product;
    private Property property;
    private String value;

    public PropertyValue() {
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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
