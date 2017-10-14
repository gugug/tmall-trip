package www.gdufs.tmall.dao.impl;

import www.gdufs.tmall.bean.Order;
import www.gdufs.tmall.dao.IOrderDao;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public class OrderDao implements IOrderDao {
    @Override
    public List<Order> list(int uid, String excludeStatus) {
        return null;
    }

    @Override
    public List<Order> list(int uid, String excludeStatus, int start, int count) {
        return null;
    }
}
