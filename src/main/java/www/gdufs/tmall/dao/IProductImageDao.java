package www.gdufs.tmall.dao;

import www.gdufs.tmall.bean.Product;
import www.gdufs.tmall.bean.ProductImage;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public interface IProductImageDao {
    String TYPR_SINGLE = "type_single";
    String TYPE_DETAIL = "type_detail";

    //1. 增加
    void add(ProductImage bean);

    //2. 删除
    void delete(int id);

    //3. 修改
    void update(ProductImage bean);

    //4. 根据id获取
    ProductImage get(int id);

    //5. 分页查询
    List<ProductImage> list(int pid, int start, int count);

    //6. 查询所有
    List<ProductImage> list(int pid);

    //7. 获取总数
    int getTotal(int pid);

    //查询指定产品下某种类型的productImage
    List<ProductImage> list(Product p, String type);
    List<ProductImage> list(Product p, int start, int count);
}
