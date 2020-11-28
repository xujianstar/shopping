package pingan.com.cn.shardingjdbcdemo.service;


import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pingan.com.cn.shardingjdbcdemo.entity.Course;
import pingan.com.cn.shardingjdbcdemo.mapper.CourseMapper;


/**
 * 测试分表分库回滚方案
 */
@Service
public class UserMapperService {
    @Autowired
    CourseMapper courseMapper;

    @ShardingTransactionType(TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    public void insert(){
        System.out.println("回滚事务准备");
        for(int i=0; i<100; i++){
            Course course = new Course();
            course.setCname("java"+i);
            course.setUserid(new Long(i));
            course.setCstatus("Normal"+i);
            courseMapper.insert(course);
        }
        System.out.println("回滚事务开始");
        System.out.println(100 / 0);//测试回滚，统一提交的话，将这行注释掉就行了

    }

}
