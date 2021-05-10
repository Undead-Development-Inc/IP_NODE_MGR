import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;


public class Console {

    public static void main(String[] args){
        while(true){
            try{
//                System.out.printf(Settings.RESET);
                DB_MGR.DB_GETIP();
                System.out.println("Please Enter A Command: \n");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String Req = bufferedReader.readLine();

                if(Req.matches("Status")){
                    GUI_IPSTATUS("192.168.1.1", "ACTIVE", Settings.GREEN_BOLD);

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
