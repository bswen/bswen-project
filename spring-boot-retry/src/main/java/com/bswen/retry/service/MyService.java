package com.bswen.retry.service;

import com.bswen.retry.service.common.MyException;

/**
 * Created by xxx on 2017-1-20.
 *
 * @author xxx
 */
public interface MyService {

    boolean mayFailedCall()throws MyException;

    int getMayFailedCallTimes();

}
