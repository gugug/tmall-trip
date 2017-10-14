package www.gdufs.tmall.dao.impl;

import www.gdufs.tmall.bean.Category;
import www.gdufs.tmall.bean.Product;
import www.gdufs.tmall.bean.ProductImage;
import www.gdufs.tmall.bean.Property;
import www.gdufs.tmall.dao.IProductImageDao;
import www.gdufs.tmall.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public class ProductImageDao implements IProductImageDao {
    @Override
    public void add(ProductImage bean) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(ProductImage bean) {

    }

    @Override
    public ProductImage get(int id) {
        return null;
    }

    @Override
    public List<ProductImage> list(int pid, int start, int count) {
        List<ProductImage> beans = new ArrayList<>();
        String sql = "select * from productimage where cid = ? order by id desc limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, pid);
            ps.setInt(2, start);
            ps.setInt(3, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProductImage bean = new ProductImage();
                int id = rs.getInt(1);
                bean.setId(id);
                String type = rs.getString(3);
                bean.setType(type);
                Product product = new ProductDao().get(pid);
                bean.setProduct(product);
                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

    @Override
    public List<ProductImage> list(int pid) {
        return list(pid, 0, Short.MAX_VALUE);
    }

    @Override
    public int getTotal(int pid) {
        int total = 0;
        String sql = "select count(*) from productimage where pid = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }
}
