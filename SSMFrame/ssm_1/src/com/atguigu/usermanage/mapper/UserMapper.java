package com.atguigu.usermanage.mapper;

import com.atguigu.usermanage.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author erdong
 * @create 2019-08-27 20:01
 */
public interface UserMapper {
    /**
     * 批量删除用户
     *
     * @param ids
     * @return
     */
    public int deleteUserByIds(@Param("ids") String[] ids);

    /**
     * 新增两个用户，要成功都成功，要失败都失败
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    public int saveUser(User user);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    public int deleteUserById(Long id);

    /**
     * 根据用户id 修改用户信息 (编辑用户)
     *
     * @param user
     * @return
     */
    public int updateUserById(User user);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    public User queryUserById(Long id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> queryAllUserInfo();

    /**
     * 查询所有用户返回值为Map<String,Object>结构
     *
     * @return
     */
    public List<User> queryAllUserResultListUser();

    /**
     * 查询总条数
     *
     * @return
     */
    public Long queryTotal();
}
