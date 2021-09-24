package com.workstocks.mailer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "workstocks-mailer")
public class WorkstocksProperties {
	
	private String brokerUrl;

}
