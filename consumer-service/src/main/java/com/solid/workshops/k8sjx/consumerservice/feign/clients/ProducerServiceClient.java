package com.solid.workshops.k8sjx.consumerservice.feign.clients;

import com.solid.workshops.k8sjx.consumerservice.feign.dtos.InfoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("producer")
public interface ProducerServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/greetings")
	String greet();

	@RequestMapping(method = RequestMethod.GET, value = "/info")
	InfoDto getInfo();

}
