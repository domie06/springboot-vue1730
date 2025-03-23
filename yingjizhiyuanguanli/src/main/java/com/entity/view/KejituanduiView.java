package com.entity.view;

import com.entity.KejituanduiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 科技团队
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-12
 */
@TableName("kejituandui")
public class KejituanduiView extends KejituanduiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public KejituanduiView() {

	}

	public KejituanduiView(KejituanduiEntity kejituanduiEntity) {
		try {
			BeanUtils.copyProperties(this, kejituanduiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
