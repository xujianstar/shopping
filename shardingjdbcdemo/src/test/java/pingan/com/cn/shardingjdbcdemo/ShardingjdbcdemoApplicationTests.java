package pingan.com.cn.shardingjdbcdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pingan.com.cn.shardingjdbcdemo.entity.Course;
import pingan.com.cn.shardingjdbcdemo.entity.Udict;
import pingan.com.cn.shardingjdbcdemo.entity.User;
import pingan.com.cn.shardingjdbcdemo.entity.Usertable;
import pingan.com.cn.shardingjdbcdemo.mapper.CourseMapper;
import pingan.com.cn.shardingjdbcdemo.mapper.UdictMapper;
import pingan.com.cn.shardingjdbcdemo.mapper.UserMapper;
import pingan.com.cn.shardingjdbcdemo.mapper.UsertableMapper;
import pingan.com.cn.shardingjdbcdemo.service.UserMapperService;

import java.util.List;

@SpringBootTest
class ShardingjdbcdemoApplicationTests {

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    UdictMapper udictMapper;

    @Autowired
    UsertableMapper usertableMapper;

    @Autowired
    UserMapperService userMapperService;

// begin======================分库分表之ShardingSphere 支持分布式事务=====================
    @Test
    void TestRollback(){
        userMapperService.insert();
    }
//  end ======================分库分表之ShardingSphere 支持分布式事务=====================

    // begin======================测试读写分离=====================
    @Test
    void addUserForMasterSlave(){
        User user = new User();
        user.setUsername("龍門写");
        user.setUstatus("正常写");
        userMapper.insert(user);
    }
    @Test
    void queryForMasterSlave(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("userid", "123");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println("+++++++++++++++++++++打印+++++++++++++++++");
        System.out.println(user);
    }

    // end======================测试读写分离=======================

    // begin======================测试公共表=====================
    @Test
    void addUdict(){
        Udict udict = new Udict();
        udict.setUstatus("正常");
        udict.setUvalue("1");
        udictMapper.insert(udict);
    }

    @Test
    void updateUdict(){
        QueryWrapper<Udict> updateWrapper = new QueryWrapper<Udict>();
        updateWrapper.eq("dictid", 511667826109448193L);
        Udict udict = new Udict();
        udict.setUstatus("非正常");
        udict.setUvalue("11");
        udictMapper.update(udict,updateWrapper);
    }
    // end======================测试公共表=======================

    // begin======================测试垂直分库=====================
    @Test
    void addUser(){
        User user = new User();
        user.setUsername("龍門");
        user.setUstatus("正常");
        userMapper.insert(user);
    }
    // end======================测试垂直分库=======================



    // begin======================测试水平分库=====================
    @Test
    void addDbCourse(){
        Course course = new Course();
        course.setCname("javademo1");
        course.setUserid(100L);
        course.setCstatus("Normal");
        courseMapper.insert(course);
    }

    // end======================测试水平分库=======================



    // begin======================测试水平分表=====================
    @Test
    void addCourse() {
        for(int i=0; i<10000; i++){
            Course course = new Course();
            course.setCname("java"+i);
            course.setUserid(new Long(i));
            course.setCstatus("Normal"+i);
            courseMapper.insert(course);
        }
    }

    @Test
    void querCourse(){
        QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
        Course course = courseMapper.selectOne(queryWrapper);
        System.out.println(course);

    }

    @Test
    void queryCourseForPage(){
        System.out.println("..........分页查询 begin..... ..........");
        IPage<Course> coursePage = new Page<>(20, 2);//参数一是当前页，参数二是每页个数
        coursePage =courseMapper.selectPage(coursePage,null);
        List<Course> list = coursePage.getRecords();
        for(Course course : list ){
            System.out.println(course.toString());
        }
        System.out.println("..........分页查询 end..... ..........");
    }
    // end======================测试水平分表=======================


    // begin======================默认数据库测试=====================
    @Test
    void insertUserTable(){
        Usertable user = new Usertable();
        user.setName("龍門");
        usertableMapper.insert(user);
    }
    // end  ======================默认数据库测试=====================

}