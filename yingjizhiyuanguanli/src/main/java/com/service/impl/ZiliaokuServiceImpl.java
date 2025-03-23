package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ZiliaokuDao;
import com.entity.ZiliaokuEntity;
import com.service.ZiliaokuService;
import com.entity.view.ZiliaokuView;

/**
 * 资料库 服务实现类
 * @since 2021-03-12
 */
@Service("ziliaokuService")
@Transactional
public class ZiliaokuServiceImpl extends ServiceImpl<ZiliaokuDao, ZiliaokuEntity> implements ZiliaokuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ZiliaokuView> page =new Query<ZiliaokuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
