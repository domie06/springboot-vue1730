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
 * 科技团队
 *
 * @email
 * @date 2021-03-12
 */
@TableName("kejituandui")
public class KejituanduiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public KejituanduiEntity() {

    }

    public KejituanduiEntity(T t) {
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
     * 团队名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 团队负责人
     */
    @TableField(value = "fuzheren")

    private String fuzheren;


    /**
     * 团队创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "team_time",fill = FieldFill.UPDATE)

    private Date teamTime;


    /**
     * 团队简介
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
	 * 设置：团队名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：团队名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：团队负责人
	 */
    public String getFuzheren() {
        return fuzheren;
    }


    /**
	 * 获取：团队负责人
	 */

    public void setFuzheren(String fuzheren) {
        this.fuzheren = fuzheren;
    }
    /**
	 * 设置：团队创建时间
	 */
    public Date getTeamTime() {
        return teamTime;
    }


    /**
	 * 获取：团队创建时间
	 */

    public void setTeamTime(Date teamTime) {
        this.teamTime = teamTime;
    }
    /**
	 * 设置：团队简介
	 */
    public String getJianjieContent() {
        return jianjieContent;
    }


    /**
	 * 获取：团队简介
	 */

    public void setJianjieContent(String jianjieContent) {
        this.jianjieContent = jianjieContent;
    }

    @Override
    public String toString() {
    return "Kejituandui{" +
            "id=" + id +
            ", name=" + name +
            ", fuzheren=" + fuzheren +
            ", teamTime=" + teamTime +
            ", jianjieContent=" + jianjieContent +
    "}";
    }
    }
