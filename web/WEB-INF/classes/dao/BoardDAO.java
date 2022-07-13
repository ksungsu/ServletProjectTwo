package com.sungsu.dao;

import main.java.com.sungsu.dto.BoardDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class BoardDAO {
    private static SqlSessionFactory sqlMapper;

    //SqlSessionFactory static configure
    static{
        String resource = "main/java/com/sungsu/mybatis/SqlMapConfig.xml";
        try{
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("SqlSessionFactory Exception");
        }
    }

    //전체 목록 검색
    public List<BoardDTO> boardSearchAll(){
        SqlSession session = sqlMapper.openSession();
        List<BoardDTO> list = null;
        list = session.selectList("boardSearchAll");
        session.close();
        return list;
    }
}
