package www.gdufs.tmall.dao.impl;

import www.gdufs.tmall.bean.Category;
import www.gdufs.tmall.bean.Product;
import www.gdufs.tmall.dao.IProductDao;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public class ProductDao implements IProductDao{
    @Override
    public Product get(int id) {
        return null;
    }

    @Override
    public List<Product> list(int cid) {
        return null;
    }

    @Override
    public List<Product> list(int cid, int start, int count) {
        return null;
    }

    @Override
    public int getTotal(int cid) {
        return 0;
    }

    @Override
    public void fill(Category c) {

    }

    @Override
    public void fill(List<Category> cs) {

    }

    @Override
    public void fillByRow(List<Category> cs) {

    }

    @Override
    public List<Product> search(String keyword, int start, int count) {
        return null;
    }
}
