package com.qc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.entity.PageResult;
import com.qc.pojo.goods.Brand;
import com.qc.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Controller
@RequestMapping("/brand")
public class BrandController {

    @Reference//远程调用
    private BrandService brandService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    @GetMapping("/finePage")
    public PageResult<Brand> findPages(Integer page, Integer size){
        return brandService.findPages(page,size);
    }
}
