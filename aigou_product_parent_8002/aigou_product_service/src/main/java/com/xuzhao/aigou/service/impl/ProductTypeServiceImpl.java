package com.xuzhao.aigou.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.xuzhao.aigou.domain.ProductType;
import com.xuzhao.aigou.mapper.ProductTypeMapper;
import com.xuzhao.aigou.service.IProductTypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * @author xuzhao
 * @since 2019-06-25
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;


    @Override
    public List<ProductType> selectTreeData() {
        //组装树结构：
        //return treeDataRecursion(0L);
        return treeDataLoop();
    }

    /**
     * 快一点就少发送sql：一条就最少：select * from t_product_type，获取到这个数据进行组装：直接在内存中组装：
     *
     * @return
     */
    private List<ProductType> treeDataLoop() {
        //1:先发送一条sql，查询所有的数据：1,2,3...
        List<ProductType> productTypeList = new ArrayList<>();
        productTypeList = productTypeMapper.selectList(null);
        //组装数据id和数据对象的关系
        Map<Long, ProductType> map = new HashMap<>();
        for (ProductType c : productTypeList) {
            map.put(c.getId(), c);
        }

        List<ProductType> result = new ArrayList<>();
        //2:遍历每一个对象：找它儿子设置给他
        for (ProductType current : productTypeList) {
            //找当前对象的老子：
            // current:id=2
            //pid==0的判断：就直接返回
            Long pid = current.getPid();
            if (pid == 0) {
                //一级菜单
                result.add(current);
                continue;
            }
            ProductType parent = map.get(pid);
            parent.getChildren().add(current);
        }

        return result;
    }

    /**
     * #  返会的数据：是一级菜单的数组：每一个一级菜单有有二级菜单  每一个二级菜单有三级菜单
     * #1：获取一级菜单：children：
     * select * from t_product_type where pid =0
     * # 遍历一级菜单：获取二级菜单：1   100   163.。。。
     * select * from t_product_type where pid =1 # 数据放到父节点的children
     * select * from t_product_type where pid =100
     * 递归：
     * 每次递归都要发送sql，导致发送了很多sql，所以就慢了========》
     * 快一点就少发送sql：一条就最少：select * from t_product_type，获取到这个数据进行组装：直接在内存中组装：
     *
     * @return
     */
    private List<ProductType> treeDataRecursion(long pid) {
        //  select * from t_product_type where pid =0
        //某一个的节点的儿子：
        List<ProductType> allChildren = getAllChildren(pid);

        //没有儿子：就是递归的出口
        if (allChildren == null || allChildren.size() == 0) {
            return null;
        }

        // 1   100   163
        for (ProductType child : allChildren) {
            // 获取当前对象的儿子：设置给自己做儿子
            // currentId=1
            Long currentId = child.getId();
            List<ProductType> sons = treeDataRecursion(currentId);
            // 设置给自己做儿子
            child.setChildren(sons);

        }

        return allChildren;
    }

    private List<ProductType> getAllChildren(long pid) {
        //  select * from t_product_type where pid =0
        //  List<ProductType> children = new ArrayList<>();
        Wrapper<ProductType> wrapper = new EntityWrapper<>();
        wrapper.eq("pid", pid);
        return productTypeMapper.selectList(wrapper);
    }


}
