package sessionshare.app2;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

public class SessionConfig {
    public String hostName;
    public int port;

    public JedisConnectionFactory connectionFactory(){
        JedisConnectionFactory jedisConnection = new JedisConnectionFactory();
        jedisConnection.setPort(port);
        jedisConnection.setHostName(hostName);
        return jedisConnection;

    }
}
