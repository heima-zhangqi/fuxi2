package com.qc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qc.entity.PageResult;
import com.qc.entity.Result;
import com.qc.pojo.goods.Brand;
import com.qc.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


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
    public PageResult<Brand> findPages(Integer page, Integer size,Map<String,String> searchMap){
        return brandService.findPages(page,size,searchMap);
    }
    @PostMapping("/findList")
    public List<Brand> findList(@RequestBody Map<String,Object> searchMap){
        return brandService.findList(searchMap);
    }

    @GetMapping("/findById")
    public Brand findById(Integer id){
        return brandService.findById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result();
    }


    @GetMapping("/delete")
    public Result delete(Integer id){
        brandService.delete(id);
        return new Result();
    }
}
