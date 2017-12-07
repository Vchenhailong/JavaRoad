package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author hailongchen
 * Date: 2017-12-06
 * Time: 16:19
 */
public class CustomizeScoketClient {

    private SocketAddress socketAddress;

    private static final int PORT = 7516;

    public void send() throws IOException {
        Socket socket = new Socket("localhost",PORT);

        OutputStream out = socket.getOutputStream();

        PrintWriter writer = new PrintWriter(out);

        writer.print("hello world");
        writer.flush();
        socket.shutdownOutput();

        writer.close();
        out.close();
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        CustomizeScoketClient client = new CustomizeScoketClient();
        client.send();
    }


}
