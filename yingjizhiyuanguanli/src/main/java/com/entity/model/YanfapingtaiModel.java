package com.entity.model;

import com.entity.YanfapingtaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 研发平台
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-12
 */
public class YanfapingtaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 平台名称 Search
     */
    private String name;


    /**
     * 研发项目
     */
    private String yanfaxiangm;


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
	 * 设置：平台名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：平台名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：研发项目
	 */
    public String getYanfaxiangm() {
        return yanfaxiangm;
    }


    /**
	 * 获取：研发项目
	 */

    public void setYanfaxiangm(String yanfaxiangm) {
        this.yanfaxiangm = yanfaxiangm;
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
