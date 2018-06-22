# --------------------------------------------------------------
# --------------------------------------------------------------
# --------------------   普通硬盘信息爬虫   --------------------
# --------------------------------------------------------------
# --------------------------------------------------------------
import Config
import uuid
import urllib.request
from bs4 import BeautifulSoup
from Config import *

def startToGetHarddickpData():
    url_wd="http://detail.zol.com.cn/hard_drives/wd/"#西部数据
    url_seagate="http://detail.zol.com.cn/hard_drives/seagate/"#希捷
    url_toshiba="http://detail.zol.com.cn/hard_drives/toshiba/"#东芝
    url_hgst="http://detail.zol.com.cn/hard_drives/hgst/"#HGST
    url_dict = {
        "西部数据":url_wd,
        "希捷":url_seagate,
        "东芝":url_toshiba,
        "HGST":url_hgst
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
                        seriesId) + "%5EmainId=157890%5EsubcateId=2%5Epage=" + str(page) + "%5EparamStr=.html"
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
                            url = "http://detail.zol.com.cn/hard_drives/" + i['href'].split('/')[-1]
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
                            type = "普通"  # 类型
                            all_li = soup.select('.section-content')[0].find('ul').find_all('li')
                            applicable_type = all_li[0].find_all('p')[0].get_text().split("：")[1]
                            harddisk_size_p = all_li[0].find_all('p')[1].get_text().split("：")[1]
                            harddisk_capacity = all_li[1].find_all('p')[0].get_text().split("：")[1]
                            single_disk_capacity = all_li[1].find_all('p')[1].get_text().split("：")[1]
                            cache_p = all_li[2].find_all('p')[0].get_text().split("：")[1]
                            speed = all_li[2].find_all('p')[1].get_text().split("：")[1]
                            interface_type_p = all_li[3].find_all('p')[0].get_text().split("：")[1]
                            interface_rate = all_li[3].find_all('p')[1].get_text().split("：")[1]
                            sql_select = "select * from harddisk where model = '{0}';".format(model)
                            sql_insert = "insert into harddisk(id, brands, name, model, price, type, applicable_type, harddisk_size_p,harddisk_capacity ,single_disk_capacity,cache_p ,speed ,interface_type_p ,interface_rate, img) values('{0}','{1}','{2}','{3}','{4}','{5}','{6}','{7}','{8}','{9}','{10}','{11}','{12}','{13}','{14}');".format(
                                id, brands, name, model, price, type, applicable_type, harddisk_size_p,harddisk_capacity ,single_disk_capacity,cache_p ,speed ,interface_type_p ,interface_rate, img)
                            sql_update = "update harddisk set brands='{0}', name='{1}', model='{2}', price='{3}', type='{4}', applicable_type='{5}', harddisk_size_p='{6}', harddisk_capacity='{7}', single_disk_capacity='{8}', cache_p='{9}', speed='{10}', interface_type_p='{11}', interface_rate='{12}' where model='{13}';".format(
                                brands, name, model, price, type, applicable_type, harddisk_size_p, harddisk_capacity, single_disk_capacity, cache_p, speed, interface_type_p, interface_rate, model)
                            SQL_LIST.append(SQLStruct(sql_select, sql_insert, sql_update))
                        except Exception as e:
                            pass
        except Exception as e:
            pass
    print("普通硬盘数据爬取完毕。")
    Config.Infos = Config.Infos + 1