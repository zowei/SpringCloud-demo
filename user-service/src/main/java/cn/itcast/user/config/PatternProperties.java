package cn.itcast.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
// 从配置文件读取配置
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    @Value("${pattern.dateformat}")
    private String dateformat;
    private String envSharedValue;
    @Value("${pattern.name}")
    private String name;
}
