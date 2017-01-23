package com.bswen.retry.service;

import com.bswen.retry.service.common.MyException;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.*;

/**
 * Created by xxx on 2017-1-20.
 *
 * @author xxx
 */
//@Configuration
//@EnableRetry
public class SpringTestConfig {
    @Bean
    public MyService myMockService() throws Exception {
        MyService remoteService = mock(MyService.class);
        when(remoteService.mayFailedCall())
                .thenThrow(new MyException("My Exception 1"))
                .thenThrow(new MyException("My Exception 2"))
                .thenReturn(true);
        return remoteService;
    }
}
