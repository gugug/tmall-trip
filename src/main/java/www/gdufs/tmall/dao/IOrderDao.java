package www.gdufs.tmall.dao;

import www.gdufs.tmall.bean.Order;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public interface IOrderDao {
    //表示订单的类型，实体类的Order的getDesc方法中用到了这些属性
    // 因为订单是很重要的东西，包含了很多关键信息，金额，用户信息等，所以不会真正地删除而是改变状态，做标记
    public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";

    //查询制定用户的订单
    List<Order> list(int uid, String excludeStatus);
    List<Order> list(int uid, String excludeStatus, int start, int count);

}
