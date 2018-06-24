# --------------------------------------------------------------
# --------------------------------------------------------------
# --------------------   显卡信息爬虫   -------------------------
# --------------------------------------------------------------
# --------------------------------------------------------------
import Config
import uuid
import urllib.request
from bs4 import BeautifulSoup
from Config import *

def startToGetVideocardData():
    url_colorful = "http://detail.zol.com.cn/vga/colorful/"#七彩虹
    url_galaxy = "http://detail.zol.com.cn/vga/galaxy/"#影驰
    url_zotac = "http://detail.zol.com.cn/vga/zotac/"#索泰
    url_msi = "http://detail.zol.com.cn/vga/msi/"#MSI微星
    url_gainward = "http://detail.zol.com.cn/vga/gainward/"#耕升
    url_maxsun = "http://detail.zol.com.cn/vga/maxsun/"#铭瑄
    url_sapphire= "http://detail.zol.com.cn/vga/sapphire/"#蓝宝石
    url_asus= "http://detail.zol.com.cn/vga/asus/"#华硕
    url_colorfire= "http://detail.zol.com.cn/vga/colorfire/"#镭风
    url_powercolortech= "http://detail.zol.com.cn/vga/powercolortech/"#迪兰
    url_xiaoyingba= "http://detail.zol.com.cn/vga/xiaoyingba/"#小影霸
    url_xiangsheng= "http://detail.zol.com.cn/vga/xiangsheng/"#ASL翔升
    url_inno3d= "http://detail.zol.com.cn/vga/inno3d/"#映众
    url_leadtek= "http://detail.zol.com.cn/vga/leadtek/"#丽台
    url_nvidia= "http://detail.zol.com.cn/vga/nvidia/"#NVIDIA
    url_amd= "http://detail.zol.com.cn/vga/amd/"#AMD
    url_xfx= "http://detail.zol.com.cn/vga/xfx/"#XFX讯景
    url_onda= "http://detail.zol.com.cn/vga/onda/"#奥达
    url_yeston= "http://detail.zol.com.cn/vga/yeston/"#盈通
    url_soyo= "http://detail.zol.com.cn/vga/soyo/"#梅捷
    url_pny= "http://detail.zol.com.cn/vga/pny/"#PNY
    url_biostar= "http://detail.zol.com.cn/vga/biostar/"#映泰
    url_gigabyte= "http://detail.zol.com.cn/vga/gigabyte/"#技嘉
    url_dict = {
        "七彩虹": url_colorful,
        "影驰": url_galaxy,
        "索泰": url_zotac,
        "MSI微星": url_msi,
        "耕升": url_gainward,
        "铭瑄": url_maxsun,
        "蓝宝石": url_sapphire,
        "华硕": url_asus,
        "镭风": url_colorfire,
        "迪兰": url_powercolortech,
        "小影霸": url_xiaoyingba,
        "ASL翔升": url_xiangsheng,
        "映众": url_inno3d,
        "丽台": url_leadtek,
        "NVIDIA": url_nvidia,
        "AMD": url_amd,
        "XFX讯景": url_xfx,
        "奥达": url_onda,
        "盈通": url_yeston,
        "梅捷": url_soyo,
        "PNY": url_pny,
        "映泰": url_biostar,
        "技嘉": url_gigabyte
    }
    for key in url_dict:
        try:
            req = urllib.request.Request(url_dict[key])
            r = urllib.request.urlopen(req)
            html = r.read().decode('gbk')
            soup = BeautifulSoup(html, 'html.parser')
            all_a = soup.find(id='J_SeriesFilter').find('div').find_all('a')
            for item in all_a:
                name = item.get_text()
                seriesId = item.get('href').split('/')[-1].split('.')[0].split('_')[0]
                page = 1
                while True:
                    url = "http://detail.zol.com.cn/xhr4_Series_GetSeriesPro_isAjax=1%5EseriesId=" + str(
                        seriesId) + "%5EmainId=1149038%5EsubcateId=6%5Epage=" + str(page) + "%5EparamStr=.html"
                    page = page + 1
                    req = urllib.request.Request(url)
                    r = urllib.request.urlopen(req)
                    html = r.read().decode('utf-8')
                    if len(html) == 60:
                        break;
                    soup = BeautifulSoup(html, 'html.parser')
                    for i in soup.find_all('a'):
                        try:
                            idname = i['title']
                            url = "http://detail.zol.com.cn/vga/" + i['href'].split('/')[-1]
                            req = urllib.request.Request(url)
                            r = urllib.request.urlopen(req)
                            html = r.read().decode('gbk', errors='ignore')
                            soup = BeautifulSoup(html, 'html.parser')
                            id = uuid.uuid1()
                            brands = key  # 品牌名
                            name  # 系列名
                            model = idname  # 产品型号名
                            price = soup.select('.price-type')[0].get_text()  # 价格
                            img = soup.select('.big-pic')[0].find('img').get('src')
                            all_li = soup.select('.section-content')[0].find('ul').find_all('li')
                            graphics_card_type = all_li[0].find_all('p')[0].get_text().split("：")[1]
                            video_card_chip = all_li[0].find_all('p')[1].get_text().split("：")[1]
                            core_frequency = all_li[1].find_all('p')[0].get_text().split("：")[1]
                            memory_frequency = all_li[1].find_all('p')[1].get_text().split("：")[1]
                            memory_capacity = all_li[2].find_all('p')[0].get_text().split("：")[1]
                            memory_interface = all_li[2].find_all('p')[1].get_text().split("：")[1]
                            power_interface = all_li[3].find_all('p')[0].get_text().split("：")[1]
                            power_supply_mode = all_li[3].find_all('p')[1].get_text().split("：")[1]
                            sql_select = "select * from videocard where model = '{0}';".format(model)
                            sql_insert = "insert into videocard(id,brands,model,price,graphics_card_type,video_card_chip,core_frequency,memory_frequency,memory_capacity,memory_interface,power_interface,power_supply_mode,img) values('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}','{11}','{12}');".format(id,brands,model,price,graphics_card_type,video_card_chip,core_frequency,memory_frequency,memory_capacity,memory_interface,power_interface,power_supply_mode,img)
                            sql_update = "update videocard set brands='{0}',model='{1}',price='{2}',graphics_card_type='{3}',video_card_chip='{4}',core_frequency='{5}',memory_frequency='{6}',memory_capacity='{7}',memory_interface='{8}',power_interface='{9}',power_supply_mode='{10}' where model = '{11}';".format(brands,model,price,graphics_card_type,video_card_chip,core_frequency,memory_frequency,memory_capacity,memory_interface,power_interface,power_supply_mode,model)
                            SQL_LIST.append(SQLStruct(sql_select, sql_insert, sql_update))
                        except Exception as e:
                            pass
        except Exception as e:
            pass
    print("显卡信息爬取完毕。")
    Config.Infos = Config.Infos + 1









