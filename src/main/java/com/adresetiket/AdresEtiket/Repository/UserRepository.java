package com.adresetiket.AdresEtiket.Repository;

import com.adresetiket.AdresEtiket.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM tbl_user WHERE user_name = ?1  limit 1 " ,nativeQuery = true)
    User getLoginUserName(String userName);

}