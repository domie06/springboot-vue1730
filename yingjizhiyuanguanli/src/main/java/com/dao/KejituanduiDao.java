package com.dao;

import com.entity.KejituanduiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KejituanduiView;

/**
 * 科技团队 Dao 接口
 *
 * @since 2021-03-12
 */
public interface KejituanduiDao extends BaseMapper<KejituanduiEntity> {

   List<KejituanduiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
