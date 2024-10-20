package com.Spring.Learn_Spring_Framework.friendCollectionSystem.repository;

import com.Spring.Learn_Spring_Framework.friendCollectionSystem.dto.model.Friends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendsListRepository extends JpaRepository<Friends, Long> {
}
