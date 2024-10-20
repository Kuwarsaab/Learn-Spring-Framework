package com.Spring.Learn_Spring_Framework.friendCollectionSystem.exceptions;

import java.time.Instant;

public record ExceptionResponse(Instant date, String message, String details) {
}
