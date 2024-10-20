package com.Spring.Learn_Spring_Framework.friendCollectionSystem.controller;

import com.Spring.Learn_Spring_Framework.friendCollectionSystem.dto.model.Friends;
import com.Spring.Learn_Spring_Framework.friendCollectionSystem.dto.request.CreateOrUpdateFriendRequest;
import com.Spring.Learn_Spring_Framework.friendCollectionSystem.service.FriendsListService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/friends/v1")
public class FriendCollectionController {
    @Autowired
    private FriendsListService friendsListService;

    @PostMapping("/friend")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addNewFriendToList(
            @RequestBody @Valid CreateOrUpdateFriendRequest createFriendRequest) {
        friendsListService.addNewFriend(createFriendRequest);
    }

    @GetMapping("/list")
    public List<Friends> getFriendsList() {
        return friendsListService.getFriendsList();
    }

    @GetMapping("/friend/{friendId}")
    public Friends getFriendDetails(@PathVariable("friendId") @NotNull final Long friendId) {
        return friendsListService.getDetailsOfAFriend(friendId);
    }

    @PutMapping("/friend/{friendId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateFriendDetails(
            @PathVariable("friendId") @NotNull final Long friendId,
            @RequestBody @Valid CreateOrUpdateFriendRequest editFriendRequest) {
        friendsListService.updateFriendDetail(friendId, editFriendRequest);
    }

    @DeleteMapping("/friend/{friendId}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteFriendRecord(
            @PathVariable("friendId") @NotNull final Long friendId) {
        friendsListService.deleteFriend(friendId);
    }
}
