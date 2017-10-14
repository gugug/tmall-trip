package www.gdufs.tmall.dao;

import www.gdufs.tmall.bean.Category;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public interface ICategoryDao {
    //1. 增加
    void add(Category bean);

    //2. 删除
    void delete(int id);

    //3. 修改
    void update(Category bean);

    //4. 根据id获取
    Category get(int id);

    //5. 分页查询
    List<Category> list(int start, int count);

    //6. 查询所有
    List<Category> list();

    //7. 获取总数
    int getTotal();
}
