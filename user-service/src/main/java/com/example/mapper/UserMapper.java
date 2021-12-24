package com.example.mapper;

import com.example.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author SANZONG
 */
@Repository
public interface UserMapper extends Mapper<User> {

}
