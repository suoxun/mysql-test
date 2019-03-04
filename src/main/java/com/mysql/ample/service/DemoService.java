package com.mysql.ample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.ample.mapper.DemoMapper;
import com.mysql.ample.model.Demo;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service
public class DemoService {
	
	@Autowired
	DemoMapper demoMapper;
	
	public void updateForId(int id){
		// where条件
		Example example = null;
		Criteria criteria = null;
		Demo demo = new Demo();
		demo.setFlag("false");
		// 初始化where条件
		example = new Example(Demo.class);
		criteria = example.createCriteria();
		criteria.andEqualTo("id", id);
		demoMapper.updateByExampleSelective(demo, example);
	}
	
	public void updateForIdOther(int idOther){
		// where条件
		Example example = null;
		Criteria criteria = null;
		Demo demo = new Demo();
		demo.setFlag("false");
		// 初始化where条件
		example = new Example(Demo.class);
		criteria = example.createCriteria();
		criteria.andEqualTo("idOther", idOther);
		demoMapper.updateByExampleSelective(demo, example);
	}

}
