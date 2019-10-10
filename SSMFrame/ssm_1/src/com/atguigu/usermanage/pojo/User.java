package com.atguigu.usermanage.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author erdong
 * @create 2019-08-27 19:39
 */
public class User {
    private Long id;

    // 用户名
    @NotNull // 被注释的元素必须不为null
    private String userName;

    // 密码
    @JsonIgnore // 当对象转换为json时，忽略该属性 （保护客户的个人隐私：密码，前端的Network工作空间不显示密码）
    @NotNull
    private String password;

    // 姓名
    @NotNull
    @Length(min = 0, max = 150, message = "您输入的内容长度不合法") // 被注释的字符串必须在指定的范围内
    private String name;

    // 年龄
    @NotNull
    @Range(min = 0, max = 120, message = "您输入的年龄不合法") // 被注释的元素必须在合适的范围内
    private Integer age;

    // 性别，1男性，2女性
    @NotNull
    private Integer sex;

    // 出生日期
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    // 创建时间
    private Date created;

    // 更新时间
    private Date updated;

    public User() {
    }

    public User(Long id, String userName, String password, String name, Integer age, Integer sex, Date birthday, Date created, Date updated) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
