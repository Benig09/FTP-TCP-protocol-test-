package alpassignment;
import java.net.* ;
import java.io.* ; 
public class ServerSide extends Thread {
    private ServerSocket serverSocket ; 
    public ServerSide(int port) throws IOException { 
        serverSocket = new ServerSocket (port) ; 
        serverSocket.setSoTimeout(10000) ;
    }   
    public void run () { 
        while(true){ 
            try{ 
                System.out.println("Waiting for client on port" + serverSocket.getLocalPort() +" ... ");
                Socket server = serverSocket.accept() ;
                System.out.println("Connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream()) ;
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream()); 
FileInputStream fr = new FileInputStream("D:\\UCSI\\May 2019 Semester\\CM315 Application Layer Programming\\Assignment\\test.txt");
                byte b[] = new byte[2002];
                fr.read(b, 0, b.length);
                OutputStream os = server.getOutputStream();
                os.write(b, 0, b.length);
                out.writeUTF("Thanks for connecting to " + server.getLocalSocketAddress() + "\nGoodbye") ; 
                server.close();            
            }catch (SocketTimeoutException s) {
                System.out.println("Socket time out"); 
                break ; 
            }catch (IOException e){ 
                e.printStackTrace();
                break ; 
            }
        }
    }
    public static void main(String[] args) { 
        int port = 4333 ; 
        try { 
            Thread t = new ServerSide(port) ; 
            t.start() ; 
        }catch (IOException e) { 
            e.printStackTrace() ; 
        }
    }
