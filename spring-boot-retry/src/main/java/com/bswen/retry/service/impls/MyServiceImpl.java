package com.bswen.retry.service.impls;

import com.bswen.retry.service.MyService;
import com.bswen.retry.service.common.MyException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Created by xxx on 2017-1-20.
 *
 * @author xxx
 */
@Service
public class MyServiceImpl implements MyService {
    private static Log log = LogFactory.getLog(MyServiceImpl.class);
    private int mayFailedCallTimes;

    @Override
    @Retryable(maxAttempts = 3, backoff = @Backoff(delay=2000))
    public boolean mayFailedCall() throws MyException {
        mayFailedCallTimes++;
        log.debug("mayFailedCallTimes = "+mayFailedCallTimes);
        if(mayFailedCallTimes>=3) {
            return true;
        }
        throw new MyException("exception "+mayFailedCallTimes);
    }

    @Override
    public int getMayFailedCallTimes() {
        return mayFailedCallTimes;
    }


}
