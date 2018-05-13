package dal;

import com.yin.dal.ResultMap.UserInfoResultMap;
import com.yin.dal.dao.ClassMapper;
import com.yin.dal.dao.Class;
import com.yin.dal.dao.User;
import com.yin.dal.dao.UserMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class TestUser extends BaseTest{
    private static Logger log = LoggerFactory.getLogger(TestUser.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    ClassMapper classes;

    @Test
    public void select() {
//        SqlSession sqlSession =  sqlSessionTemplate.getSqlSessionFactory().openSession();
//        long start = System.currentTimeMillis();
//        System.out.println(mapper.selectByPrimaryKey(1));
//        sqlSession.selectOne("selectSOne");
//        System.out.println("cost "+ (System.currentTimeMillis() - start));
//        start = System.currentTimeMillis();
//        sqlSession.selectOne("selectSOne");
        System.out.println(userMapper.selectByPrimaryKey(2));
        System.out.println(userMapper.selectByPrimaryKey(2));
//        System.out.println("cost "+ (System.currentTimeMillis() - start));
    }

    @Test
    public void insert() {
        User user = new User();
        user.setId(0);
        user.setAge(11);
        user.setName("bob");
        userMapper.insert(user);
        System.out.println("ID==" + user.getId());
    }

    @Test
    public void testJoinResultMap() {
        User user = new User();
        user.setId(2);
        UserInfoResultMap userInfo = userMapper.selectUserInfoResultByUserId(user);
        System.out.println(userInfo);
        System.out.println(userInfo.getAclass().getClassName());
    }

    @Test
    public void testJoinResultMap2() {
        User user = new User();
        user.setId(3);
        UserInfoResultMap userInfo = userMapper.selectUserInfoResultByUserId2(user);
        System.out.println(userInfo);
        System.out.println(userInfo.getAclass().getClassName());
    }

    @Test
    public void testClasses() {
        Class c = new Class();
        c.setClassId(1);
        System.out.println(classes.selectByPrimaryKey(1).getClassName());
    }
}
