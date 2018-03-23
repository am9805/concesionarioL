import java.rmi.Naming;

public class CalculadoraServer{

    public CalculadoraServer(){
        try {
            Calculadora c = new Calculadora2();
            Naming.rebind("rmi://localhost:1099/CalculadoraService", c);
        } catch (Exception e) {
            System.out.println("Problema: "+ e);
        }
    }
}