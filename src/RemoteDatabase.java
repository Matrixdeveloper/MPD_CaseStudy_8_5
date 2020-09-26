import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteDatabase extends Remote {
    public int read() throws RemoteException;
    public void write(int value) throws  RemoteException;
}
