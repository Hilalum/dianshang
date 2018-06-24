package com.zhgy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSession {
    private static Session session = null;

    public static Session getSession(){
        if(session != null){ return session; }
        Configuration conf = new Configuration().configure();
        SessionFactory sf = conf.buildSessionFactory();
        session = sf.openSession();
        return session;
    }

    public static void closeSession(){
        if(session != null){
            session.close();
        }
    }
}
