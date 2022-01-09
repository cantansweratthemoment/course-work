package com.DB.course_work;

import com.DB.course_work.DAO.entities.Info_olympic_village;
import com.DB.course_work.DAO.entities.Users;
import com.DB.course_work.DAO.mapper.Info_olympic_villageMapper;
import com.DB.course_work.DAO.mapper.UsersMapper;
import com.DB.course_work.DAO.utils.MybatisUtils;
import org.apache.ibatis.session.*;
import org.junit.Test;

import java.util.List;

public class MybatisTest {

//    @Test
//    public void test() throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("mapper/sqlMapConfig.xml");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<Users> userList = sqlSession.selectList("mapper/UserMapper.findAll");
//        System.out.println(userList);
//        sqlSession.close();
//    }
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
//        Users users = mapper.findUserById(1);
        Info_olympic_villageMapper mapper2 = sqlSession.getMapper(Info_olympic_villageMapper.class);
        Info_olympic_village info_olympic_village = mapper2.findInfo_olympic_villageById(1);
//        for(Users user: users){
        System.out.println(info_olympic_village);
//        }
        sqlSession.close();
    }
}
