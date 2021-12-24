package com.example.service;

import com.example.entity.User;

/**
 * @author SANZONG
 */
public interface UserService {
    /**
     * 根据id返回一个用户
     * @param id userid
     * @return user
     */
    User findUserById(int id);
}
