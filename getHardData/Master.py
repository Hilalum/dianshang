# --------------------------------------------------------------
# --------------------------------------------------------------
# --------------------   分配管理节点   --------------------
# --------------------------------------------------------------
# --------------------------------------------------------------

import threading
from getCPUData import *
from getHarddickData import *
from getHarddickpData import *
from getMainBoardData import *
from getMemorybarData import *
from getPowerData import *
from getVideocardData import *
from WriteInMySql import *

THREADS = []

THREADS.append(threading.Thread(target=startToGetCPUData));
THREADS.append(threading.Thread(target=startToGetHarddickData));
THREADS.append(threading.Thread(target=startToGetHarddickpData));
THREADS.append(threading.Thread(target=startToGetMainBoardData));
THREADS.append(threading.Thread(target=startToGetMemorybarData));
THREADS.append(threading.Thread(target=startToGetPowerData));
THREADS.append(threading.Thread(target=startToGetVideocardData));
THREADS.append(threading.Thread(target=writeInMysql));

for t in THREADS:
    t.setDaemon(True);
    t.start();
for t in THREADS:
    t.join();