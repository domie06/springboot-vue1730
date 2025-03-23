package com.entity.model;

import com.entity.KejituanduiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 科技团队
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-12
 */
public class KejituanduiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 团队名称 Search
     */
    private String name;


    /**
     * 团队负责人 Search
     */
    private String fuzheren;


    /**
     * 团队创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date teamTime;


    /**
     * 团队简介
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
	 * 设置：团队名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：团队名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：团队负责人 Search
	 */
    public String getFuzheren() {
        return fuzheren;
    }


    /**
	 * 获取：团队负责人 Search
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

    }
