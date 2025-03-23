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

import com.entity.YanfapingtaiEntity;

import com.service.YanfapingtaiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 研发平台
 * 后端接口
 * @author
 * @email
 * @date 2021-03-12
*/
@RestController
@Controller
@RequestMapping("/yanfapingtai")
public class YanfapingtaiController {
    private static final Logger logger = LoggerFactory.getLogger(YanfapingtaiController.class);

    @Autowired
    private YanfapingtaiService yanfapingtaiService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = yanfapingtaiService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        YanfapingtaiEntity yanfapingtai = yanfapingtaiService.selectById(id);
        if(yanfapingtai!=null){
            return R.ok().put("data", yanfapingtai);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YanfapingtaiEntity yanfapingtai, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<YanfapingtaiEntity> queryWrapper = new EntityWrapper<YanfapingtaiEntity>()
            .eq("name", yanfapingtai.getName())
            .eq("yanfaxiangm", yanfapingtai.getYanfaxiangm())
            .eq("jianjie_content", yanfapingtai.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YanfapingtaiEntity yanfapingtaiEntity = yanfapingtaiService.selectOne(queryWrapper);
        if(yanfapingtaiEntity==null){
            yanfapingtaiService.insert(yanfapingtai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YanfapingtaiEntity yanfapingtai, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<YanfapingtaiEntity> queryWrapper = new EntityWrapper<YanfapingtaiEntity>()
            .notIn("id",yanfapingtai.getId())
            .eq("name", yanfapingtai.getName())
            .eq("yanfaxiangm", yanfapingtai.getYanfaxiangm())
            .eq("jianjie_content", yanfapingtai.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YanfapingtaiEntity yanfapingtaiEntity = yanfapingtaiService.selectOne(queryWrapper);
        if(yanfapingtaiEntity==null){
            yanfapingtaiService.updateById(yanfapingtai);//根据id更新
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
        yanfapingtaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

