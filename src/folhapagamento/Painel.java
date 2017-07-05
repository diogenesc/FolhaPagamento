/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folhapagamento;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author diogenes
 */
public class Painel extends javax.swing.JFrame {

    /**
     * Creates new form Painel
     */
    public Painel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bCadastro = new javax.swing.JButton();
        bGerarFolha = new javax.swing.JButton();
        bZerar = new javax.swing.JButton();
        bCadastraVencimentos = new javax.swing.JButton();
        bMostrarInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel1.setText("Folha de Pagamento");

        bCadastro.setText("Cadastrar empregado");
        bCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastroActionPerformed(evt);
            }
        });

        bGerarFolha.setText("Gerar folha de pagamento");
        bGerarFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGerarFolhaActionPerformed(evt);
            }
        });

        bZerar.setText("Zerar programa");
        bZerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bZerarActionPerformed(evt);
            }
        });

        bCadastraVencimentos.setText("Cadastrar vencimentos");
        bCadastraVencimentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastraVencimentosActionPerformed(evt);
            }
        });

        bMostrarInfo.setText("Mostrar infos de empregado");
        bMostrarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMostrarInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(bCadastro)
                    .addComponent(jLabel1)
                    .addComponent(bGerarFolha)
                    .addComponent(bZerar)
                    .addComponent(bCadastraVencimentos)
                    .addComponent(bMostrarInfo))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(bCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bMostrarInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bCadastraVencimentos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bGerarFolha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bZerar)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastroActionPerformed
        // TODO add your handling code here:
        Cadastro cadastro=new Cadastro();
        cadastro.setVisible(true);
    }//GEN-LAST:event_bCadastroActionPerformed

    private void bZerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bZerarActionPerformed
        // TODO add your handling code here:
        Main.ids.clear();
        Main.qtd=0;
        Main.gravador();
        JOptionPane.showMessageDialog(null, "Dados excluidos");
    }//GEN-LAST:event_bZerarActionPerformed

    private void bCadastraVencimentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastraVencimentosActionPerformed
        // TODO add your handling code here:
        Vencimentos venc=new Vencimentos();
        venc.setVisible(true);
    }//GEN-LAST:event_bCadastraVencimentosActionPerformed

    private void bGerarFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGerarFolhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bGerarFolhaActionPerformed

    private void bMostrarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMostrarInfoActionPerformed
        // TODO add your handling code here:
        int qual=Integer.parseInt(JOptionPane.showInputDialog("Digite o id do funcionario"));
        System.err.println(qual);
        if(qual>=0 && Main.qtd>0){
            int auxcargo=Main.ids.get(qual).cargo;
            switch(auxcargo){
                case 1:
                    JOptionPane.showMessageDialog(null, Main.ids.get(qual).chefe.getDados()+"\nCargo: Chefe", "Dados", 1);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, Main.ids.get(qual).vendedor.getDados()+"\nCargo: Vendedor", "Dados", 1);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, Main.ids.get(qual).porpeca.getDados()+"\nCargo: Ganha por peça", "Dados", 1);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, Main.ids.get(qual).porhora.getDados()+"\nCargo: Ganha por hora", "Dados", 1);
                    break;
                default:
                    break;
            }
        }
        else JOptionPane.showMessageDialog(null, "Empregado nao existe");
    }//GEN-LAST:event_bMostrarInfoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Painel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Painel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCadastraVencimentos;
    private javax.swing.JButton bCadastro;
    private javax.swing.JButton bGerarFolha;
    private javax.swing.JButton bMostrarInfo;
    private javax.swing.JButton bZerar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}