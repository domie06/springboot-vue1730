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

import com.entity.KeyanchengguoEntity;

import com.service.KeyanchengguoService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 科研成果
 * 后端接口
 * @author
 * @email
 * @date 2021-03-12
*/
@RestController
@Controller
@RequestMapping("/keyanchengguo")
public class KeyanchengguoController {
    private static final Logger logger = LoggerFactory.getLogger(KeyanchengguoController.class);

    @Autowired
    private KeyanchengguoService keyanchengguoService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = keyanchengguoService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        KeyanchengguoEntity keyanchengguo = keyanchengguoService.selectById(id);
        if(keyanchengguo!=null){
            return R.ok().put("data", keyanchengguo);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody KeyanchengguoEntity keyanchengguo, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<KeyanchengguoEntity> queryWrapper = new EntityWrapper<KeyanchengguoEntity>()
            .eq("name", keyanchengguo.getName())
            .eq("kjtd_types", keyanchengguo.getKjtdTypes())
            .eq("jianjie_content", keyanchengguo.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KeyanchengguoEntity keyanchengguoEntity = keyanchengguoService.selectOne(queryWrapper);
            keyanchengguo.setTeamTime(new Date());
        if(keyanchengguoEntity==null){
            keyanchengguoService.insert(keyanchengguo);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody KeyanchengguoEntity keyanchengguo, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<KeyanchengguoEntity> queryWrapper = new EntityWrapper<KeyanchengguoEntity>()
            .notIn("id",keyanchengguo.getId())
            .eq("name", keyanchengguo.getName())
            .eq("kjtd_types", keyanchengguo.getKjtdTypes())
            .eq("jianjie_content", keyanchengguo.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        KeyanchengguoEntity keyanchengguoEntity = keyanchengguoService.selectOne(queryWrapper);
                keyanchengguo.setTeamTime(new Date());
        if(keyanchengguoEntity==null){
            keyanchengguoService.updateById(keyanchengguo);//根据id更新
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
        keyanchengguoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

