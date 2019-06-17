package com.sunshine.dao;

import com.sunshine.entity.Blogger;
import com.sunshine.entity.BloggerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BloggerMapper {
    long countByExample(BloggerExample example);

    int deleteByExample(BloggerExample example);

    int insert(Blogger record);

    int insertSelective(Blogger record);

    List<Blogger> selectByExample(BloggerExample example);

    int updateByExampleSelective(@Param("record") Blogger record, @Param("example") BloggerExample example);

    int updateByExample(@Param("record") Blogger record, @Param("example") BloggerExample example);
}