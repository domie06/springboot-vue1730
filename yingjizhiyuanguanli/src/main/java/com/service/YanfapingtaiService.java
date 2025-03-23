package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YanfapingtaiEntity;
import java.util.Map;

/**
 * 研发平台 服务类
 * @since 2021-03-12
 */
public interface YanfapingtaiService extends IService<YanfapingtaiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}