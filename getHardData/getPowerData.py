# --------------------------------------------------------------
# --------------------------------------------------------------
# --------------------   电源信息爬虫   --------------------
# --------------------------------------------------------------
# --------------------------------------------------------------
import Config
import uuid
import urllib.request
from bs4 import BeautifulSoup
from Config import *

def startToGetPowerData():
    url_huntkey = "http://detail.zol.com.cn/power/huntkey/"#航嘉
    url_segotepcolorful = "http://detail.zol.com.cn/power/segotepcolorful/"#鑫谷
    url_aiguozhe="http://detail.zol.com.cn/power/aiguozhe/"#aigo
    url_goldenfield="http://detail.zol.com.cn/power/goldenfield/"#金河田
    url_sama="http://detail.zol.com.cn/power/sama/"#先马
    url_greatwalljidian="http://detail.zol.com.cn/power/greatwalljidian/"#长城机电
    url_visioncase="http://detail.zol.com.cn/power/visioncase/"#至睿
    url_tt="http://detail.zol.com.cn/power/tt/"#Tt
    url_antec="http://detail.zol.com.cn/power/antec/"#安钛克
    url_corsair="http://detail.zol.com.cn/power/corsair/"#海盗船
    url_youxihanjiang="http://detail.zol.com.cn/power/youxihanjiang/"#游戏悍将
    url_gamemax="http://detail.zol.com.cn/power/gamemax/"#GAMEMAX
    url_pccooler="http://detail.zol.com.cn/power/pccooler/"#超频三
    url_coolermaster="http://detail.zol.com.cn/power/coolermaster/"#酷冷至尊
    url_superflower="http://detail.zol.com.cn/power/superflower/"#振华
    url_fsp="http://detail.zol.com.cn/power/fsp/"#全汉
    url_seasonic="http://detail.zol.com.cn/power/seasonic/"#海韵
    url_bubalus="http://detail.zol.com.cn/power/bubalus/"#大水牛
    url_delta="http://detail.zol.com.cn/power/delta/"#台达科技
    url_enermax="http://detail.zol.com.cn/power/enermax/"#安耐美
    url_hecworld="http://detail.zol.com.cn/power/hecworld/"#骨伽
    url_onda="http://detail.zol.com.cn/power/onda/"#昂达
    url_galaxy="http://detail.zol.com.cn/power/galaxy/"#影驰
    url_delux="http://detail.zol.com.cn/power/delux/"#多彩
    url_bandbox="http://detail.zol.com.cn/power/bandbox/"#半岛铁盒
    url_deepcool="http://detail.zol.com.cn/power/deepcool/"#九州风神
    url_gigabyte="http://detail.zol.com.cn/power/gigabyte/"#技嘉
    url_youxigaoshou="http://detail.zol.com.cn/power/youxigaoshou/"#游戏高手
    url_maxelite="http://detail.zol.com.cn/power/maxelite/"#鑫麦粒
    url_hkc="http://detail.zol.com.cn/power/hkc/"#HKC
    url_ice="http://detail.zol.com.cn/power/ice/"#玩嘉
    url_id_coolin="http://detail.zol.com.cn/power/id-cooling/"#ID-COOLING
    url_sanduanshi="http://detail.zol.com.cn/power/sanduanshi/"#三段式
    url_dict = {
        "航嘉":url_huntkey,
        "鑫谷":url_segotepcolorful,
        "aigo":url_aiguozhe,
        "金河田":url_goldenfield,
        "先马":url_sama,
        "长城机电":url_greatwalljidian,
        "至睿":url_visioncase,
        "Tt":url_tt,
        "安钛克":url_antec,
        "海盗船":url_corsair,
        "游戏悍将":url_youxihanjiang,
        "GAMEMAX":url_gamemax,
        "超频三":url_pccooler,
        "酷冷至尊":url_coolermaster,
        "振华":url_superflower,
        "全汉":url_fsp,
        "海韵":url_seasonic,
        "大水牛":url_bubalus,
        "台达科技":url_delta,
        "安耐美":url_enermax,
        "骨伽":url_hecworld,
        "昂达":url_onda,
        "影驰":url_galaxy,
        "多彩":url_delux,
        "半岛铁盒":url_bandbox,
        "九州风神":url_deepcool,
        "技嘉":url_gigabyte,
        "游戏高手":url_youxigaoshou,
        "鑫麦粒":url_maxelite,
        "HKC":url_hkc,
        "玩嘉":url_ice,
        "ID-COOLING":url_id_coolin,
        "三段式":url_sanduanshi
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
                        seriesId) + "%5EmainId=133858%5EsubcateId=35%5Epage=" + str(page) + "%5EparamStr=.html"
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
                            url = "http://detail.zol.com.cn/power/" + i['href'].split('/')[-1]
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
                            power_type = all_li[0].find_all('p')[0].get_text().split("：")[1]
                            out_line_type = all_li[0].find_all('p')[1].get_text().split("：")[1]
                            rated_power = all_li[1].find_all('p')[0].get_text().split("：")[1]
                            max_power = all_li[1].find_all('p')[1].get_text().split("：")[1]
                            motherboard_interface = all_li[2].find_all('p')[0].get_text().split("：")[1]
                            hard_disk_interface = all_li[2].find_all('p')[1].get_text().split("：")[1]
                            pfc_type = all_li[3].find_all('p')[0].get_text().split("：")[1]
                            conversion_efficiency = all_li[3].find_all('p')[1].get_text().split("：")[1]
                            sql_select = "select * from power where model = '{0}';".format(model)
                            sql_insert = "insert into power(id,brands,name,model,price,power_type,out_line_type,rated_power,max_power,motherboard_interface,hard_disk_interface,pfc_type,conversion_efficiency,img) values('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}','{11}','{12}','{13}');".format(id,brands,name,model,price,power_type,out_line_type,rated_power,max_power,motherboard_interface,hard_disk_interface,pfc_type,conversion_efficiency,img)
                            sql_update = "update power set brands='{0}',name='{1}',model='{2}',price='{3}',power_type='{4}',out_line_type='{5}',rated_power='{6}',max_power='{7}',motherboard_interface='{8}',hard_disk_interface='{9}',pfc_type='{10}',conversion_efficiency='{11}' where model = '{12}';".format(brands,name,model,price,power_type,out_line_type,rated_power,max_power,motherboard_interface,hard_disk_interface,pfc_type,conversion_efficiency,model)
                            SQL_LIST.append(SQLStruct(sql_select, sql_insert, sql_update))
                        except Exception as e:
                            pass
        except Exception as e:
            pass
    print("电源数据获取完毕。")
    Config.Infos = Config.Infos + 1