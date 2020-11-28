package pingan.com.cn.shardingjdbcdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import pingan.com.cn.shardingjdbcdemo.entity.User;

@Repository
public interface UserMapper extends BaseMapper<User> {

}
