public class main {

    public static void main(String[] args){
        Thread Network = new Thread(Net::IPNet);
        Thread NMGR = new Thread(Net::NodeMgr);
        NMGR.start();
        Network.start();
    }
}
