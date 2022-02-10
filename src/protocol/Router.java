package protocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
/** NAT to transfer IP **/
/** local IP = 192.168.0.145 **/
// since all three apps are running on the same desktop, the host will be same, but the port will be different.
// the application will still mimic the function of the router.
public class Router {
    // NAT table
    // [LAN IP] [LAN PORT] [WAN IP] [WAN PORT]
    // assigned IP 192.168.0.145
    // the packet sent to router will be 1494 + 6 bytes, including 747 characters of payload and header, 6 bytes for sequence number.
    // drop probability  = (0+X) * 0.001, suppose X = 5
    private Socket          socket   = null;
    private ServerSocket    server   = null;
    private DataInputStream in       =  null;
    private static final int probability = 5;
    // NAT table structure
    /**
     * private ip & port | public ip & port
     * format: String "ip:port"
     **/
    private Map<String, String> map = new HashMap<>();
    // assume subnet 192.168.0/24
    private static final int[] mask = new int[]{255, 255, 255, 0};
    public Router(){
    }
    // packet drop/lost/corrupted probability is 0.5%
    public boolean packet_drop() {
        return Math.random()*1000 <= probability;
    }
    public void communicate()throws Exception{
    }
    public static void main(String[] args)throws Exception{
        Router r = new Router();
        r.communicate();
        System.err.println();
    }
}
