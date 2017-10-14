package www.gdufs.tmall.dao;

import www.gdufs.tmall.bean.Category;
import www.gdufs.tmall.bean.Product;

import java.util.Calendar;
import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public interface IProductDao {
    //获取产品
    Product get(int id);

    //查询某分类的产品
    List<Product> list(int cid);
    List<Product> list(int cid, int start, int count);

    //查询某种分类下的产品数量
    int getTotal(int cid);

    //为分类填充产品集合
    void fill(Category c);
    void fill(List<Category> cs);

    //为多个分类设置多个productByRow属性
    void fillByRow(List<Category> cs);

    //根据关键字查询商品
    List<Product> search(String keyword, int start, int count);

    //一个产品有多个图片，但只有一个主图片，把第一个图片设置为主图片
    void setFirstProductImage(Product p);

    //为产品设置销量和评价数量
    void setSaleAndReviewNumber(Product p);
    void setSaleAndReviewNumber(List<Product> ps);



}
