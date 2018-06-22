# --------------------------------------------------------------
# --------------------------------------------------------------
# --------------------   将数据写入数据库   --------------------
# --------------------------------------------------------------
# --------------------------------------------------------------
import Config
from Config import *
import time
import pymysql

def writeInMysql():
    insert = 0
    update = 0
    error = 0
    try:
        conn = pymysql.connect(host='localhost', port=3306, user='root', passwd='root', db='afds', charset='utf8')
        cur = conn.cursor()
    except:
        print("数据库链接失败。")
        return
    while True:
        if len(SQL_LIST) == 0:
            time.sleep(5)
            continue
        _ret = SQL_LIST.pop(0);
        try:
            cur.execute(_ret.select)
            row = cur.fetchone()
            if row == None:
                insert = insert + 1
                cur.execute(_ret.insert)
            else:
                update = update + 1
                cur.execute(_ret.update)
            conn.commit()
            print("当前插入数据:",insert,"条。更新数据:",update,"条。出错:",error,"条。当前结束信号量:",Config.Infos)
        except:
            print("数据出错")
            error = error + 1
        if len(SQL_LIST) == 0 and Config.Infos == 7:
            break
    cur.close()
    conn.close()
    print("写入数据库完毕。")