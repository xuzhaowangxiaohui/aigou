package com.xuzhao.aigou.service;

import com.xuzhao.aigou.domain.ProductType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author xuzhao
 * @since 2019-06-25
 */
public interface IProductTypeService extends IService<ProductType> {

    List<ProductType> selectTreeData();
}
