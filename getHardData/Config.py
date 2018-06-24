# 储存sql语句的结构体类
class SQLStruct:
    # 储存查询语句
    select = "";
    # 储存插入语句
    insert = "";
    # 储存更新语句
    update = "";
    def __init__(self, s, i, u):
        self.select = s;
        self.insert = i;
        self.update = u;

# 储存sql语句的列表
SQL_LIST = []

# 程序是否能结束的标志
Infos = 0