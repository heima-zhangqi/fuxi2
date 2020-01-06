package com.qc.service;

import com.qc.entity.PageResult;
import com.qc.pojo.goods.Brand;

import java.util.List;
import java.util.Map;


public interface BrandService {
    List<Brand> findAll();

    public PageResult<Brand> findPages(Integer page, Integer size, Map<String,String> searchMap);

    public List<Brand> findList(Map<String,Object> searchMap);

    public Brand findById(Integer id);

    public void add(Brand brand);

    public void update(Brand brand);

    public void delete(Integer id);

}
