import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Net {

    public static ArrayList<String> IPs = new ArrayList<>();
    public static ArrayList<String> TEMP_IPs = new ArrayList<>();

    public static void IP_STATUS(){
        while(true) {
            try {
                for(String IP: IPs){
                    TEMP_IPs.add(IP);
                    Socket socket = new Socket(IP, 10000);
                    TEMP_IPs.remove(IP);
                    socket.close();
                }

                for(String NRIP: TEMP_IPs){
                    IPs.remove(NRIP);
                    DB_MGR.DB_UPDATEIP_STATUS(NRIP, DB_MGR.DB_GETIP_VER(NRIP), false);
                }

            } catch (Exception ex) {

            }
        }
    }



}
