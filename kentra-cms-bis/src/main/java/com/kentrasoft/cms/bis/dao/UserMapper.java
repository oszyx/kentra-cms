package com.kentrasoft.cms.bis.dao;
import com.kentrasoft.cms.bis.entity.User;
import org.springframework.stereotype.Component;

@Component(value = "userMapper")
public interface UserMapper {
    /**
     *
     * @mbg.generated 2018-06-11
     */
    User findById(Long id);
}