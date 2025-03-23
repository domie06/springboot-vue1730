package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.KeyanchengguoDao;
import com.entity.KeyanchengguoEntity;
import com.service.KeyanchengguoService;
import com.entity.view.KeyanchengguoView;

/**
 * 科研成果 服务实现类
 * @since 2021-03-12
 */
@Service("keyanchengguoService")
@Transactional
public class KeyanchengguoServiceImpl extends ServiceImpl<KeyanchengguoDao, KeyanchengguoEntity> implements KeyanchengguoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KeyanchengguoView> page =new Query<KeyanchengguoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
