package com.Spring.Learn_Spring_Framework.friendCollectionSystem.constants;

import com.Spring.Learn_Spring_Framework.friendCollectionSystem.exceptions.ErrorCode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FriendsListErrorCodes {
    private static final String MODULE = "FRIENDS_LIST_APPLICATION";

    public static final ErrorCode OBJECT_NOT_FOUND =
            new ErrorCode(MODULE, "OBJECT_NOT_FOUND").withStatus(HttpStatus.NOT_FOUND);

    public static final ErrorCode INVALID_REQUEST =
            new ErrorCode(MODULE, "INVALID_REQUEST").withStatus(HttpStatus.BAD_REQUEST);
}
