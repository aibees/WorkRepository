package com.finance.util.database;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class ConnClient {
    private static SqlSession session;

    static {
        try {
            String resource = "MyBatis.xml";
            Reader resource_reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(resource_reader);

            session = sqlMapper.openSession();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession() {
        return session;
    }
}
