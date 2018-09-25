package com.hsnn.util;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class test {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("116.53.226.54", 10091);
        // 向服务端程序发送数据
        OutputStream ops = socket.getOutputStream();
        OutputStreamWriter opsw = new OutputStreamWriter(ops);
        BufferedWriter bw = new BufferedWriter(opsw);

        bw.write("success!");
        bw.flush();
        bw.close();
    }
}
