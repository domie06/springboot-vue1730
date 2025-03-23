package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JichusheshiEntity;
import java.util.Map;

/**
 * 基础设施 服务类
 * @since 2021-03-12
 */
public interface JichusheshiService extends IService<JichusheshiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}