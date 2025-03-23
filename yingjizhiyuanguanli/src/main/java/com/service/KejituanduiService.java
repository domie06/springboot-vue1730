package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KejituanduiEntity;
import java.util.Map;

/**
 * 科技团队 服务类
 * @since 2021-03-12
 */
public interface KejituanduiService extends IService<KejituanduiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}