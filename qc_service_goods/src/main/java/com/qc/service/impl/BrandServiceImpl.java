package com.qc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.alibaba.dubbo.container.page.PageHandler;
import com.qc.dao.BrandMapper;
import com.qc.entity.PageResult;
import com.qc.pojo.goods.Brand;
import com.qc.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.List;


@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public PageResult<Brand> findPages(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Brand> brands=brandMapper.selectAll();
        pageInfo<Brand> pageInfo=new PageInfo<>();

        PageResult<Brand> pageResult = new PageResult<>(pageInfo.getTotal(), pageInfo.getList());

        return pageResult;
    }

}
