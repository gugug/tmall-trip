package www.gdufs.tmall.dao;

import www.gdufs.tmall.bean.Review;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public interface IReviewDao {

    //获取指定产品的评价数量
    int getCount(int pid);

    //获取指定产品的评价
    List<Review> list(int pid);
    List<Review> list(int pid, int start, int count);


}
