package com.server;

import org.hibernate.Hibernate;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by yjy on 16-9-24.
 */
public class MyTask implements Runnable {

    private Socket socket;

    public MyTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //连接成功，建立相应的I/O数据流
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            //在循环中，与客户机通信
            while (true) {
                String str = dis.readUTF();    //从客户机中读数据
                if (str.equals("end")) break;    //当读到end时，程序终止
                System.out.println(str);
                dos.writeUTF("Echoing:" + str);    //向客户机中写数据
            }
            dos.close();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
