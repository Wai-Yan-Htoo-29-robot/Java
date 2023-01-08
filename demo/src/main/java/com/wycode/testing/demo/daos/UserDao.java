package com.wycode.testing.demo.daos;

import com.wycode.testing.demo.model.UserReg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserReg,Integer> {
}
