package com.yzu.recruit.exception;

public class ArgumentException extends BaseException{

    private static final long serialVersionUID = -8084371177032518047L;

    public ArgumentException(String errorMessage, int errorCode) {
        super(errorMessage, errorCode);
    }

    public ArgumentException(String errorMessage, int errorCode, Throwable cause) {
        super(errorMessage, errorCode, cause);
    }

}
