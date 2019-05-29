package com.zhaocw.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by zhaocaiwen on 2017/6/26.
 */
@Mapper
public interface RiskMapper {
    Integer countModelRisk();
}
