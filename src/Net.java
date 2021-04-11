import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Net {

    public static ArrayList<String> IPs = new ArrayList<>();
    public static ArrayList<String> TEMP_IPs = new ArrayList<>();

    public static void IPNet(){
        while(true) {
            try {
                System.out.println("STARTING IP NODE MANAGER");
                System.out.println("WAITING FOR CONNECTION!");
                ServerSocket serverSocket = new ServerSocket(2000);
                Socket socket = serverSocket.accept();
                System.out.println("GOT CONNECTION FROM: " + socket.getInetAddress().toString());

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                if(!IPs.contains(socket.getInetAddress().toString())){
                    IPs.add(socket.getInetAddress().toString());
                }

                for(String IP: IPs){
                    if(!IP.matches(socket.getInetAddress().toString())){
                        TEMP_IPs.add(IP);
                    }
                }
                objectOutputStream.writeObject(TEMP_IPs);
                objectOutputStream.close();
                socket.close();
                serverSocket.close();

            } catch (Exception ex) {

            }
        }
    }
}
