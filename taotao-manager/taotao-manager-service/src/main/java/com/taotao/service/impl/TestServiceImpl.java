package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.mapper.TestMapper;
import com.taotao.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	//1.注入mapper
	@Autowired
	private TestMapper mapper ;
	
	@RequestMapping("/service/queryNow")
	@ResponseBody
	public String queryNow() {
		return mapper.queryNow();
	}

}
