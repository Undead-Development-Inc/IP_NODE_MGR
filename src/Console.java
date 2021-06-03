import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;


public class Console {

    public static void main(String[] args){
        while(true){
            try{
//                System.out.printf(Settings.RESET);
                Thread Status_IP = new Thread(Net::IP_STATUS);
                Status_IP.start();
                System.out.println("Please Enter A Command: \n");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String Req = bufferedReader.readLine();

                if(Req.matches("ADD_NODE")){
                    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String Node_IP = bufferedReader.readLine();
                    DB_MGR.DB_SETIP(Node_IP, 1.0);
                    System.out.println("ADDED NODE: "+ Node_IP);
                }
                if(Req.matches("Status")){
                    Net.IP_GUI();
                }
                if(Req.matches("Commands")){
                    System.out.println("COMMANDS: \n");
                    System.out.println(Settings.WHITE + "'ADD_NODE'  --ADD NODE IP MANUALLY");
                    System.out.println(Settings.WHITE + "'Status'  --PROVIDES STATUS OF NODES \n \n");
                }
                if(Req.matches("CHECK_IP")){
                    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    String Node_IP = bufferedReader.readLine();
                    Net.IP_CHECKACTIVE(Node_IP);
                }

            }catch (Exception ex){
                System.out.println("ERROR: " + ex);
            }
        }
    }

    public static void GUI_IPSTATUS(String IP, String STATUS, String color){
        String format = "%2$-10s  ||%3$-20s "+ color + "\n";
        System.out.format(format, "IP:", IP, STATUS);
        System.out.println(Settings.RESET);

        return;

    }
}
