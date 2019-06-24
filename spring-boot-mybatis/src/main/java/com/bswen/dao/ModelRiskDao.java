package com.bswen.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zhaocaiwen on 2017/6/26.
 */
@Component
public class ModelRiskDao {
    @Autowired
    private SqlSession sqlSession;

    public int countModelRisk() {
        return this.sqlSession.selectOne("countModelRisk");
    }
}
