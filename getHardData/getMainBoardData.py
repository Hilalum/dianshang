# ------------------------------------------------------------
# ------------------------------------------------------------
# --------------------   主板信息爬虫   ----------------------
# ------------------------------------------------------------
# ------------------------------------------------------------

import uuid
import urllib.request
from bs4 import BeautifulSoup

url_asus = "http://detail.zol.com.cn/motherboard/asus/"               # 华硕
url_gigabyte = "http://detail.zol.com.cn/motherboard/gigabyte/"      # 技嘉
url_msi = "http://detail.zol.com.cn/motherboard/msi/"                 # msi微星
url_colorful = "http://detail.zol.com.cn/motherboard/colorful/"      # 七彩虹
url_biostar = "http://detail.zol.com.cn/motherboard/biostar/"        # 映泰
url_maxsun = "http://detail.zol.com.cn/motherboard/maxsun/"          # 铭瑄
url_soyo = "http://detail.zol.com.cn/motherboard/soyo/"              # 梅捷
url_onda = "http://detail.zol.com.cn/motherboard/onda/"               # 昂达
url_asrock = "http://detail.zol.com.cn/motherboard/asrock/"          # 华勤
url_galaxy = "http://detail.zol.com.cn/motherboard/galaxy/"          # 影驰
url_epox = "http://detail.zol.com.cn/motherboard/epox/"              # 磐正
url_sapphire = "http://detail.zol.com.cn/motherboard/sapphire/"      # 蓝宝石
url_xiangsheng = "http://detail.zol.com.cn/motherboard/xiangsheng/"  # ASL翔升
url_dict = {
    '华硕': url_asus,
    '技嘉': url_gigabyte,
    'MSI微星': url_msi,
    '七彩虹': url_colorful,
    '映泰': url_biostar,
    '铭瑄': url_maxsun,
    '梅捷': url_soyo,
    '昂达': url_onda,
    '华勤': url_asrock,
    '影驰': url_galaxy,
    '磐正': url_epox,
    '蓝宝石': url_sapphire,
    'ASL翔升': url_xiangsheng
}

for key in url_dict:
    req = urllib.request.Request(url_dict[key])
    r = urllib.request.urlopen(req)
    html = r.read().decode('gbk')
    soup = BeautifulSoup(html, 'html.parser')
    all_a = soup.find(id='J_SeriesFilter').find_all('div')[0].find_all('div')[0].find_all('a')
    for item in all_a:
        name = item.get_text()
        seriesId = item.get('href').split('/')[-1].split('.')[0].split('_')[0]
        page = 1
        while True:
            url = "http://detail.zol.com.cn/xhr4_Series_GetSeriesPro_isAjax=1%5EseriesId="+str(seriesId)+"%5EmainId=1210881%5EsubcateId=5%5Epage="+str(page)+"%5EparamStr=.html"
            page = page + 1
            req = urllib.request.Request(url)
            r = urllib.request.urlopen(req)
            html = r.read().decode('utf-8')
            if len(html)==60:
                break;
            soup = BeautifulSoup(html, 'html.parser')
            for i in soup.find_all('a'):
                try:
                    idname = i['title']
                    url = "http://detail.zol.com.cn/motherboard/"+i['href'].split('/')[-1]
                    req = urllib.request.Request(url)
                    r = urllib.request.urlopen(req)
                    html = r.read().decode('gbk', errors='ignore')
                    soup = BeautifulSoup(html, 'html.parser')
                    price = soup.select('.price-type')[0].get_text()
                    all_li = soup.select('.section-content')[0].find('ul').find_all('li')
                    # 获取数据
                    print(uuid.uuid1())  # uuid
                    print(key)  # 品牌名
                    print(name)  # 系列名
                    print(idname)  # 产品型号名
                    print(price)  # 价格
                    print(all_li[0].find_all('p')[0].get_text().split("：")[1])  # 主芯片组
                    print(all_li[0].find_all('p')[1].get_text().split("：")[1])  # 音频芯片
                    print(all_li[1].find_all('p')[0].get_text().split("：")[1])  # 内存类型
                    print(all_li[1].find_all('p')[1].get_text().split("：")[1])  # 最大内存容量
                    print(all_li[2].find_all('p')[0].get_text().split("：")[1])  # 主板版型
                    print(all_li[2].find_all('p')[1].get_text().split("：")[1])  # 外形尺寸
                    print(all_li[3].find_all('p')[0].get_text().split("：")[1])  # 电源插口
                    print(all_li[3].find_all('p')[1].get_text().split("：")[1])  # 供电模式
                    print()
		sql="'select model case when model=idname then (update mainboard set (brands,name,mode,ramnum,ssdnum,size,powernum,powermodel,cpumodel,cpunum) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s))else (insert into mainboard (brands,name,model,ramnum,ssdnum,size,powernum,powermodel,cpumodel,cpunum) values (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)) end from mainboard'% (key,name,idname,0,0,0,all_li[2].find_all('p')[1].get_text().split("：")[1],all_li[3].find_all('p')[0].get_text().split("：")[1],all_li[3].find_all('p')[1].get_text().split("：")[1],0,0)"

                except Exception as e:
                    pass
