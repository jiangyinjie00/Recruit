package com.yzu.recruit.common;

/**
 * The <code>Logger</code> is a lightweight wrapper of slf4j logger which
 * provides the capability to format the error message and error code.
 */
public class Logger {

    private static final String EMPTY_ERROR_CODE = "N/A";
    private static final String LOG_MESSAGE_FORMAT = "Error Code:%s | Message:%s";

    private org.slf4j.Logger logger = null;

    /**
     * Initializes the Logger instance.
     *
     * @param logger
     *            org.slf4j.Logger object
     */
    public Logger(org.slf4j.Logger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("internalLogger cannot be null");
        }

        this.logger = logger;
    }

    /**
     * Log a message at the DEBUG level.
     *
     * @param message
     *            the message string to be logged
     */
    public void debug(String message) {
        debug(message, null);
    }

    /**
     * Log a message at the DEBUG level.
     *
     * @param message
     *            the message string to be logged
     * @param errorCode
     *            system error code
     */
    public void debug(String message, int errorCode) {
        debug(message, errorCode, null);
    }

    /**
     * Log a message at the DEBUG level.
     *
     * @param message
     *            the message string to be logged
     * @param throwable
     *            the exception (throwable) to log
     */
    public void debug(String message, Throwable throwable) {

        String formattedMessage = String.format(LOG_MESSAGE_FORMAT,
                EMPTY_ERROR_CODE, message);
        logger.debug(formattedMessage, throwable);
    }

    /**
     * Log a message at the DEBUG level.
     *
     * @param message
     *            the message string to be logged
     * @param errorCode
     *            system error code
     * @param throwable
     *            the exception (throwable) to log
     */
    public void debug(String message, int errorCode, Throwable throwable) {

        String formattedMessage = String.format(LOG_MESSAGE_FORMAT,
                Integer.toHexString(errorCode), message);
        logger.debug(formattedMessage, throwable);
    }

    /**
     * Log a message at the INFO level.
     *
     * @param message
     *            the message string to be logged
     */
    public void info(String message) {
        info(message, null);
    }

    /**
     * Log a message at the INFO level.
     *
     * @param message
     *            the message string to be logged
     * @param errorCode
     *            system error code
     */
    public void info(String message, int errorCode) {
        info(message, errorCode, null);
    }

    /**
     * Log a message at the INFO level.
     *
     * @param message
     *            the message string to be logged
     * @param throwable
     *            the exception (throwable) to log
     */
    public void info(String message, Throwable throwable) {

        String formattedMessage = String.format(LOG_MESSAGE_FORMAT,
                EMPTY_ERROR_CODE, message);
        logger.info(formattedMessage, throwable);
    }

    /**
     * Log a message at the INFO level.
     *
     * @param message
     *            the message string to be logged
     * @param errorCode
     *            system error code
     * @param throwable
     *            the exception (throwable) to log
     */
    public void info(String message, int errorCode, Throwable throwable) {

        String formattedMessage = String.format(LOG_MESSAGE_FORMAT,
                Integer.toHexString(errorCode), message);
        logger.info(formattedMessage, throwable);
    }

    /**
     * Log a message at the WARN level.
     *
     * @param message
     *            the message string to be logged
     */
    public void warn(String message) {
        warn(message, null);
    }

    /**
     * Log a message at the WARN level.
     *
     * @param message
     *            the message string to be logged
     * @param errorCode
     *            system error code
     */
    public void warn(String message, int errorCode) {
        warn(message, errorCode, null);
    }

    /**
     * Log a message at the WARN level.
     *
     * @param message
     *            the message string to be logged
     * @param throwable
     *            the exception (throwable) to log
     */
    public void warn(String message, Throwable throwable) {

        String formattedMessage = String.format(LOG_MESSAGE_FORMAT,
                EMPTY_ERROR_CODE, message);
        logger.warn(formattedMessage, throwable);
    }

    /**
     * Log a message at the WARN level.
     *
     * @param message
     *            the message string to be logged
     * @param errorCode
     *            system error code
     * @param throwable
     *            the exception (throwable) to log
     */
    public void warn(String message, int errorCode, Throwable throwable) {

        String formattedMessage = String.format(LOG_MESSAGE_FORMAT,
                Integer.toHexString(errorCode), message);
        logger.warn(formattedMessage, throwable);
    }

    /**
     * Log a message at the ERROR level.
     *
     * @param message
     *            the message string to be logged
     */
    public void error(String message) {
        error(message, null);
    }

    /**
     * Log a message at the ERROR level.
     *
     * @param message
     *            the message string to be logged
     * @param errorCode
     *            system error code
     */
    public void error(String message, int errorCode) {
        error(message, errorCode, null);
    }

    /**
     * Log a message at the ERROR level.
     *
     * @param message
     *            the message string to be logged
     * @param throwable
     *            the exception (throwable) to log
     */
    public void error(String message, Throwable throwable) {

        String formattedMessage = String.format(LOG_MESSAGE_FORMAT,
                EMPTY_ERROR_CODE, message);
        logger.error(formattedMessage, throwable);
    }

    /**
     * Log a message at the ERROR level.
     *
     * @param message
     *            the message string to be logged
     * @param errorCode
     *            system error code
     * @param throwable
     *            the exception (throwable) to log
     */
    public void error(String message, int errorCode, Throwable throwable) {

        String formattedMessage = String.format(LOG_MESSAGE_FORMAT,
                Integer.toHexString(errorCode), message);
        logger.error(formattedMessage, throwable);
    }
}