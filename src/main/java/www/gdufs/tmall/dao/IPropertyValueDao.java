package www.gdufs.tmall.dao;

import www.gdufs.tmall.bean.Product;
import www.gdufs.tmall.bean.PropertyValue;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public interface IPropertyValueDao {

    //根据属性id产品id，获取一个propertyValue对象
    PropertyValue get(int pid, int ptid);

    //初始化某个产品对应的属性值
    void init(Product p);

    //查询某个产品下所有的属性值
    List<PropertyValue> list(int pid);
}
