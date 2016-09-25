package com.client;

import javax.swing.*;
import java.awt.event.*;

public class ClientFrame extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea resultTextArea;
    private JButton connServerButton;
    private JTextField requestParameterInput;
    private JButton sendRequestButton;

    private ConnectionManager connectionManager;

    public ClientFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        //初始化连接管理器
        connectionManager = new ConnectionManager();

        //连接服务器按钮
        connServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                connectionManager.conn();
            }
        });

        //发送按钮
        sendRequestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String number = requestParameterInput.getText();
                try {
                    connectionManager.send(number);
                    String result = connectionManager.read();
                    resultTextArea.setText(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void onOK() {
        // add your code here
        try {
            connectionManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        try {
            connectionManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        dispose();
    }

    public static void main(String[] args) {
        ClientFrame dialog = new ClientFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
