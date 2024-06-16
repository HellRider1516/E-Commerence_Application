package in.mahesh.Properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "Reports")
@Configuration()
@EnableConfigurationProperties()
public class AppProperties {

}
