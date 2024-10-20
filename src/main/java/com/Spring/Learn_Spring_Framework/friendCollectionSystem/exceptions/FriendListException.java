package com.Spring.Learn_Spring_Framework.friendCollectionSystem.exceptions;

import org.apache.commons.lang3.StringUtils;

public class FriendListException extends RuntimeException {
    private final ErrorCode errorCode;

    public FriendListException(final ErrorCode errorCode, final String defaultMessage) {
        super(defaultMessage);
        this.errorCode = errorCode;
    }

    public String getDefaultMessage() {
        return StringUtils.defaultIfBlank(this.getMessage(), "Operation Failed");
    }

    private static String getMessage(final Throwable cause) {
        return cause == null ? "Operation Failed" : StringUtils.defaultIfBlank(cause.getMessage(), "Operation Failed");
    }
}
