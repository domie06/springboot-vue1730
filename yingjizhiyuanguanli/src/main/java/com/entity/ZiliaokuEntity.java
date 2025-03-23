package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 资料库
 *
 * @email
 * @date 2021-03-12
 */
@TableName("ziliaoku")
public class ZiliaokuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public ZiliaokuEntity() {

    }

    public ZiliaokuEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 资料名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 资料图片
     */
    @TableField(value = "img_photo")

    private String imgPhoto;


    /**
     * 资料介绍
     */
    @TableField(value = "jianjie_content")

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
	 * 设置：资料名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：资料名称
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

    @Override
    public String toString() {
    return "Ziliaoku{" +
            "id=" + id +
            ", name=" + name +
            ", imgPhoto=" + imgPhoto +
            ", jianjieContent=" + jianjieContent +
    "}";
    }
    }
