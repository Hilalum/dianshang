# --------------------------------------------------------------
# --------------------------------------------------------------
# --------------------   CPU信息爬虫   -------------------------
# --------------------------------------------------------------
# --------------------------------------------------------------
import Config
import uuid
import urllib.request
from bs4 import BeautifulSoup
from Config import *

def startToGetCPUData():
    url_intel = "http://detail.zol.com.cn/cpu/intel/"  # Intel
    url_amd = "http://detail.zol.com.cn/cpu/amd/"  # AMD
    url_dict = {
        "Intel": url_intel,
        "AMD": url_amd
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
                        seriesId) + "%5EmainId=381245%5EsubcateId=28%5Epage=" + str(page) + "%5EparamStr=.html"
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
                            url = "http://detail.zol.com.cn/cpu/" + i['href'].split('/')[-1]
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
                            applicable_type = all_li[0].find_all('p')[0].get_text().split("：")[1]  # 适用类型
                            cpu_series = all_li[0].find_all('p')[1].get_text().split("：")[1]  # CPU系列
                            cpu_main_frequency = all_li[1].find_all('p')[0].get_text().split("：")[1]  # CPU主频
                            ghz = all_li[1].find_all('p')[1].get_text().split("：")[1]  # 最大睿频
                            slot_type = all_li[2].find_all('p')[0].get_text().split("：")[1]  # 插槽类型
                            two_level_caching = all_li[2].find_all('p')[1].get_text().split("：")[1]  # 二级缓存
                            core_quantity = all_li[3].find_all('p')[0].get_text().split("：")[1]  # 核心数量
                            thread_number = all_li[3].find_all('p')[1].get_text().split("：")[1]  # 线程数
                            sql_select = "select * from cpu where model = '{0}';".format(model)
                            sql_insert = "insert into cpu(id,brands,name,model,price,applicable_type,cpu_series,cpu_main_frequency,ghz,slot_type,two_level_caching,core_quantity,thread_number,img) values('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}','{11}','12','{13}');".format(id,brands,name,model,price,applicable_type,cpu_series,cpu_main_frequency,ghz,slot_type,two_level_caching,core_quantity,thread_number,img)
                            sql_update = "update cpu set brands='{0}',name='{1}',model='{2}',price='{3}',applicable_type='{4}',cpu_series='{5}',cpu_main_frequency='{6}',ghz='{7}',slot_type='{8}',two_level_caching='{9}',core_quantity='{10}',thread_number='{11}' where model = '{12}';".format(brands,name,model,price,applicable_type,cpu_series,cpu_main_frequency,ghz,slot_type,two_level_caching,core_quantity,thread_number,model)
                            SQL_LIST.append(SQLStruct(sql_select, sql_insert, sql_update))
                        except Exception as e:
                            pass
        except Exception as e:
            pass
    print("CPU信息爬取完毕。")
    Config.Infos = Config.Infos + 1