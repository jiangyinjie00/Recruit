/*
* ----------------------------------------------------------------
*   Augmentum Fleet Management System License, version 1.0
*   Copyright (c) 2003 - 2014 Augmentum Inc. All rights reserved.
* ----------------------------------------------------------------
*
* This software contains confidential information, trade secrets, and copyrighted
* expressions that are the property of Augmentum, Inc., 1065 E. Hillsdale Blvd.
* Suite #400, Foster City, CA, USA, 94404. Any disclosure, reproduction, sale or
* license of all or any part of the information or expression contained in this
* software is prohibited by California law and the United States copyright law,
* and may be subject to criminal penalties. If you are not an employee of Augmentum, Inc.
* or otherwise authorized in writing by Augmentum, Inc. to possess this software,
* please contact Augmentum, Inc. immediately at the address or phone number
* listed above.
*/
package com.yzu.recruit.util;

import org.springframework.security.crypto.bcrypt.BCrypt;


public class EncryptionUtil {

    /**
     * Uses BCRYPT algorithm to encrypt text.
     *
     * @param plainText
     * @return {@code String hashed password}
     */
    public static String encrypt(String plainText){
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(plainText, salt);
    }

    /**
     * Checked if the hashed text is encrypted from plain text.
     *
     * @param plainText
     * @param hashedText
     * @return {@code true}
     */
    public static boolean checkText(String plainText, String hashedText){
        return BCrypt.checkpw(plainText, hashedText);
    }

}
