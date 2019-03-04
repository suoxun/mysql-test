package com.mysql.ample.config;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 备注：持久化基类
 * *
 * 包路径：com.zhiscity.biz.dao.config
 * 项目名称：platform-portal.
 * 创建人：SuoXun
 * 创建时间：2018-01-15
 * 修改人：SuoXun
 * 修改时间：2018-01-16
 * 版本：1.0-SNAPSHOT
 * *
 * ***************this code is only for sharing***************
 */
public interface CommonMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T> {
	//TODO
	//FIXME 特别注意，该接口不能被扫描到，否则会出错
}
