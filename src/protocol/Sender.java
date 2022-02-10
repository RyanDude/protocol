/** To just mimic ARQ, using socket programming **/
package protocol;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/** selective repeat + NACK signal **/
public class Sender {
    // the packet size of link layer is 1500 bytes including the headers and, etc.
    // assume each packet is 1400 bytes, since we need add sequence number
    // the sequence number will be added to the end of the packet
    // size == 1494 bytes, sequence number takes 6 bytes
    private Socket socket            = null;
    private static final String host = "192.168.0.145";
    private static final int port = 10086;
    private static final String packet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwx" +
            "yzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz" +
            "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzab" +
            "cdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd" +
            "efghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef" +
            "ghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh" +
            "ijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghij" +
            "klmnopqrstuvwxyzabcdefghijklmnopqrt";
    private int window_size = 0;
    private int start = 0;
    private String[] data;
    public Sender(int packet_num){
        // assume the window size is half of the number of packets
        // For selective repeat, the window size is half the maximum sequence number of the frame
        window_size = packet_num / 2;
        data = new String[packet_num];
        for(int i = 0; i < data.length; ++i){
            // add seq number to the end
            data[i] += (packet+i);
            System.err.println(data[i]);
        }

    }
    public void communicate(int packet_num)throws Exception{
    }
    public static void main(String[] args)throws Exception{
        Sender s = new Sender(5);
        s.communicate(5);
    }
}
