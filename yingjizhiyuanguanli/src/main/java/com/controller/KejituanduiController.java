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

import com.entity.KejituanduiEntity;

import com.service.KejituanduiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 科技团队
 * 后端接口
 * @author
 * @email
 * @date 2021-03-12
*/
@RestController
@Controller
@RequestMapping("/kejituandui")
public class KejituanduiController {
    private static final Logger logger = LoggerFactory.getLogger(KejituanduiController.class);

    @Autowired
    private KejituanduiService kejituanduiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = kejituanduiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KejituanduiEntity kejituandui = kejituanduiService.selectById(id);
        if(kejituandui!=null){
            return R.ok().put("data", kejituandui);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KejituanduiEntity kejituandui, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<KejituanduiEntity> queryWrapper = new EntityWrapper<KejituanduiEntity>()
            .eq("name", kejituandui.getName())
            .eq("fuzheren", kejituandui.getFuzheren())
            .eq("jianjie_content", kejituandui.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KejituanduiEntity kejituanduiEntity = kejituanduiService.selectOne(queryWrapper);
            kejituandui.setTeamTime(new Date());
        if(kejituanduiEntity==null){
            kejituanduiService.insert(kejituandui);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KejituanduiEntity kejituandui, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<KejituanduiEntity> queryWrapper = new EntityWrapper<KejituanduiEntity>()
            .notIn("id",kejituandui.getId())
            .eq("name", kejituandui.getName())
            .eq("fuzheren", kejituandui.getFuzheren())
            .eq("jianjie_content", kejituandui.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KejituanduiEntity kejituanduiEntity = kejituanduiService.selectOne(queryWrapper);
                kejituandui.setTeamTime(new Date());
        if(kejituanduiEntity==null){
            kejituanduiService.updateById(kejituandui);//根据id更新
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
        kejituanduiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

