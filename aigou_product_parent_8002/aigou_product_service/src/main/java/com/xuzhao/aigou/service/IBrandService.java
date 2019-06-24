package com.xuzhao.aigou.service;

import com.xuzhao.aigou.domain.Brand;
import com.baomidou.mybatisplus.service.IService;
import com.xuzhao.aigou.query.BrandQuery;
import com.xuzhao.aigou.util.PageList;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author xuzhao
 * @since 2019-06-24
 */
public interface IBrandService extends IService<Brand> {
    PageList<Brand> queryPage(BrandQuery query);
}
