package com.xuzhao.aigou.service.impl;

import com.xuzhao.aigou.domain.Brand;
import com.xuzhao.aigou.mapper.BrandMapper;
import com.xuzhao.aigou.query.BrandQuery;
import com.xuzhao.aigou.service.IBrandService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xuzhao.aigou.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author xuzhao
 * @since 2019-06-24
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public PageList<Brand> queryPage(BrandQuery query) {
        PageList<Brand> pageList =new PageList<>();
        long count = brandMapper.queryPageCount(query);
        if(count>0){
            List<Brand> brands = brandMapper.queryPageList(query);
            pageList.setTotal(count);
            pageList.setRows(brands);
        }
        return pageList;
    }
}
