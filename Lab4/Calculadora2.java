

/**
 *
 * @author alejandro
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.net.*;

public class Calculadora2 extends UnicastRemoteObject implements Calculadora{

    public long sumar(long A,long B) throws java.rmi.RemoteException{
        return A + B;
    }
    public long restar(long A,long B) throws java.rmi.RemoteException{
        return A - B;
    }
    public long multiplicar(long A,long B) throws java.rmi.RemoteException{
        return A * B;
    }
    public long dividir(long A,long B) throws java.rmi.RemoteException{
        return A / B;
    }
}
