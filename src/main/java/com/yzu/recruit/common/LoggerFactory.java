package com.yzu.recruit.common;

/**
 * The <code>LoggerFactory</code> is a utility class producing Loggers.
 */
public final class LoggerFactory {

    private LoggerFactory() {

    }

    /**
     * Return a logger named according to the name parameter.
     *
     * @param name
     *            The name of the logger.
     * @return logger
     */
    public static Logger getLogger(String name) {

        org.slf4j.Logger logger = org.slf4j.LoggerFactory
                .getLogger(name);

        return new Logger(logger);
    }

    /**
     * Return a logger named corresponding to the class passed as parameter.
     *
     * @param clazz
     *            the returned logger will be named after clazz
     * @return logger
     */
    @SuppressWarnings("rawtypes")
    public static Logger getLogger(Class clazz) {

        org.slf4j.Logger logger = org.slf4j.LoggerFactory
                .getLogger(clazz);

        return new Logger(logger);
    }
}