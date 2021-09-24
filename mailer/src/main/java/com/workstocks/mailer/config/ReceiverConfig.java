package com.workstocks.mailer.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import com.workstocks.mailer.receivers.Receiver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJms
@Slf4j
public class ReceiverConfig {

  @Autowired
  private WorkstocksProperties properties;

  @Bean
  public ActiveMQConnectionFactory receiverActiveMQConnectionFactory() {
    ActiveMQConnectionFactory activeMQConnectionFactory =
        new ActiveMQConnectionFactory();

    	log.error("URL: ===>" + properties.getBrokerUrl());
    activeMQConnectionFactory.setBrokerURL(properties.getBrokerUrl());

    return activeMQConnectionFactory;
  }

  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory =
        new DefaultJmsListenerContainerFactory();
    factory
        .setConnectionFactory(receiverActiveMQConnectionFactory());

    return factory;
  }

  @Bean
  public Receiver receiver() {
    return new Receiver();
  }
}