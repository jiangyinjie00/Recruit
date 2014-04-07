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
package com.yzu.recruit.common;

import java.io.Serializable;

/**
 * 
 * @author augmentum
 * 
 * @param <T>
 */
public class JsonResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;

    private T response;

    /**
     * auto-generated constructor stub
     */
    public JsonResponse() {
        super();
    }

    /**
     * JsonResponse constructor with status
     * 
     * @param status
     */
    public JsonResponse(int status) {
        super();
        this.status = status;
    }

    /**
     * JsonResponse constructor with status, response
     * 
     * @param status
     * @param response
     */
    public JsonResponse(int status, T response) {
        super();
        this.status = status;
        this.response = response;
    }

    /**
     * get JsonResponse status
     * 
     * @return JsonResponse status
     */
    public int getStatus() {
        return status;
    }

    /**
     * set JsonResponse status
     * 
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * get response for JsonResponse
     * 
     * @return response for JsonResponse
     */
    public T getResponse() {
        return response;
    }

    /**
     * set response for JsonResponse
     * 
     * @param response
     */
    public void setResponse(T response) {
        this.response = response;
    }

}
