package com.zhuqielinode.dao;

import com.zhuqielinode.po.Case;

public interface CaseMapper {
    int deleteByPrimaryKey(String cid);

    int insert(Case record);

    int insertSelective(Case record);

    Case selectByPrimaryKey(String cid);

    int updateByPrimaryKeySelective(Case record);

    int updateByPrimaryKey(Case record);
}