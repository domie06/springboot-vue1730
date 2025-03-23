package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KejizhuangbeiEntity;
import java.util.Map;

/**
 * 科技装备 服务类
 * @since 2021-03-12
 */
public interface KejizhuangbeiService extends IService<KejizhuangbeiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}