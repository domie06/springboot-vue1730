package com.dao;

import com.entity.YanfapingtaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YanfapingtaiView;

/**
 * 研发平台 Dao 接口
 *
 * @since 2021-03-12
 */
public interface YanfapingtaiDao extends BaseMapper<YanfapingtaiEntity> {

   List<YanfapingtaiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
