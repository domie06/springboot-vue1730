package com.entity.view;

import com.entity.YanfapingtaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 研发平台
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @email
 * @date 2021-03-12
 */
@TableName("yanfapingtai")
public class YanfapingtaiView extends YanfapingtaiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public YanfapingtaiView() {

	}

	public YanfapingtaiView(YanfapingtaiEntity yanfapingtaiEntity) {
		try {
			BeanUtils.copyProperties(this, yanfapingtaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
