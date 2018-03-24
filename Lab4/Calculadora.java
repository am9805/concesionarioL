public interface Calculadora extends java.rmi.Remote{
    public long sumar(long A,long B) throws java.rmi.RemoteException;
    public long restar(long A,long B) throws java.rmi.RemoteException;
    public long multiplicar(long A,long B) throws java.rmi.RemoteException;
    public long dividir(long A,long B) throws java.rmi.RemoteException;   
}