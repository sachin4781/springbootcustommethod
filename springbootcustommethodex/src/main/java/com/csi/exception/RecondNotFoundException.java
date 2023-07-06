package com.csi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecondNotFoundException extends RuntimeException {

    public RecondNotFoundException(String msg) {
        super(msg);
    }

}
