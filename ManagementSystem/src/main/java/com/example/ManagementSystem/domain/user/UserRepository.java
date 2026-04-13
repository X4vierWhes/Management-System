package com.example.ManagementSystem.domain.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndIsActive(String username, Boolean isActive);

    @Query("select u from User u where u.isActive = true and (u.username = :username or u.email = :email)")
    List<User> findByUsernameOrEmailAndIsActive(String username, String email);

    @Modifying
    @Transactional
    @Query("update User u set u.isActive = false where u.username = :username")
    int shadowDelete(String username);

    @Query("select u from User u where u.username ilike :prefix and u.isActive = true")
    List<User> findByUsernamePrefix(String prefix);


}
