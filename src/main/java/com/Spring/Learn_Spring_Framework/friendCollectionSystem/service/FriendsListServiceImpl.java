package com.Spring.Learn_Spring_Framework.friendCollectionSystem.service;

import com.Spring.Learn_Spring_Framework.friendCollectionSystem.constants.FriendsListErrorCodes;
import com.Spring.Learn_Spring_Framework.friendCollectionSystem.dto.model.Friends;
import com.Spring.Learn_Spring_Framework.friendCollectionSystem.dto.request.CreateOrUpdateFriendRequest;
import com.Spring.Learn_Spring_Framework.friendCollectionSystem.exceptions.FriendListException;
import com.Spring.Learn_Spring_Framework.friendCollectionSystem.repository.FriendsListRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

import static com.Spring.Learn_Spring_Framework.friendCollectionSystem.constants.FriendsListConstants.EMAIL_REGEX;

@Service
@AllArgsConstructor
@Transactional
public class FriendsListServiceImpl implements FriendsListService {
    private final FriendsListRepository friendsListRepository;

    @Override
    public void addNewFriend(CreateOrUpdateFriendRequest createFriendRequest) {
        // validate the fields provided in the request
        validateRequest(createFriendRequest);
        // Adding new record to the list
        Friends friend = Friends.builder()
                .name(createFriendRequest.getName())
                .age(createFriendRequest.getAge())
                .email(createFriendRequest.getEmail())
                .city(createFriendRequest.getCity())
                .country(createFriendRequest.getCountry())
                .build();
        friendsListRepository.saveAndFlush(friend);
    }

    @Override
    public List<Friends> getFriendsList() {
        return friendsListRepository.findAll();
    }

    @Override
    public Friends getDetailsOfAFriend(Long friendId) {
        // check if record exists with the provided id and then return
        return friendsListRepository.findById(friendId).orElseThrow(() ->
                new FriendListException(FriendsListErrorCodes.OBJECT_NOT_FOUND, "Invalid ID")
        );
    }

    @Override
    public void updateFriendDetail(Long friendId, CreateOrUpdateFriendRequest editFriendRequest) {
        // validate the fields provided in the request
        validateRequest(editFriendRequest);
        // check if valid ID is provided
        Friends friend = friendsListRepository.findById(friendId).orElseThrow(() ->
                new FriendListException(FriendsListErrorCodes.OBJECT_NOT_FOUND, "Invalid ID")
        );
        // update the data
        friend.setName(editFriendRequest.getName());
        friend.setAge(editFriendRequest.getAge());
        friend.setEmail(editFriendRequest.getEmail());
        friend.setCity(editFriendRequest.getCity());
        friend.setCountry(editFriendRequest.getCountry());
        // save updated record
        friendsListRepository.saveAndFlush(friend);
    }

    @Override
    public void deleteFriend(Long friendId) {
        // check if valid ID is provided
        Friends friend = friendsListRepository.findById(friendId).orElseThrow(() ->
                new FriendListException(FriendsListErrorCodes.OBJECT_NOT_FOUND, "Invalid ID")
        );
        // delete record
        friendsListRepository.delete(friend);
    }

    private void validateRequest(final CreateOrUpdateFriendRequest request) {
        if (Objects.isNull(request.getName())) {
            throw new FriendListException(FriendsListErrorCodes.INVALID_REQUEST, "Name cannot be null");
        }
        if (StringUtils.isBlank(request.getName())) {
            throw new FriendListException(FriendsListErrorCodes.INVALID_REQUEST, "Name cannot be empty");
        }
        if (request.getAge() == 0) {
            throw new FriendListException(FriendsListErrorCodes.INVALID_REQUEST, "Age cannot be null");
        }
        if (Objects.isNull(request.getEmail())) {
            throw new FriendListException(FriendsListErrorCodes.INVALID_REQUEST, "Email is required");
        }
        if (!isValidEmail(request.getEmail())) {
            throw new FriendListException(FriendsListErrorCodes.INVALID_REQUEST, "Invalid email format");
        }
        if (request.getName().length() > 125) {
            throw new FriendListException(FriendsListErrorCodes.INVALID_REQUEST, "Name is too long");
        }
    }

    private boolean isValidEmail(String emailId) {
        final EmailValidator emailValidator = new EmailValidator();
        if (ObjectUtils.isEmpty(emailId)) {
            return false;
        }
        return emailId.matches(EMAIL_REGEX) && emailValidator.isValid(emailId, null);
    }
}
