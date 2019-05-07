package trade.axht.springboot.demo.log;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import redis.clients.jedis.Jedis;

/**
 * 描述:
 * 使用Redis做日志缓存
 *
 * @outhor Administrator
 * @create 2017-12-24 20:45
 */
public class RedisAppender extends AppenderSkeleton{

    private Logger logger=Logger.getLogger(getClass());
    private Jedis jedis;

    private String connectionUrl="localhost";
    private int port=6379;

    public RedisAppender(){
        logger.info("RedisAppender加载了...");
        if(jedis==null){
            jedis=new Jedis(connectionUrl,port);
            logger.info("Redis数据库连接成功O(∩_∩)O");
        }
    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        Object object=loggingEvent.getMessage();
        jedis.set("logInfo"+loggingEvent.getThreadName(),(String) loggingEvent.getMessage());
    }

    @Override
    public void close() {
        if (jedis!=null){
            jedis.close();
        }
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Jedis getJedis() {
        return jedis;
    }

    public void setJedis(Jedis jedis) {
        this.jedis = jedis;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
