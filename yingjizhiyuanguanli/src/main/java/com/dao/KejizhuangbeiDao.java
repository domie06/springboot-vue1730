package com.dao;

import com.entity.KejizhuangbeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KejizhuangbeiView;

/**
 * 科技装备 Dao 接口
 *
 * @since 2021-03-12
 */
public interface KejizhuangbeiDao extends BaseMapper<KejizhuangbeiEntity> {

   List<KejizhuangbeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
