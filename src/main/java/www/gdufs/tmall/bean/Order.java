package www.gdufs.tmall.bean;

import www.gdufs.tmall.dao.OrderDAO;

import java.util.Date;
import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public class Order {
    private int id;
    private String orderCode;
    private String address;
    private String post;
    private String receiver;
    private String mobile;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDaye;
    private Date confirmDate;
    private User user;
    private String status;
    private List<OrderItem> orderItems;
    private float totalMoney;
    private int totalNumber;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getDeliveryDaye() {
        return deliveryDaye;
    }

    public void setDeliveryDaye(Date deliveryDaye) {
        this.deliveryDaye = deliveryDaye;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getStatusDesc() {
        String desc = "未知";
        switch (status) {
            case OrderDAO.waitPay:
                desc = "待付款";
                break;
            case OrderDAO.waitDelivery:
                desc = "待发货";
                break;
            case OrderDAO.waitConfirm:
                desc = "待收货";
                break;
            case OrderDAO.waitReview:
                desc = "等评价";
                break;
            case OrderDAO.finish:
                desc = "完成";
                break;
            case OrderDAO.delete:
                desc = "刪除";
                break;
            default:
                desc = "未知";
        }
        return desc;
    }

}
