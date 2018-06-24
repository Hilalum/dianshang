package com.zhgy.actiondata;

import com.zhgy.entity.CpuEntity;
import com.zhgy.service.CpuService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Class Name: CpuActionData
 * 功能：该类提供了返回JSON格式的数据接口。
 * 方法名：
 *     1.getAllBrands();
 *         访问地址：.../cpu/all_brands
 *         携带参数：无
 *         请求类型：POST
 *         说明：该方法返回CPU的所有品牌。
 *
 *     2.getAllNameByBrand(brand_name)
 *         访问地址：.../cpu/all_name_by_brand
 *         携带参数：brand_name - 用于指明一个品牌的名称
 *         请求类型：POST
 *         说明：该方法返回 CPU 指定 品牌名 的所有 系列名
 *
 *     3.getAllModelByBrandAndName(brand_name, name)
 *         访问地址：.../cpu/all_model_by_brand_name
 *         携带参数：brand_name - 用于指明一个品牌的名称
 *                   name - 用于指明一个品牌下的系列名
 *         请求类型：POST
 *         说明：该方法返回CPU中指定品牌下系列的所有产品名
 *
 *     4.getAllByPageNumAndSize(pageNum, pageSize)
 *         访问地址：.../cpu/all_by_num_size
 *         携带参数：pageNum - 需要返回的当前页数值
 *                   pageSize - 当前页面的数据容量
 *         请求类型：POST
 *         说明：该方法返回无选择条件的CPU信息
 *
 *     5.getAllByWherePageNumAndSize(where_context, pageNum, pageSize)
 *         访问地址：.../cpu/all_by_condition
 *         携带参数：where_context - 数据筛选条件，如（price<1000 and price not like '%万%'）
 *                   pageNum - 需要返回的当前页数值
 *                   pageSize - 当前页面的数据容量
 *         请求类型：POST
 *         说明：该方法返回按照选择的条件返回相应的CPU信息
 *
 * */


@Controller
@RequestMapping(value = "/cpu", method = RequestMethod.POST)
public class CpuActionData {

    @Autowired
    private CpuService cpuService;

    @ResponseBody
    @RequestMapping(value = "/all_brands", method = RequestMethod.POST)
    public String getAllBrands(Model model){
        JSONArray jsonArray = new JSONArray();
        List<String> list = cpuService.getAllBrandsName();
        for(int i=0; i<list.size(); i++){
            JSONObject jo = new JSONObject();
            jo.put("BrandName", list.get(i));
            jsonArray.put(jo);
        }
        return jsonArray.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/all_name_by_brand", method = RequestMethod.POST)
    public String getAllNameByBrand(@RequestParam("brand_name") String brand_name, Model model){
        JSONArray jsonArray = new JSONArray();
        List<String> list = cpuService.getAllNameByBrand(brand_name);
        for(int i=0; i<list.size(); i++){
            JSONObject jo = new JSONObject();
            jo.put("Name", list.get(i));
            jsonArray.put(jo);
        }
        return jsonArray.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/all_model_by_brand_name", method = RequestMethod.POST)
    public String getAllModelByBrandAndName(@RequestParam("brand_name") String brand_name,
                                            @RequestParam("name") String name,
                                            Model model){
        JSONArray jsonArray = new JSONArray();
        List<String> list = cpuService.getAllModelByBrandAndName(brand_name, name);
        for(int i=0; i<list.size(); i++){
            JSONObject jo = new JSONObject();
            jo.put("Model", list.get(i));
            jsonArray.put(jo);
        }
        return jsonArray.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/all_by_num_size", method = RequestMethod.POST)
    public String getAllByPageNumAndSize(@RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize,
                                         Model model){
        JSONArray jsonArray = new JSONArray();
        List<CpuEntity> list = cpuService.getAllByPageNumAndSize(pageNum, pageSize);
        for(int i=0; i<list.size(); i++){
            JSONObject jo = new JSONObject();
            CpuEntity ce = list.get(i);
            jo.put("id", ce.getId());
            jo.put("brands", ce.getBrands());
            jo.put("name", ce.getName());
            jo.put("model", ce.getModel());
            jo.put("price", ce.getPrice());
            jo.put("applicable_type", ce.getApplicableType());
            jo.put("cpu_series", ce.getCpuSeries());
            jo.put("cpu_main_frequency", ce.getCpuMainFrequency());
            jo.put("ghz", ce.getGhz());
            jo.put("slot_type", ce.getSlotType());
            jo.put("two_level_caching", ce.getTwoLevelCaching());
            jo.put("core_quantity", ce.getCoreQuantity());
            jo.put("thread_number", ce.getThreadNumber());
            jo.put("img", ce.getImg());
            jsonArray.put(jo);
        }
        return jsonArray.toString();
    }

    @ResponseBody
    @RequestMapping(value = "/all_by_condition", method = RequestMethod.POST)
    public String getAllByWherePageNumAndSize(@RequestParam("where_context") String where_context,
                                               @RequestParam("pageNum") Integer pageNum,
                                               @RequestParam("pageSize") Integer pageSize,
                                               Model model){
        JSONArray jsonArray = new JSONArray();
        List<CpuEntity> list = cpuService.getCPUByCondition(where_context, pageNum, pageSize);
        for(int i=0; i<list.size(); i++){
            JSONObject jo = new JSONObject();
            CpuEntity ce = list.get(i);
            jo.put("id", ce.getId());
            jo.put("brands", ce.getBrands());
            jo.put("name", ce.getName());
            jo.put("model", ce.getModel());
            jo.put("price", ce.getPrice());
            jo.put("applicable_type", ce.getApplicableType());
            jo.put("cpu_series", ce.getCpuSeries());
            jo.put("cpu_main_frequency", ce.getCpuMainFrequency());
            jo.put("ghz", ce.getGhz());
            jo.put("slot_type", ce.getSlotType());
            jo.put("two_level_caching", ce.getTwoLevelCaching());
            jo.put("core_quantity", ce.getCoreQuantity());
            jo.put("thread_number", ce.getThreadNumber());
            jo.put("img", ce.getImg());
            jsonArray.put(jo);
        }
        return jsonArray.toString();
    }
}
