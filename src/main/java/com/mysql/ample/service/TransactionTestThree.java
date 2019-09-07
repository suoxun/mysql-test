package com.mysql.ample.service;

import com.mysql.ample.mapper.DemoMapper;
import com.mysql.ample.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionTestThree {

    /**
     * 不同class的spring事务传播机制
     */

    @Autowired
    DemoMapper demoMapper;

    public void testOne(){
        Demo demo = new Demo();
        demo.setId(2);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        throw new RuntimeException();
    }

    @Transactional
    public void testTwo(){
        Demo demo = new Demo();
        demo.setId(4);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        throw new RuntimeException();
    }

}
