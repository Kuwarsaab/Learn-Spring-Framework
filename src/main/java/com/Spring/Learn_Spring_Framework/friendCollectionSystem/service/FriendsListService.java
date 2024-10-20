package com.Spring.Learn_Spring_Framework.friendCollectionSystem.service;

import com.Spring.Learn_Spring_Framework.friendCollectionSystem.dto.model.Friends;
import com.Spring.Learn_Spring_Framework.friendCollectionSystem.dto.request.CreateOrUpdateFriendRequest;

import java.util.List;

public interface FriendsListService {

    void addNewFriend(CreateOrUpdateFriendRequest createFriendRequest);

    List<Friends> getFriendsList();

    Friends getDetailsOfAFriend(Long friendId);

    void updateFriendDetail(Long friendId, CreateOrUpdateFriendRequest editFriendRequest);

    void deleteFriend(Long friendId);
}
