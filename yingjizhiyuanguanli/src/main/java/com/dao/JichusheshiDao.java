package com.dao;

import com.entity.JichusheshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JichusheshiView;

/**
 * 基础设施 Dao 接口
 *
 * @since 2021-03-12
 */
public interface JichusheshiDao extends BaseMapper<JichusheshiEntity> {

   List<JichusheshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
