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
 * 科研成果
 *
 * @email
 * @date 2021-03-12
 */
@TableName("keyanchengguo")
public class KeyanchengguoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public KeyanchengguoEntity() {

    }

    public KeyanchengguoEntity(T t) {
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
     * 成果名称
     */
    @TableField(value = "name")

    private String name;


    /**
     * 研发团队
     */
    @TableField(value = "kjtd_types")

    private Integer kjtdTypes;


    /**
     * 完成时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "team_time",fill = FieldFill.UPDATE)

    private Date teamTime;


    /**
     * 成果简介
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
	 * 设置：成果名称
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：成果名称
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：研发团队
	 */
    public Integer getKjtdTypes() {
        return kjtdTypes;
    }


    /**
	 * 获取：研发团队
	 */

    public void setKjtdTypes(Integer kjtdTypes) {
        this.kjtdTypes = kjtdTypes;
    }
    /**
	 * 设置：完成时间
	 */
    public Date getTeamTime() {
        return teamTime;
    }


    /**
	 * 获取：完成时间
	 */

    public void setTeamTime(Date teamTime) {
        this.teamTime = teamTime;
    }
    /**
	 * 设置：成果简介
	 */
    public String getJianjieContent() {
        return jianjieContent;
    }


    /**
	 * 获取：成果简介
	 */

    public void setJianjieContent(String jianjieContent) {
        this.jianjieContent = jianjieContent;
    }

    @Override
    public String toString() {
    return "Keyanchengguo{" +
            "id=" + id +
            ", name=" + name +
            ", kjtdTypes=" + kjtdTypes +
            ", teamTime=" + teamTime +
            ", jianjieContent=" + jianjieContent +
    "}";
    }
    }
