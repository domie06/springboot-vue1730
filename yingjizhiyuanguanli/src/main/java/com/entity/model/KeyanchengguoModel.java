package com.entity.model;

import com.entity.KeyanchengguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 科研成果
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-12
 */
public class KeyanchengguoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 成果名称 Search
     */
    private String name;


    /**
     * 研发团队
     */
    private Integer kjtdTypes;


    /**
     * 完成时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date teamTime;


    /**
     * 成果简介
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
	 * 设置：成果名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：成果名称 Search
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

    }
