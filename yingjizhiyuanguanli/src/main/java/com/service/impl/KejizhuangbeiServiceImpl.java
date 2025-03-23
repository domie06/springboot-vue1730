package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.KejizhuangbeiDao;
import com.entity.KejizhuangbeiEntity;
import com.service.KejizhuangbeiService;
import com.entity.view.KejizhuangbeiView;

/**
 * 科技装备 服务实现类
 * @since 2021-03-12
 */
@Service("kejizhuangbeiService")
@Transactional
public class KejizhuangbeiServiceImpl extends ServiceImpl<KejizhuangbeiDao, KejizhuangbeiEntity> implements KejizhuangbeiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KejizhuangbeiView> page =new Query<KejizhuangbeiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
