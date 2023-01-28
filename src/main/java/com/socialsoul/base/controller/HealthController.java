/**
 * 
 */
package com.socialsoul.base.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/health")
public class HealthController {
	
	@RequestMapping
	public String health() throws Exception {
		return "ok";
	}
}