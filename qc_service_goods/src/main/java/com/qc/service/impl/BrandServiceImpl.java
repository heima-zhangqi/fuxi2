package com.qc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qc.dao.BrandMapper;
import com.qc.entity.PageResult;
import com.qc.pojo.goods.Brand;
import com.qc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;


@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public PageResult<Brand> findPages(Integer page, Integer size, Map<String, String> searchMap) {
        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectAll();
        pageInfo<Brand> pageInfo = new PageInfo<>();

        PageResult<Brand> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

        return pageResult;
    }

    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return (List<Brand>) brandMapper.selectByPrimaryKey(example);
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

}
