package com.Spring.Learn_Spring_Framework.friendCollectionSystem.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class ErrorCode implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    private final String code;
    private HttpStatus status;

    public ErrorCode(final String module, final String code) {
        this.code = String.format("ERROR_%s_%s", module, code).toUpperCase();
    }

    public ErrorCode withStatus(final HttpStatus status) {
        this.status = status;
        return this;
    }
}