package com.mysql.ample.service;

import com.mysql.ample.mapper.DemoMapper;
import com.mysql.ample.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionTestOne {

    /**
     * 同一个class的spring事务传播机制
     */

    @Autowired
    DemoMapper demoMapper;

    /**
     * 事务都回滚
     */
    /******************************************************************/
    @Transactional
    public void testOne(){
        Demo demo = new Demo();
        demo.setId(1);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        testTwo();
    }

    public void testTwo(){
        Demo demo = new Demo();
        demo.setId(2);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        throw new RuntimeException();
    }
    /******************************************************************/



    /**
     * 事务都不回滚
     */
    /******************************************************************/
    // 结果两个都失败
    public void testThree(){
        Demo demo = new Demo();
        demo.setId(3);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        testFour();
    }

    @Transactional
    public void testFour(){
        Demo demo = new Demo();
        demo.setId(4);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        throw new RuntimeException();
    }
    /******************************************************************/



    /**
     * 事务都回滚
     */
    /******************************************************************/
    @Transactional
    public void testFive(){
        Demo demo = new Demo();
        demo.setId(5);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        testSix();
    }

    @Transactional
    public void testSix(){
        Demo demo = new Demo();
        demo.setId(6);
        demo.setFlag("true");
        demoMapper.updateByPrimaryKeySelective(demo);
        throw new RuntimeException();
    }
    /******************************************************************/

}
