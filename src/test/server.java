package test;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server extends Thread{
    // 192.168.0.145
    ServerSocket server = null;
    Socket socket = null;


    //函数入口
    public static void main(String[] args) {
        Socket s= null;
        DataInputStream dis=null;
        DataOutputStream out = null;
        int cnt = 0;
        // port 5000
        try{
            ServerSocket ss=new ServerSocket(5000);
            while(cnt < 4){
                s=ss.accept();//establishes connection
                dis=new DataInputStream(s.getInputStream());
                out = new DataOutputStream(s.getOutputStream());
                String  str=(String)dis.readUTF();
                System.out.println("message= "+str);
                out.writeUTF("message from host A"+str);
                out.flush();
            }
            ss.close();
        }catch(Exception e){System.out.println(e);}
    }
}
