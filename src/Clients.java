import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class Clients {
    public static void main(String[] args) {
        try{
            // set the standard RMI security manager
            System.setProperty("java.security.policy", "file:./security.policy");
            System.setSecurityManager(new RMISecurityManager());
            // get remote database object
            String name = "rmi://localhost:9999/database";
            RemoteDatabase db = (RemoteDatabase) Naming.lookup(name);
            // read command-line argument and access database
            int value, rounds = Integer.parseInt(args[0]);
            for(int i=0; i<rounds;i++){
                value = db.read();
                System.out.println("read: "+value);
                db.write(value+1);
            }
        } catch (Exception e){
            System.err.println(e);

        }

    }
}
