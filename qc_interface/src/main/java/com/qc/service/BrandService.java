package com.qc.service;

import com.qc.entity.PageResult;
import com.qc.pojo.goods.Brand;

import java.util.List;


public interface BrandService {
    List<Brand> findAll();
    public PageResult<Brand> findPages(Integer page,Integer size);


}
