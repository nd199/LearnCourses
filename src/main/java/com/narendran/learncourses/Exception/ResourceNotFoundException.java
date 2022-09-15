package com.narendran.learncourses.Exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    /* This is for Exceptions */

    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
}
