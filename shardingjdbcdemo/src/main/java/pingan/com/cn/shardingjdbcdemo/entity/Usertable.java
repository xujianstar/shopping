package pingan.com.cn.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("usertable")
public class Usertable {
    private long id;
    private String name;

    @Override
    public String toString() {
        return "usertable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
