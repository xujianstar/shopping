package sessionshare.app1;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

public class SessionConfig {
    @Value("{redis1.hostname:localhost}")
    public String hostName;
    @Value("{redis1.port:6379}")
    public int port;

    public JedisConnectionFactory connectionFactory(){
        JedisConnectionFactory jedisConnection = new JedisConnectionFactory();
        jedisConnection.setPort(port);
        jedisConnection.setHostName(hostName);
        return jedisConnection;

    }
}
