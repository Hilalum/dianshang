# --------------------------------------------------------------
# --------------------------------------------------------------
# --------------------   固态硬盘信息爬虫   --------------------
# --------------------------------------------------------------
# --------------------------------------------------------------
import Config
import uuid
import urllib.request
from bs4 import BeautifulSoup
from Config import *

def startToGetHarddickData():
    url_samsung="http://detail.zol.com.cn/solid_state_drive/samsung/"#三星
    url_yingruida="http://detail.zol.com.cn/solid_state_drive/yingruida/"#英睿达
    url_galaxy="http://detail.zol.com.cn/solid_state_drive/galaxy/"#影驰
    url_toshiba="http://detail.zol.com.cn/solid_state_drive/toshiba/"#东芝
    url_sandisk="http://detail.zol.com.cn/solid_state_drive/sandisk/"#闪迪
    url_plextor="http://detail.zol.com.cn/solid_state_drive/plextor/"#浦科特
    url_tekism="http://detail.zol.com.cn/solid_state_drive/tekism/"#特科芯
    url_klevv="http://detail.zol.com.cn/solid_state_drive/klevv/"#科赋
    url_pny_="http://detail.zol.com.cn/solid_state_drive/pny/"#pny
    url_teclast="http://detail.zol.com.cn/solid_state_drive/teclast/"#台电
    url_ramsta="http://detail.zol.com.cn/solid_state_drive/ramsta/"#瑞势
    url_colorful="http://detail.zol.com.cn/solid_state_drive/colorful/"#七彩虹
    url_kingtiger="http://detail.zol.com.cn/solid_state_drive/kingtiger/"#金泰克
    url_netac="http://detail.zol.com.cn/solid_state_drive/netac/"#科朗
    url_biwinsemicon="http://detail.zol.com.cn/solid_state_drive/biwinsemicon/"#佰维
    url_kingspec="http://detail.zol.com.cn/solid_state_drive/kingspec/"#金胜维
    url_kingston="http://detail.zol.com.cn/solid_state_drive/kingston/"#金士顿
    url_liteon="http://detail.zol.com.cn/solid_state_drive/liteon/"#建兴
    url_taiyanfa="http://detail.zol.com.cn/solid_state_drive/taiyanfa/"#太阳花
    url_corsair="http://detail.zol.com.cn/solid_state_drive/corsair/"#海盗船
    url_faspeed="http://detail.zol.com.cn/solid_state_drive/faspeed/"#士必得
    url_intel="http://detail.zol.com.cn/solid_state_drive/intel/"#intel
    url_maxsun="http://detail.zol.com.cn/solid_state_drive/maxsun/"#铭瑄
    url_adata="http://detail.zol.com.cn/solid_state_drive/adata/"#威刚
    url_ibigstor="http://detail.zol.com.cn/solid_state_drive/ibigstor/"#艾比格特
    url_lenovo="http://detail.zol.com.cn/solid_state_drive/lenovo/"#联想
    url_ocz="http://detail.zol.com.cn/solid_state_drive/ocz/"#饥饿鲨
    url_kingfast="http://detail.zol.com.cn/solid_state_drive/kingfast/"#金速
    url_transcend="http://detail.zol.com.cn/solid_state_drive/transcend/"#创见
    url_apacer="http://detail.zol.com.cn/solid_state_drive/apacer/"#宇瞻
    url_seagate="http://detail.zol.com.cn/solid_state_drive/seagate/"#希捷
    url_hp="http://detail.zol.com.cn/solid_state_drive/hp/"#惠普
    url_gainward="http://detail.zol.com.cn/solid_state_drive/gainward/"#耕升
    url_vaseky="http://detail.zol.com.cn/solid_state_drive/vaseky/"#威士奇
    url_aigo="http://detail.zol.com.cn/solid_state_drive/aigo/"#爱国者
    url_haikangweishi="http://detail.zol.com.cn/solid_state_drive/haikangweishi/"#海康威视
    url_eaget="http://detail.zol.com.cn/solid_state_drive/eaget/"#忆捷
    url_zhoujidz="http://detail.zol.com.cn/solid_state_drive/zhoujidz/"#盔甲
    url_dict = {
        "三星": url_samsung,
        "英睿达": url_yingruida,
        "影驰": url_galaxy,
        "东芝": url_toshiba,
        "闪迪": url_sandisk,
        "浦科特": url_plextor,
        "特科芯": url_tekism,
        "科赋": url_klevv,
        "pny": url_pny_,
        "台电": url_teclast,
        "瑞势": url_ramsta,
        "七彩虹": url_colorful,
        "金泰克": url_kingtiger,
        "科朗": url_netac,
        "佰维": url_biwinsemicon,
        "金胜维": url_kingspec,
        "金士顿": url_kingston,
        "建兴": url_liteon,
        "太阳花": url_taiyanfa,
        "海盗船": url_corsair,
        "士必得": url_faspeed,
        "intel": url_intel,
        "铭瑄": url_maxsun,
        "威刚": url_adata,
        "艾比格特": url_ibigstor,
        "联想": url_lenovo,
        "饥饿鲨": url_ocz,
        "金速": url_kingfast,
        "创见": url_transcend,
        "宇瞻": url_apacer,
        "希捷": url_seagate,
        "惠普": url_hp,
        "耕升": url_gainward,
        "威士奇": url_vaseky,
        "爱国者": url_aigo,
        "海康威视": url_haikangweishi,
        "忆捷": url_eaget,
        "盔甲": url_zhoujidz
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
                        seriesId) + "%5EmainId=396061%5EsubcateId=626%5Epage=" + str(page) + "%5EparamStr=.html"
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
                            url = "http://detail.zol.com.cn/solid_state_drive/" + i['href'].split('/')[-1]
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
                            type = "固态"  # 类型
                            all_li = soup.select('.section-content')[0].find('ul').find_all('li')
                            storage_capacity = all_li[0].find_all('p')[0].get_text().split("：")[1]
                            harddisk_size = all_li[0].find_all('p')[1].get_text().split("：")[1]
                            Interface_type = all_li[1].find_all('p')[0].get_text().split("：")[1]
                            cache = all_li[1].find_all('p')[1].get_text().split("：")[1]
                            rwspeed = all_li[2].find_all('p')[0].get_text().split("：")[1]
                            wspeed = all_li[2].find_all('p')[1].get_text().split("：")[1]
                            fault_free_time = all_li[3].find_all('p')[0].get_text().split("：")[1]
                            search_time = all_li[3].find_all('p')[1].get_text().split("：")[1]
                            sql_select = "select * from harddisk where model = '{0}';".format(model)
                            sql_insert = "insert into harddisk(id,brands,name,model,price,type,storage_capacity,harddisk_size,Interface_type,cache,rwspeed,wspeed,fault_free_time,search_time,img) values('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}','{11}','{12}','{13}','{14}');".format(id,brands,name,model,price,type,storage_capacity,harddisk_size,Interface_type,cache,rwspeed,wspeed,fault_free_time,search_time,img)
                            sql_update = "update harddisk set brands='{0}',name='{1}',model='{2}',price='{3}',type='{4}',storage_capacity='{5}',harddisk_size='{6}',Interface_type='{7}',cache='{8}',rwspeed='{9}',wspeed='{10}',fault_free_time='{11}',search_time='{12}' where model='{13}';".format(brands,name,model,price,type,storage_capacity,harddisk_size,Interface_type,cache,rwspeed,wspeed,fault_free_time,search_time,model)
                            SQL_LIST.append(SQLStruct(sql_select, sql_insert, sql_update))
                        except Exception as e:
                            pass
        except Exception as e:
            pass
    print("固态硬盘信息爬取完毕。")
    Config.Infos = Config.Infos + 1