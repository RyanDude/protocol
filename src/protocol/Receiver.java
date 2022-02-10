package protocol;
// basic idea about how to solve the problem
// receive packets in order
// if receive [pk1, pk2, pk4] -> pk3 is lost -> buffer the current window -> send the NACK

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

// another thing is the app still uses socket, socket is NOT TCP/IP, it is just an API of the system.
public class Receiver {
    // receive the packets from router
    public void R(){

    }
    public static void main(String[] args){
        Receiver r = new Receiver();
        r.R();
    }
}
