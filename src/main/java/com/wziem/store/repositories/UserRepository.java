package com.wziem.store.repositories;

import com.wziem.store.dtos.UserSummary;
import com.wziem.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> { //<Type, IdType>
    @EntityGraph(attributePaths = {"tags", "addresses"})
    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = {"addresses"})
    @Query("select u from User u")
    List<User> findAllWithTags();

    @Query("select u.id as id, u.email as email from User u where u.profile.LoyaltyPoints > :loyaltyPointsIsGreaterThan order by u.email")
    List<UserSummary> findLoyalUsers(@Param("loyaltyPointsIsGreaterThan") Integer loyaltyPointsIsGreaterThan);
}
