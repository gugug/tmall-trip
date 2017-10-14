package www.gdufs.tmall.dao.impl;

import www.gdufs.tmall.bean.Order;
import www.gdufs.tmall.bean.OrderItem;
import www.gdufs.tmall.dao.IOrderItemDao;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public class OrderItemDao implements IOrderItemDao {
    @Override
    public int getSaleCount(int pid) {
        return 0;
    }

    @Override
    public List<OrderItem> listByOrder(int oid) {
        return null;
    }

    @Override
    public List<OrderItem> listByUser(int uid) {
        return null;
    }

    @Override
    public void fill(Order o) {

    }

    @Override
    public void fill(List<Order> os) {

    }
}
