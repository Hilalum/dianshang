package com.zhgy.util;

import com.zhgy.entity.*;
import com.zhgy.service.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

// 推荐算法类
@Controller
@RequestMapping(value = "/recommend", method = RequestMethod.GET)
public class Recommend {
    // 默认优先级 "power" < "memorybar" < "harddisk" < "mainboard" < "videocard" < "cpu"
    @Autowired private CpuService cpuService;
    @Autowired private HarddiskService harddiskService;
    @Autowired private MainboardService mainboardService;
    @Autowired private MemorybarService memorybarService;
    @Autowired private PowerService powerService;
    @Autowired private VideocardService videocardService;

    // 开始计算所有情况
    @RequestMapping(value = "/get_recommend", method = RequestMethod.GET)
    public @ResponseBody
    List getRecommendList(@RequestParam("prices") float maxPrice){
        int computational_domain = 2;
        ArrayList<CpuEntity> cpu_list;
        ArrayList<VideocardEntity> videocard_list;
        ArrayList<MainboardEntity> mainboard_list;
        ArrayList<HarddiskEntity> harddisk_list;
        ArrayList<MemorybarEntity> memorybar_list;
        ArrayList<PowerEntity> power_list;
        ArrayList<RecommendEntity> req_list;
        String add_sql = " and price not like '%-%' and price not like '%万%' and price not like '停产' and price not like '即将上市' and price not like '暂无报价' and price not like '价格面议' and price not like '概念产品' ORDER BY CONVERT(price,SIGNED) desc";
        req_list = new ArrayList<RecommendEntity>();
        int prices = (int)maxPrice;
        cpu_list = cpuService.getCPUByCondition("price<"+(prices/4)+add_sql, 1, computational_domain);
        int type1, type2, type3, type4, type5; type1 = prices;
        for(int i1=0; i1<cpu_list.size(); i1++){
            videocard_list = videocardService.getCPUByCondition("price<"+((prices*3)/13)+add_sql, 1, computational_domain);
            type2 = prices;
            for(int i2=0; i2<videocard_list.size(); i2++){
                mainboard_list = mainboardService.getCPUByCondition("price<"+((prices*3)/18)+add_sql, 1, computational_domain);
                type3 = prices;
                for(int i3=0; i3<mainboard_list.size(); i3++){
                    harddisk_list = harddiskService.getCPUByCondition("price<"+((prices*3)/23)+add_sql, 1, computational_domain);
                    type4 = prices;
                    for(int i4=0; i4<harddisk_list.size(); i4++){
                        memorybar_list = memorybarService.getCPUByCondition("price<"+((prices*3)/24)+add_sql, 1, computational_domain);
                        type5 = prices;
                        for(int i5=0; i5<memorybar_list.size(); i5++){
                            power_list = powerService.getCPUByCondition("price<"+((prices*3)/28)+add_sql, 1, computational_domain);
                            for(int i6=0; i6<power_list.size(); i6++){
                                RecommendEntity re = new RecommendEntity();
                                re.setCpuEntity(cpu_list.get(i1));
                                re.setVideocardEntity(videocard_list.get(i2));
                                re.setMainboardEntity(mainboard_list.get(i3));
                                re.setHarddiskEntity(harddisk_list.get(i4));
                                re.setMemorybarEntity(memorybar_list.get(i5));
                                re.setPowerEntity(power_list.get(i6));
                                req_list.add(re);
                            }prices = type5;
                        }prices = type4;
                    }prices = type3;
                }prices = type2;
            }prices = type1;
        }
        for(int i=0; i<req_list.size(); i++){
            float num = 0;
            RecommendEntity e = req_list.get(i);
            System.out.println("方案"+i+": ");
            System.out.println("    CPU: ");
            System.out.println("        品牌名："+e.getCpuEntity().getBrands()+"。 系列名："+e.getCpuEntity().getName()+"。 产品型号："+e.getCpuEntity().getModel()+"。 价格："+e.getCpuEntity().getPrice()); num += Float.parseFloat(e.getCpuEntity().getPrice());
            System.out.println("    显卡: ");
            System.out.println("        品牌名："+e.getVideocardEntity().getBrands()+"。 系列名："+e.getVideocardEntity().getName()+"。 产品型号："+e.getVideocardEntity().getModel()+"。 价格："+e.getVideocardEntity().getPrice()); num += Float.parseFloat(e.getVideocardEntity().getPrice());
            System.out.println("    主板: ");
            System.out.println("        品牌名："+e.getMainboardEntity().getBrands()+"。 系列名："+e.getMainboardEntity().getName()+"。 产品型号："+e.getMainboardEntity().getModel()+"。 价格："+e.getMainboardEntity().getPrice()); num += Float.parseFloat(e.getMainboardEntity().getPrice());
            System.out.println("    硬盘: ");
            System.out.println("        品牌名："+e.getHarddiskEntity().getBrands()+"。 系列名："+e.getHarddiskEntity().getName()+"。 产品型号："+e.getHarddiskEntity().getModel()+"。 价格："+e.getHarddiskEntity().getPrice() + "。 类型:" + e.getHarddiskEntity().getType()); num += Float.parseFloat(e.getHarddiskEntity().getPrice());
            System.out.println("    内存条: ");
            System.out.println("        品牌名："+e.getMemorybarEntity().getBrands()+"。 系列名："+e.getMemorybarEntity().getName()+"。 产品型号："+e.getMemorybarEntity().getModel()+"。 价格："+e.getMemorybarEntity().getPrice()); num += Float.parseFloat(e.getMemorybarEntity().getPrice());
            System.out.println("    电源: ");
            System.out.println("        品牌名："+e.getPowerEntity().getBrands()+"。 系列名："+e.getPowerEntity().getName()+"。 产品型号："+e.getPowerEntity().getModel()+"。 价格："+e.getPowerEntity().getPrice()); num += Float.parseFloat(e.getPowerEntity().getPrice());
            System.out.println("    总金额:"+num);
            System.out.println();
        }
        return req_list;
    }
}
