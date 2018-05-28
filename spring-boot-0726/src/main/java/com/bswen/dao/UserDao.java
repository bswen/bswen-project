package com.bswen.dao;

import com.bswen.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * user corresponsd to tbl_spboot_users
 * Date: 15-7-27
 * Time: 下午5:00
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserDao {
    private static Log log = LogFactory.getLog(UserDao.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> queryUsers() throws Exception {//查询所有User信息返回对象列表.
        List<Map<String, Object>> tempList =
                jdbcTemplate.queryForList("select id,name,pub_date from tbl_spboot_users");//得到所有行
        List<User> result = new ArrayList<User>();
        if(tempList!=null&&tempList.size()>0) {
            for(Map<String,Object> row:tempList) {
                User temp = parseRow(row);//逐个解析每一行数据，转为对象
                if(temp!=null) {
                    result.add(temp);//保存对象.
                }
            }
        }
        return result;
    }

    private User parseRow(Map<String, Object> row) {//将数据库的一行数据转为User对象
        if(row==null||row.size()==0) return null;
        User u = new User();
        u.setId((Integer)row.get("id"));
        u.setName((String)row.get("name"));
        u.setPubDate((Date)row.get("pub_date"));
        return u;
    }
}
