# --------------------------------------------------------------
# --------------------------------------------------------------
# --------------------   内存条信息爬虫   ----------------------
# --------------------------------------------------------------
# --------------------------------------------------------------
import Config
import uuid
import urllib.request
from bs4 import BeautifulSoup
from Config import *

def startToGetMemorybarData():
    url_yingruida = "http://detail.zol.com.cn/memory/yingruida/"  # 英睿达
    url_galaxy = "http://detail.zol.com.cn/memory/galaxy/"  # 影驰
    url_asgardasgard = "http://detail.zol.com.cn/memory/asgardasgard/"  # 阿斯加特
    url_klevv = "http://detail.zol.com.cn/memory/klevv/"  # 科斌
    url_corsair = "http://detail.zol.com.cn/memory/corsair/"  # 海盗船
    url_ramsta = "http://detail.zol.com.cn/memory/ramsta/"  # 瑞势
    url_gskill = "http://detail.zol.com.cn/memory/gskill/"  # 芝奇
    url_kingtiger = "http://detail.zol.com.cn/memory/kingtiger/"  # 金泰克
    url_geil = "http://detail.zol.com.cn/memory/geil/"  # 金邦科技
    url_tekism = "http://detail.zol.com.cn/memory/tekism/"  # 特科芯
    url_kingston = "http://detail.zol.com.cn/memory/kingston/"  # 金士顿
    url_adata = "http://detail.zol.com.cn/memory/adata/"  # 威刚
    url_apacer = "http://detail.zol.com.cn/memory/apacer/"  # 宇瞻
    url_samsung = "http://detail.zol.com.cn/memory/samsung/"  # 三星
    url_xian = "http://detail.zol.com.cn/memory/xian/"  # 现代
    url_thinkpad = "http://detail.zol.com.cn/memory/thinkpad/"  # ThinkPad
    url_hp = "http://detail.zol.com.cn/memory/hp/"  # 惠普
    url_vaseky = "http://detail.zol.com.cn/memory/vaseky/"  # 威士奇
    url_teclast = "http://detail.zol.com.cn/memory/teclast/"  # 台电
    url_maxsun = "http://detail.zol.com.cn/memory/maxsun/"  # 铭瑄
    url_ju_hor = "http://detail.zol.com.cn/memory/ju-hor/"  # 玖合
    url_zhoujidz = "http://detail.zol.com.cn/memory/zhoujidz/"  # 盔甲
    url_dict = {
        '英睿达': url_yingruida,
        '影驰': url_galaxy,
        '阿斯加特': url_asgardasgard,
        '科斌': url_klevv,
        '海盗船': url_corsair,
        '瑞势': url_ramsta,
        '芝奇': url_gskill,
        '金泰克': url_kingtiger,
        '金邦科技': url_geil,
        '特科芯': url_tekism,
        '金士顿': url_kingston,
        '威刚': url_adata,
        '宇瞻': url_apacer,
        '三星': url_samsung,
        '现代': url_xian,
        'ThinkPad': url_thinkpad,
        '惠普': url_hp,
        '威士奇': url_vaseky,
        '台电': url_teclast,
        '铭瑄': url_maxsun,
        '玖合': url_ju_hor,
        '盔甲': url_zhoujidz
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
                    url = "http://detail.zol.com.cn/xhr4_Series_GetSeriesPro_isAjax=1%5EseriesId=" + str(seriesId) + "%5EmainId=396166%5EsubcateId=5%5Epage=" + str(page) + "%5EparamStr=.html"
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
                            url = "http://detail.zol.com.cn/memory/" + i['href'].split('/')[-1]
                            req = urllib.request.Request(url)
                            r = urllib.request.urlopen(req)
                            html = r.read().decode('gbk', errors='ignore')
                            soup = BeautifulSoup(html, 'html.parser')
                            id = uuid.uuid1()
                            brands = key#品牌名
                            name#系列名
                            model = idname  # 产品型号名
                            price = soup.select('.price-type')[0].get_text()  # 价格
                            img = soup.select('.big-pic')[0].find('img').get('src')
                            all_li = soup.select('.section-content')[0].find('ul').find_all('li')
                            applicable_type = all_li[0].find_all('p')[0].get_text().split("：")[1]  # 适用类型
                            memory_capacity = all_li[0].find_all('p')[1].get_text().split("：")[1]  # 内存容量
                            memory_type = all_li[1].find_all('p')[0].get_text().split("：")[1]  # 内存类型
                            main_frequency_of_memory = all_li[1].find_all('p')[1].get_text().split("：")[1]  # 内存主频
                            sql_select = "select * from memorybar where model = '{0}';".format(model)
                            sql_insert = "insert into memorybar(id,brands,name,model,price,applicable_type,memory_capacity,memory_type,main_frequency_of_memory,img) values('{0}', '{1}', '{2}', '{3}', '{4}', '{5}', '{6}', '{7}', '{8}','{9}');".format(id,brands,name,model,price,applicable_type,memory_capacity,memory_type,main_frequency_of_memory,img)
                            sql_update = "update memorybar set brands='{0}',name='{1}',model='{2}',price='{3}',applicable_type='{4}',memory_capacity='{5}',memory_type='{6}',main_frequency_of_memory='{7}' where model = '{8}';".format(brands,name,model,price,applicable_type,memory_capacity,memory_type,main_frequency_of_memory,model)
                            SQL_LIST.append(SQLStruct(sql_select, sql_insert, sql_update))
                        except Exception as e:
                            pass
        except Exception as e:
            pass
    print("内存条信息爬取完毕。")
    Config.Infos = Config.Infos + 1