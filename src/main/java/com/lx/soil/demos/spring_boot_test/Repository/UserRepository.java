package com.lx.soil.demos.spring_boot_test.Repository;

import com.lx.soil.demos.spring_boot_test.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-29 22:03
 * @desc : 输入描述
 */
public interface UserRepository extends JpaRepository<User,Integer>{

}
