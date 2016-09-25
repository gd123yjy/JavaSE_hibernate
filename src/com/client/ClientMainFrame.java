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

        //初始化发送按钮
        sendRequestButton = new JButton("发送");
        //初始化查询输入框
        numberInput = new JTextField("2012006");
        //初始化查询结果框
        resultArea = new JTextArea("这里将显示查询结果");
    }
}
