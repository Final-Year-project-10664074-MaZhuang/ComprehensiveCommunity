/**
 * 
 */
package com.Mz.Comprehensive_Community.controller;

import com.Mz.Comprehensive_Community.domain.es.EsBlog;
import com.Mz.Comprehensive_Community.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 26862
 *
 */
@RestController
public class HelloController {
	@Autowired
	private EsBlogRepository esBlogRepository;
	@RequestMapping("/hello")
	public String hello() {
		return "HelloWorld";
	}
	@RequestMapping("/init")
	public void initRepositoryData(){
		esBlogRepository.deleteAll();
		esBlogRepository.save(new EsBlog("登鹳雀楼","王之涣的登鹳雀楼",
				"白日依山尽，黄河入海流。欲穷千里目，更上一层楼。"));
		esBlogRepository.save(new EsBlog("相思","王维的相思",
				"红豆生南国，春来发几枝。愿君多采撷，此物最相思。"));
		esBlogRepository.save(new EsBlog("静夜思","李白的静夜思",
				"床前明月光，疑是地上霜。举头望明月，低头思故乡"));
	}
}
