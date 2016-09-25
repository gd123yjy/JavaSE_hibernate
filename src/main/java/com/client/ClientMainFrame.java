package com.client;

import javax.swing.*;
import java.awt.*;

/**
 * Created by yjy on 16-9-25.
 */
public class ClientMainFrame extends JFrame {
    private JButton connServerButton = null;
    private JButton sendRequestButton = null;
    private JTextField numberInput = null;
    private JTextArea resultArea = null;

    public ClientMainFrame() throws HeadlessException {
        //设置窗口边界
        this.setBounds(100,100,400,400);

        //初始化连接按钮
        connServerButton = new JButton("连接服务器");
        connServerButton.setBounds(150,150,180,200);
        this.getContentPane().add(connServerButton);

        //初始化提示信息
        JLabel label = new JLabel("输入学号");
        label.setBounds(200,150,250,200);
        this.add(label);

        //初始化发送按钮
        sendRequestButton = new JButton("发送");
        sendRequestButton.setBounds(250,150,300,200);
        this.add(sendRequestButton);

        //初始化查询输入框
        numberInput = new JTextField("2012006");
        numberInput.setBounds(100,100,250,150);
        this.add(numberInput);

        //初始化查询结果框
        resultArea = new JTextArea("这里将显示查询结果");
        resultArea.setBounds(100,200,400,400);
        this.add(resultArea);
    }
}
