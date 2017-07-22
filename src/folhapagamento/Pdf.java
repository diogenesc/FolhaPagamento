package folhapagamento;

import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import static com.itextpdf.text.pdf.PdfName.U;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;


public class Pdf {
    
    Pdf(int id,String nome, String cpf, String rg, String funcao, String cargo, Float salarioBase){
        // criação do documento
        Document document = new Document();
        // formatação da data
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        df.setLenient (false);
        // formatação da hora
        DateFormat hf = DateFormat.getTimeInstance();
        //criando data e hora
        Date dataHora = new Date();
        String data=df.format(dataHora);
        String hora=hf.format(dataHora);
        
        
        
        try {

            PdfWriter.getInstance(document, new FileOutputStream("pdf/"+id+".pdf"));
            document.open();
                        
            //Criando Tabela
            PdfPTable table = new PdfPTable(new float [] { 2.0f, 2.0f });
            table.setWidthPercentage (90.0f);
            
            //Células
            //1
            PdfPCell cell = new PdfPCell(new Paragraph("FOLHA DE PAGAMENTO\n"+data+" "+hora));
            cell.setColspan (2);
            //Alinhamento Texto
            cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            //Cor do Fundo
            cell.setBackgroundColor(BaseColor.GRAY);
            //Cor da Borda
            cell.setBorderColor(BaseColor.WHITE);
            cell.setPadding (10.0f);
            table.addCell(cell);
            
            //2
            cell = new PdfPCell (new Paragraph ("Centro Universitário Norte do Espírito Santo, São Mateus - ES"));
            cell.setColspan (2);
            cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            cell.setBorderColor(BaseColor.WHITE);
            cell.setPadding (8.0f);
            table.addCell(cell);

            cell = new PdfPCell (new Paragraph ("NOME: "+nome));
            cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            cell.setPadding (5.0f);
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph ("CPF: "+cpf));
            cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            cell.setPadding (5.0f);
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph ("RG: "+rg));
            cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            cell.setPadding (5.0f);
            table.addCell (cell);

            cell = new PdfPCell (new Paragraph ("CARGO: "+cargo));
            cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            cell.setPadding (5.0f);
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph ("FUNÇÃO: "+funcao));
            cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            cell.setPadding (5.0f);
            table.addCell (cell);
            
            cell = new PdfPCell (new Paragraph ("SALÁRIO BASE: "+salarioBase));
            cell.setHorizontalAlignment (Element.ALIGN_CENTER);
            cell.setPadding (5.0f);
            table.addCell (cell);
           
          
            //Adicionando a Tabela ao Documento PDF
            document.add(table);
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        document.close();
        
    }
    
}
