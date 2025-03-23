package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.JichusheshiDao;
import com.entity.JichusheshiEntity;
import com.service.JichusheshiService;
import com.entity.view.JichusheshiView;

/**
 * 基础设施 服务实现类
 * @since 2021-03-12
 */
@Service("jichusheshiService")
@Transactional
public class JichusheshiServiceImpl extends ServiceImpl<JichusheshiDao, JichusheshiEntity> implements JichusheshiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JichusheshiView> page =new Query<JichusheshiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
