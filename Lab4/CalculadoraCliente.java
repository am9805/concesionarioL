import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;

public class CalculadoraCliente{
    public static void main(String[] args){
        try {
            Calculadora c = (Calculadora);
            Naming.lookup("rmi://localhost")
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}