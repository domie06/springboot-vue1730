package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KeyanchengguoEntity;
import java.util.Map;

/**
 * 科研成果 服务类
 * @since 2021-03-12
 */
public interface KeyanchengguoService extends IService<KeyanchengguoEntity> {

     PageUtils queryPage(Map<String, Object> params);

}