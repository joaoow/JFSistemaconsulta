/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;


import controle.PacienteControle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.Paciente;

/**
 *
 * @author joao
 */
public class FormListaPaciente extends javax.swing.JFrame {

    /**
     * Creates new form FormLista
     */
    public FormListaPaciente() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListarPaciente = new javax.swing.JTable();
        btnVoltar2 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblListarPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nome Completo", "Identidade", "CPF", "Data de Nascimento", "Sexo", "Telefone", "Data Cadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListarPaciente);
        if (tblListarPaciente.getColumnModel().getColumnCount() > 0) {
            tblListarPaciente.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        btnVoltar2.setText("Voltar");
        btnVoltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar2ActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVoltar2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar2)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        List<Paciente> pac = PacienteControle.ListarPaciente();
        DefaultTableModel dtmPaciente = (DefaultTableModel) tblListarPaciente.getModel();

        for (Paciente p : pac) {

            String formato = "dd/MM/yyyy";
            DateFormat dateFormat = new SimpleDateFormat(formato);

            String[] dados = {String.valueOf(p.getId()),
                p.getNomeCompleto(),
                p.getNumIdent(),
                p.getCpf(),
                dateFormat.format(p.getDataNascimento()),
                p.getSexo(),
                "("+p.getDdd() + ") " + p.getTelefone(),
                dateFormat.format(p.getDataCadastro()),
            };
            dtmPaciente.addRow(dados);
        }
        tblListarPaciente.setModel(dtmPaciente);
    }//GEN-LAST:event_formWindowOpened

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltar2ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int pac = Integer.parseInt(tblListarPaciente.getValueAt(this.tblListarPaciente.getSelectedRow(), 0).toString());
        Boolean apagou = PacienteControle.Excluir(pac);

        
        if (apagou == true) { 

          getRecarregarLista();
                    
            JOptionPane.showMessageDialog(null,
                    "Paciente Removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Houve um erro na remoção do Paciente!");
        }
       
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void getRecarregarLista() {

        this.limpaTabela();
        List<Paciente> pac = PacienteControle.ListarPaciente();
        DefaultTableModel dtmPaciente = (DefaultTableModel) tblListarPaciente.getModel();

        for (Paciente p : pac) {

            String formato = "dd/MM/yyyy";
            DateFormat dateFormat = new SimpleDateFormat(formato);

            String[] dados = {String.valueOf(p.getId()),
                p.getNomeCompleto(),
                p.getNumIdent(),
                p.getCpf(),
                dateFormat.format(p.getDataNascimento()),
                p.getSexo(),
                "("+p.getDdd() + ") " + p.getTelefone(),
                dateFormat.format(p.getDataCadastro()),
            };
            dtmPaciente.addRow(dados);
        }
        tblListarPaciente.setModel(dtmPaciente);
    }
    public void limpaTabela() {
        DefaultTableModel tblRemove = (DefaultTableModel) tblListarPaciente.getModel();
        int tamanho = tblRemove.getRowCount();
        if (tamanho > 0) {
            for (int i = tamanho - 1; i >= 0; i--) {
                tblRemove.removeRow(i);
            }
        }
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormListaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormListaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormListaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormListaPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormListaPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListarPaciente;
    // End of variables declaration//GEN-END:variables
}
