package com.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by yjy on 16-9-25.
 */
public class ConnectionManager {
    private Socket ss;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ConnectionManager() {
    }

    public void conn() {
        //建立Socket，服务器在本机的8888端口处进行“侦听”
        try {
            ss = new Socket("127.0.0.1", 8888);
            //套接字建立成功，建立I/O流进行通信
            dis = new DataInputStream(ss.getInputStream());
            dos = new DataOutputStream(ss.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Socket:" + ss);

    }

    public void send(String number) throws Exception {
        dos.writeUTF(number);    //向服务器发数据
        dos.flush();            //刷新输出缓冲区，以便立即发送
    }


    public String read() {
        String result = null;
        try {
            //将从服务器接收的数据输出
            result = dis.readUTF();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void close() throws Exception {
        try {
            dos.writeUTF("end");        //向服务器发送终止标志
            dos.flush();                //刷新输出缓冲区，以便立即发送
            dos.close();
            dis.close();
        } finally {
            ss.close();
        }
    }
}
