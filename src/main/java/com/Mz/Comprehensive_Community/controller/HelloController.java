/**
 * 
 */
package com.Mz.Comprehensive_Community.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 26862
 *
 */
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
}
