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

import com.entity.ZiliaokuEntity;

import com.service.ZiliaokuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 资料库
 * 后端接口
 * @author
 * @email
 * @date 2021-03-12
*/
@RestController
@Controller
@RequestMapping("/ziliaoku")
public class ZiliaokuController {
    private static final Logger logger = LoggerFactory.getLogger(ZiliaokuController.class);

    @Autowired
    private ZiliaokuService ziliaokuService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = ziliaokuService.queryPage(params);
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ZiliaokuEntity ziliaoku = ziliaokuService.selectById(id);
        if(ziliaoku!=null){
            return R.ok().put("data", ziliaoku);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZiliaokuEntity ziliaoku, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ZiliaokuEntity> queryWrapper = new EntityWrapper<ZiliaokuEntity>()
            .eq("name", ziliaoku.getName())
            .eq("jianjie_content", ziliaoku.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZiliaokuEntity ziliaokuEntity = ziliaokuService.selectOne(queryWrapper);
        if("".equals(ziliaoku.getImgPhoto()) || "null".equals(ziliaoku.getImgPhoto())){
            ziliaoku.setImgPhoto(null);
        }
        if(ziliaokuEntity==null){
            ziliaokuService.insert(ziliaoku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZiliaokuEntity ziliaoku, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<ZiliaokuEntity> queryWrapper = new EntityWrapper<ZiliaokuEntity>()
            .notIn("id",ziliaoku.getId())
            .eq("name", ziliaoku.getName())
            .eq("jianjie_content", ziliaoku.getJianjieContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZiliaokuEntity ziliaokuEntity = ziliaokuService.selectOne(queryWrapper);
        if("".equals(ziliaoku.getImgPhoto()) || "null".equals(ziliaoku.getImgPhoto())){
                ziliaoku.setImgPhoto(null);
        }
        if(ziliaokuEntity==null){
            ziliaokuService.updateById(ziliaoku);//根据id更新
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
        ziliaokuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

