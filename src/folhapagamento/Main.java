package folhapagamento;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


class ID implements Serializable {
    public int cargo;
    public Chefe chefe;
    public Vendedor vendedor;
    public PorPeca porpeca;
    public PorHora porhora;
}

public class Main implements Serializable {
    
    @SuppressWarnings("Convert2Diamond")
    public static ArrayList<ID> ids=new ArrayList<ID>();
    public static ID aux=new ID();
    public static int qtd;
    static Scanner in=new Scanner(System.in);
    
    public static void inic(){
        aux.chefe=new Chefe();
        aux.vendedor=new Vendedor();
        aux.porpeca=new PorPeca();
        aux.porhora=new PorHora();
        Vendedor.setPorvenda(10);
        PorPeca.setValorpeca(25);
        PorHora.setValorhora(7);
    }
    
    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch"})
    public static void leitor(){
        
        File arquivo;
        arquivo=new File("ids.txt");
        try{
            FileInputStream fin=new FileInputStream(arquivo);
            ObjectInputStream oin=new ObjectInputStream(fin);
            ids=(ArrayList<ID>) oin.readObject();
            oin.close();
            fin.close();
        }catch (Exception ex){
            System.err.println("erro na leitura de ids");
        }
        
        arquivo=new File("qtd.txt");
        try{
            FileInputStream fin=new FileInputStream(arquivo);
            ObjectInputStream oin=new ObjectInputStream(fin);
            qtd=(int) oin.readObject();
            oin.close();
            fin.close();
        }catch (Exception ex){
            System.err.println("erro na leitura de qtd");
        }
    }
    
    @SuppressWarnings("ConvertToTryWithResources")
    public static void gravador(){
        File  arquivo;
        arquivo=new File("ids.txt");
        try{
            FileOutputStream fout=new FileOutputStream(arquivo);
            ObjectOutputStream oos=new ObjectOutputStream(fout);
            oos.writeObject(ids);
            oos.flush();
            oos.close();
            fout.close();
            System.err.println("gravação de ids");
        }catch (Exception ex){
            System.err.println("erro na gravação de ids");
        }
        
        arquivo=new File("qtd.txt");
        try{
            FileOutputStream fout=new FileOutputStream(arquivo);
            ObjectOutputStream oos=new ObjectOutputStream(fout);
            oos.writeObject(qtd);
            oos.flush();
            oos.close();
            fout.close();
            System.err.println("gravação de qtd");
        }catch (Exception ex){
            System.err.println("erro na gravação de qtd");
        }
    }

    public static void main(String[] args) {
        //Empregado do tipo Chefe para teste
        //Chefe chefe=new Chefe("luis","0","0","0","0","0",5000,1);
        //System.out.println(chefe.CalcularGanhos());
        int sucesso=0;
        inic();
        leitor();
        new Login().setVisible(true);
    }
    
}
