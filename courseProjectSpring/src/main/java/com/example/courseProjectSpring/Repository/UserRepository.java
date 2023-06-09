package com.example.courseProjectSpring.Repository;

import com.example.courseProjectSpring.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "ALTER TABLE user AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoIncrement();
    User findByLogin(String login);
    User findUserById(Long id);
    /*@Query("update")
    public void updateUser();*/
}
