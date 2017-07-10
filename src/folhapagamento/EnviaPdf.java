package folhapagamento;

import static folhapagamento.Main.envia;
import static folhapagamento.Main.idaux;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EnviaPdf extends Thread {
    
    public synchronized void envia() throws InterruptedException, FileNotFoundException, IOException{
        while(true){
            sleep(200);
            if(envia==1){
                System.out.println("Começando envio...");
                //codigo de envio
		File f = new File("pdf/"+ idaux +".pdf");
		FileInputStream in = new FileInputStream(f);
		Socket socket = new Socket("localhost", 12345);
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter writer = new BufferedWriter(osw);
		writer.write(f.getName() + "\n");
		writer.flush();
		int tamanho = 2048; // buffer de 4KB  
                byte[] buffer = new byte[tamanho];  
                int lidos = -1;  
                while ((lidos = in.read(buffer, 0, tamanho)) != -1) {  
                    out.write(buffer, 0, lidos);  
                } 
                System.out.println("enviou");
                out.close();
                out.flush();
                envia=0;
            }
        }
    }

    @Override
    public void run(){
        try {
            envia();
        } catch (InterruptedException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(EnviaPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
