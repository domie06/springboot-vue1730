package com.entity.model;

import com.entity.ZiliaokuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 资料库
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-12
 */
public class ZiliaokuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 资料名称 Search
     */
    private String name;


    /**
     * 资料图片
     */
    private String imgPhoto;


    /**
     * 资料介绍
     */
    private String jianjieContent;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：资料名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：资料名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：资料图片
	 */
    public String getImgPhoto() {
        return imgPhoto;
    }


    /**
	 * 获取：资料图片
	 */

    public void setImgPhoto(String imgPhoto) {
        this.imgPhoto = imgPhoto;
    }
    /**
	 * 设置：资料介绍
	 */
    public String getJianjieContent() {
        return jianjieContent;
    }


    /**
	 * 获取：资料介绍
	 */

    public void setJianjieContent(String jianjieContent) {
        this.jianjieContent = jianjieContent;
    }

    }
