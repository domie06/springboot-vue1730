package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.KejizhuangbeiEntity;

import com.service.KejizhuangbeiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 科技装备
 * 后端接口
 * @author
 * @email
 * @date 2021-03-12
*/
@RestController
@Controller
@RequestMapping("/kejizhuangbei")
public class KejizhuangbeiController {
    private static final Logger logger = LoggerFactory.getLogger(KejizhuangbeiController.class);

    @Autowired
    private KejizhuangbeiService kejizhuangbeiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = kejizhuangbeiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KejizhuangbeiEntity kejizhuangbei = kejizhuangbeiService.selectById(id);
        if(kejizhuangbei!=null){
            return R.ok().put("data", kejizhuangbei);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KejizhuangbeiEntity kejizhuangbei, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<KejizhuangbeiEntity> queryWrapper = new EntityWrapper<KejizhuangbeiEntity>()
            .eq("name", kejizhuangbei.getName())
            .eq("jianjie_content", kejizhuangbei.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KejizhuangbeiEntity kejizhuangbeiEntity = kejizhuangbeiService.selectOne(queryWrapper);
        if("".equals(kejizhuangbei.getImgPhoto()) || "null".equals(kejizhuangbei.getImgPhoto())){
            kejizhuangbei.setImgPhoto(null);
        }
        if(kejizhuangbeiEntity==null){
            kejizhuangbeiService.insert(kejizhuangbei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KejizhuangbeiEntity kejizhuangbei, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<KejizhuangbeiEntity> queryWrapper = new EntityWrapper<KejizhuangbeiEntity>()
            .notIn("id",kejizhuangbei.getId())
            .eq("name", kejizhuangbei.getName())
            .eq("jianjie_content", kejizhuangbei.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KejizhuangbeiEntity kejizhuangbeiEntity = kejizhuangbeiService.selectOne(queryWrapper);
        if("".equals(kejizhuangbei.getImgPhoto()) || "null".equals(kejizhuangbei.getImgPhoto())){
                kejizhuangbei.setImgPhoto(null);
        }
        if(kejizhuangbeiEntity==null){
            kejizhuangbeiService.updateById(kejizhuangbei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        kejizhuangbeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

