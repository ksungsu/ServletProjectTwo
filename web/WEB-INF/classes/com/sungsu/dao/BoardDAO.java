package com.sungsu.dao;

import com.sungsu.dto.BoardDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BoardDAO {
    private static SqlSessionFactory sqlMapper = null;
    static InputStream inputStream = null;
    //SqlSessionFactory static configure
    static{
        String resource = "com/sungsu/mybatis/SqlMapConfig.xml";
        try{
            if(sqlMapper == null) {
                inputStream = Resources.getResourceAsStream(resource);
                sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("SqlSessionFactory Exception");
        }finally {
            if ( inputStream != null )
                try { inputStream.close(); } catch( IOException e ) {}
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
