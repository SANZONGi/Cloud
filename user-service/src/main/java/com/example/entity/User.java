package com.example.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author SANZONG
 */
@Data
@Table(name = "user")
public class User{
    /**
     * 开启主键自动回填
     */
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String userName;

    private String password;

    private String name;

    private Integer age;

    /**
     * 性别，1男性，2女性
     */
    private Integer sex;

    /**出生日期
     *
     */
    private Date birthday;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
      */
    private Date updated;

    /**
     * 备注
      */
    private String note;
}