package com.entity.view;

import com.entity.JichusheshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 基础设施
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-12
 */
@TableName("jichusheshi")
public class JichusheshiView extends JichusheshiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public JichusheshiView() {

	}

	public JichusheshiView(JichusheshiEntity jichusheshiEntity) {
		try {
			BeanUtils.copyProperties(this, jichusheshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
