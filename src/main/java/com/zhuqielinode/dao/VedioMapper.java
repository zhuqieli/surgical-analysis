package com.zhuqielinode.dao;

import com.zhuqielinode.po.Vedio;

public interface VedioMapper {
    int deleteByPrimaryKey(String vid);

    int insert(Vedio record);

    int insertSelective(Vedio record);

    Vedio selectByPrimaryKey(String vid);

    int updateByPrimaryKeySelective(Vedio record);

    int updateByPrimaryKey(Vedio record);
}