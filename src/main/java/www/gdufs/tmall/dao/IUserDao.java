package www.gdufs.tmall.dao;

import www.gdufs.tmall.bean.User;

import java.util.List;

/**
 * Created by gu on 2017/10/14.
 */
public interface IUserDao {

    //    根据用户名获取对象
    User get(String name);

    //    以boolean形式返回某个用户名是否已经存在
    boolean isExist(String name);

    //    根据账号和密码获取对象，这才是合理的判断账号密码是否正确的方式，而不是一下把所有的用户信息查出来，在内存中进行比较。
    User get(String name, String password);

    User get(int id);

    int getTotal();

    // 增加用户
    void add(User bean);

    // 更新
    void update(User bean);

    // 列举
    List<User> list();

    // 分页
    List<User> list(int start, int count);

    // 删除
    void delete(int id);
}
