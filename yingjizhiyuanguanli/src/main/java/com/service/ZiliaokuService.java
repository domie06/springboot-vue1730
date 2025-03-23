package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZiliaokuEntity;
import java.util.Map;

/**
 * 资料库 服务类
 * @since 2021-03-12
 */
public interface ZiliaokuService extends IService<ZiliaokuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}