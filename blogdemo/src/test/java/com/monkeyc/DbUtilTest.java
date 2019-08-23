package com.monkeyc;

import com.monkeyc.blog.util.DbUtil;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DbUtilTest {
    @Test
    public void testConnection(){
        Connection connection = DbUtil.getConnection();
//        System.out.println(connection);
        Assert.assertNotNull(connection);
    }
}
