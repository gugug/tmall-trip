package www.gdufs.tmall.dao;

import www.gdufs.tmall.bean.Property;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public interface IPropertyDao {
    //    获取某种分类下的属性总数，在分页显示的时候会用到
    int getTotal(int cid);

    //    查询某个分类下的的属性对象
    List<Property> list(int cid, int start, int count);

    List<Property> list(int cid);

    void add(Property bean);

    void update(Property bean);

    void delete(int id);

    Property get(String name, int cid);

    Property get(int id);
}
