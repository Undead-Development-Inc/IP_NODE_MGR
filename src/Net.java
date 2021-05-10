import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.NoRouteToHostException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Net {

    public static ArrayList<String> IPs = new ArrayList<>();
    public static ArrayList<String> TEMP_IPs = new ArrayList<>();

    public static void IP_STATUS(){ //CHECKS IF NODE IS ALIVE
        while(true) {
            try {
                DB_MGR.DB_GETIP();
                for(String IP: IPs){
//                    System.out.println("GOT IP: "+ IP);
                    TEMP_IPs.clear();
                    TEMP_IPs.add(IP);
                    Socket socket = new Socket(IP, 10000);
                    socket.setSoTimeout(1);
//                    System.out.println("PASSED");
                    TEMP_IPs.remove(IP);
                    socket.close();
                }



            } catch (Exception ex) {
                ArrayList<String> BAD = new ArrayList<>();
                for(String NRIP: TEMP_IPs){ //NRIP --NON RESPONCIVE IP
//                    System.out.println("Removing IP: "+ NRIP);
                    BAD.add(NRIP);
                    DB_MGR.DB_UPDATEIP_STATUS(NRIP, DB_MGR.DB_GETIP_VER(NRIP), false);
                }
                IPs.removeAll(BAD);

            }
        }
    }

    public static void IP_GUI(){
        try{
            for(String IP: IPs){
                String color = "";
                if(DB_MGR.DB_GETIP_STATUS(IP)){
                    color = Settings.GREEN_BOLD;
                }else {
                    color = Settings.RED;
                }
                String format = "%2$-10s  ||%3$-20s "+ color + "\n";
                System.out.format(format, "IP:", IP, DB_MGR.DB_GETIP_STATUS(IP));
                System.out.print(Settings.RESET);
            }
        }catch (Exception ex){

        }
    }



}
