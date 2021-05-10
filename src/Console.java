public class Console {

    public static void main(String[] args){
        while(true){
            try{
                GUI();

            }catch (Exception ex){
                System.out.println("ERROR: " + ex);
            }
        }
    }

    public static void GUI(){
        System.out.println(String.format("%-20s", "Hello"));

    }
}
