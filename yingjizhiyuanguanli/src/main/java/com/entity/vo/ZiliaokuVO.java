package com.entity.vo;

import com.entity.ZiliaokuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资料库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-12
 */
@TableName("ziliaoku")
public class ZiliaokuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 资料名称 Search
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
