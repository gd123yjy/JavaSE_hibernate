package com.server;

import com.service.BussinessLogicService;
import com.service.imp.StudentServiceImp;
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
    private BussinessLogicService service = new StudentServiceImp();

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

                //实现业务逻辑
                System.out.println(str);
                try {
                    str = service.getStudentInfoByNumber(str);
                }catch (Exception e){
                    str = "不存在该学生的信息！";
                }
                dos.writeUTF(str);    //向客户机中写数据
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
