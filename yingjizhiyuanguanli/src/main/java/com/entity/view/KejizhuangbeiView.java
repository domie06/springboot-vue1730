package com.entity.view;

import com.entity.KejizhuangbeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 科技装备
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-12
 */
@TableName("kejizhuangbei")
public class KejizhuangbeiView extends KejizhuangbeiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public KejizhuangbeiView() {

	}

	public KejizhuangbeiView(KejizhuangbeiEntity kejizhuangbeiEntity) {
		try {
			BeanUtils.copyProperties(this, kejizhuangbeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
