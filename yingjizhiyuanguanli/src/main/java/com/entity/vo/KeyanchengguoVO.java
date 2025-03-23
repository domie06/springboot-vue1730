package com.entity.vo;

import com.entity.KeyanchengguoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 科研成果
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-12
 */
@TableName("keyanchengguo")
public class KeyanchengguoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 成果名称 Search
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "team_time")
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
