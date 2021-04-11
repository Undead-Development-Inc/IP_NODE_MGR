public class main {

    public static void main(String[] args){
        Thread Network = new Thread(Net::IPNet);
        Network.start();
    }
}
