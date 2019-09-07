package com.mysql.ample.service;

import com.mysql.ample.mapper.DemoMapper;
import com.mysql.ample.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionTestTwo {

    /**
     * 不同class的spring事务传播机制
     */

    @Autowired
    DemoMapper demoMapper;

    @Autowired
    TransactionTestThree transactionTestThree;

    @Transactional
    public void testOne(){
        Demo demo = new Demo();
        demo.setId(1);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        transactionTestThree.testOne();
    }

    public void testTwo(){
        Demo demo = new Demo();
        demo.setId(3);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        transactionTestThree.testTwo();
    }

}
