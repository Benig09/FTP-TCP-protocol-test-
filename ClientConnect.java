package alpassignment;
import java.net.*;
import java.io.*;
public class ClientConnect {
    public static void main(String[] args) {
        int port = 4333;
        try {
            System.out.println("Connecting to server" + " on port " + port);
            Socket client = new Socket("localhost", port);
            System.out.println("Connected" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);           
            System.out.println("Connecting to server" + " on port " + port);
            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            byte b[] = new byte[2002];
            InputStream is = client.getInputStream();
           FileOutputStream fr = new FileOutputStream("D:\\UCSI\\May 2019 Semester\\CM315 Application Layer
           Programming\\Assignment\\newTest.txt");       
            is.read(b, 0, b.length);
            fr.write(b, 0, b.length);
            System.out.println("Server says" + in.readUTF());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
