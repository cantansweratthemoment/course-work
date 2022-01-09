package com.DB.course_work;

import com.DB.course_work.DAO.entities.Users;
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
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = mapper.findUserById(1);
//        for(Users user: users){
            System.out.println(users);
//        }
        sqlSession.close();
    }
}
