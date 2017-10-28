package org.hospital.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pismery on 2017-10-13.
 */
public class HibernateUtil {
    static Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    public static void main(String[] args) {
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message {}","aaa");
        System.out.println("Hello World!");
    }
}
