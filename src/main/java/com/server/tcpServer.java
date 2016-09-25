package com.server;

import com.hibernateUtils.DBCreator;
import com.hibernateUtils.HibernateLoader;

import java.io.*;
import java.net.*;

public class tcpServer {
    public static final int PORT = 8888;

    public static void main(String[] args) throws IOException {
        //初始化数据库
        try {
            DBCreator.main(null);
        }catch (Exception e){
            System.out.println("您的数据库配置有误，请检查是否有mysql/my_cs_db并开启了mysql服务");
        }
        //建立ServerSocket
        ServerSocket s = new ServerSocket(PORT);
        System.out.println("ServerSocket:" + s);
        //构造客户端管理器
        ClientManager clientManager = new ClientManager();
        while (true){
            /*程序阻塞,等待连接。即直到有一个客户请求到达,程序方能继续执行*/
            Socket ss = s.accept();
            System.out.println("Socket accept:" + ss);
            //构造客户端管理器
            clientManager.server(ss);
        }
    }
}
