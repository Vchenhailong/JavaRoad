package utils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * Description:socket通信服务端
 *
 * @author hailongchen
 * Date: 2017-12-06
 * Time: 16:11
 */
public class CustomizeSocketServer {

    private static final int SERVPORT = 7516;

    /**
     * Description: TCP通信的服务端
     *
     * @return
     * @author hailongchen
     * Date: ${YEAR}-${MONTH}-${DAY}
     * Time: ${TIME}
     */
    public void conn() throws IOException {
        //创建ServerSocket服务
        ServerSocket serv = new ServerSocket(SERVPORT);
        //创建通道，等待连接
        Socket socket = serv.accept();
        System.out.println("已创建连接");

        //---> 交换数据
        //定义服务端接收的数据
        InputStream in = socket.getInputStream();
        //定义服务端返回的数据内容
        OutputStream out = socket.getOutputStream();
        //加入缓冲区
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(out);
        //读写数据
        byte[] bytes = new byte[1];
        int b;
        while ((b = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {
            bufferedOutputStream.write(bytes, 0, b);
            bufferedOutputStream.flush();
            String s = new String(bytes, 0, bytes.length);

            System.out.println("读取一个字节，其内容是：" + s);
            System.out.println("交换数据中...");

        }

        System.out.println("完成数据交换");


        // 交换数据完成   <---


        //关闭通道
        socket.shutdownInput();
        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serv.close();
        System.out.println("关闭连接");

    }

    public static void main(String[] args) throws IOException {
        CustomizeSocketServer server = new CustomizeSocketServer();
        server.conn();
    }
}

