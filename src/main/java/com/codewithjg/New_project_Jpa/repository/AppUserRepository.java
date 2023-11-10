package com.codewithjg.New_project_Jpa.repository;

import com.codewithjg.New_project_Jpa.model.AppUser;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query("SELECT b FROM AppUser b WHERE b.username=:username AND b.password=:password")
    AppUser findUserByUserNameAndPassword(@Param("username") String username,
                                          @Param("password") String password);
}
