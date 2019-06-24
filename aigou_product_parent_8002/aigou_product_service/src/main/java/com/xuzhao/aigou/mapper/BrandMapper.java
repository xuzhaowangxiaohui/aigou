package com.xuzhao.aigou.mapper;

import com.xuzhao.aigou.domain.Brand;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xuzhao.aigou.query.BrandQuery;

import java.util.List;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author xuzhao
 * @since 2019-06-24
 */
public interface BrandMapper extends BaseMapper<Brand> {
    long queryPageCount(BrandQuery brandQuery);


    List<Brand> queryPageList(BrandQuery brandQuery);
}
