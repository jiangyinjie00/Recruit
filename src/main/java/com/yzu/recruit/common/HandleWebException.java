package com.yzu.recruit.common;

import com.yzu.recruit.exception.ArgumentException;

public class HandleWebException {

    public static <T> JsonResponse<T> handleWebException(Exception exception,
            Logger logger) {

        if (exception instanceof ArgumentException) {
            ArgumentException argumentException = (ArgumentException) exception;

            logger.debug(argumentException.getErrorMessage(), argumentException.getErrorCode(),
                    argumentException);

            return new JsonResponse<T>(argumentException.getErrorCode());
        } else {
            logger.debug(exception.getMessage(), exception);
            return new JsonResponse<T>(Constant.STATUS_PALTFORM_ERROR);
        }
    }
}
