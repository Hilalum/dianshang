# 主板信息爬虫

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
    print(key, "的系列有：")
    req = urllib.request.Request(url_dict[key])
    r = urllib.request.urlopen(req)
    html = r.read().decode('gbk')
    soup = BeautifulSoup(html, 'html.parser')
    all_a = soup.find(id='J_SeriesFilter').find_all('div')[0].find_all('div')[0].find_all('a')
    for item in all_a:
        # 品牌为key
        name = item.get_text()  # 系列名称
        item_url = "http://detail.zol.com.cn/series/5/"+item.get('href').split('/')[-1]