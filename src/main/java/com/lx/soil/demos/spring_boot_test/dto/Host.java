package com.lx.soil.demos.spring_boot_test.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : Aslan
 * @version : v1.0
 * @time : 2018-01-22 20:34
 * @desc : 映射配置文件里面的ws_test信息
 */
@ConfigurationProperties(prefix = "ws_test")
@Component
@Data
public class Host {

        private String ip;

        private String port;


}
