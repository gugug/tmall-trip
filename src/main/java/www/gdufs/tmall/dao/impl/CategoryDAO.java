package www.gdufs.tmall.dao.impl;

import www.gdufs.tmall.bean.Category;
import www.gdufs.tmall.dao.ICategoryDao;
import www.gdufs.tmall.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * jdk1.7之后，就会采用这种方式自动关闭。 既保证了关闭，又能使得代码更优雅
 * Created by gu on 2017/10/14.
 * <p>
 * 当Statment关闭的时候，这个Result就会自动关闭了
 * <P><B>Note:</B> A <code>ResultSet</code> object
 * is automatically closed by the
 * <code>Statement</code> object that generated it when
 * that <code>Statement</code> object is closed,
 * re-executed, or is used to retrieve the next result from a
 * sequence of multiple results.
 * <p>
 * <p>
 * 这是JDK1.7的新特性，try-resource-catch，可以实现代码执行完之后圆括号内的资源自动关闭。
 * <p>
 * 前提是那些资源得实现了Autocloseable接口。
 * <p>
 * 关于此接口可以查阅JDK API，此处摘录一小段。
 * public interface AutoCloseable
 * An object that may hold resources (such as file or socket handles) until it is closed.
 * The close() method of an AutoCloseable object is called automatically when exiting
 * a try-with-resources block for which the object has been declared in the resource
 * specification header. This construction ensures prompt release, avoiding resource
 * exhaustion exceptions and errors that may otherwise occur.
 */
public class CategoryDAO implements ICategoryDao {

    @Override
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) from category";
        try (Connection c = DBUtil.getConnection(); PreparedStatement s = c.prepareStatement(sql);) {
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void add(Category bean) {

        String sql = "insert into category values(null,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, bean.getName());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from category where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category bean) {
        String sql = "update category set name= ? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setString(1, bean.getName());
            ps.setInt(2, bean.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Category get(int id) {
        Category bean = null;
        String sql = "select * from category where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                bean = new Category();
                bean.setName(resultSet.getString(2));
                bean.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public List<Category> list(int start, int count) {
        List<Category> beans = new ArrayList<>();
        String sql = "select * from Category order by id desc limit ?,? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category bean = new Category();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                bean.setId(id);
                bean.setName(name);
                beans.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return beans;
    }

    @Override
    public List<Category> list() {
        return list(0, Short.MAX_VALUE);
    }

}
