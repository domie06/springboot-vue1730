package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.KejituanduiDao;
import com.entity.KejituanduiEntity;
import com.service.KejituanduiService;
import com.entity.view.KejituanduiView;

/**
 * 科技团队 服务实现类
 * @since 2021-03-12
 */
@Service("kejituanduiService")
@Transactional
public class KejituanduiServiceImpl extends ServiceImpl<KejituanduiDao, KejituanduiEntity> implements KejituanduiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KejituanduiView> page =new Query<KejituanduiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
