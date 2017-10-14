package www.gdufs.tmall.dao;

import www.gdufs.tmall.bean.Order;
import www.gdufs.tmall.bean.OrderItem;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public interface IOrderItemDao {
    //获取一种产品的销量
    int getSaleCount(int pid);

    //查询某种订单下的所有订单项
    List<OrderItem> listByOrder(int oid);

    //查询某个用户购物车的订单项目
    List<OrderItem> listByUser(int uid);

    //为订单设置单项集合
    void fill(Order o);
    void fill(List<Order> os);
}
