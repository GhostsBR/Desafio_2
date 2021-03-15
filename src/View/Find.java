/*
 * Copyright (c) 2010, Oracle. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * Neither the name of Oracle nor the names of its contributors
 *   may be used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package View;

import CustomExceptions.CustomException;
import Model.Coffee;
import Model.CoffeeDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class Find extends javax.swing.JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Creates new form Find */
    public Find() {
        initComponents();
    
        readJTablee();
    }

    public void readJTablee(){
        DefaultTableModel modelo = (DefaultTableModel) tbjEspaco.getModel();
        modelo.setRowCount(0);
                 
        CoffeeDAO cdao = new CoffeeDAO();
        
       
        
        try {
            for (Coffee coffee: cdao.getCoffees()){
                
                modelo.addRow(new Object[]{
                    coffee.getIdCoffee(), coffee.getNameCoffee()
                } );
            }   } catch (CustomException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
             
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        sala = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        aluno = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cadastrarAluno1 = new javax.swing.JButton();
        sala1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbjEspaco = new javax.swing.JTable();
        espacoPesquisado = new javax.swing.JTextField();
        btPesquisaEspaco = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Find");
        setMaximumSize(new java.awt.Dimension(873, 610));
        setMinimumSize(new java.awt.Dimension(873, 610));
        setPreferredSize(new java.awt.Dimension(873, 610));
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(54, 33, 89));

        sala.setBackground(new java.awt.Color(85, 65, 118));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("ESPAÇOS");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/WhatsApp Image 2021-03-12 at 17.26.12.jpeg"))); // NOI18N

        org.jdesktop.layout.GroupLayout salaLayout = new org.jdesktop.layout.GroupLayout(sala);
        sala.setLayout(salaLayout);
        salaLayout.setHorizontalGroup(
            salaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, salaLayout.createSequentialGroup()
                .add(31, 31, 31)
                .add(jLabel6)
                .add(33, 33, 33)
                .add(jLabel2)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        salaLayout.setVerticalGroup(
            salaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, salaLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .add(salaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(jLabel6))
                .add(24, 24, 24))
        );

        aluno.setBackground(new java.awt.Color(54, 33, 89));
        aluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alunoMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("PESSOAS");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/WhatsApp Image 2021-03-12 at 17.26.12.jpeg"))); // NOI18N

        org.jdesktop.layout.GroupLayout alunoLayout = new org.jdesktop.layout.GroupLayout(aluno);
        aluno.setLayout(alunoLayout);
        alunoLayout.setHorizontalGroup(
            alunoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(alunoLayout.createSequentialGroup()
                .add(33, 33, 33)
                .add(jLabel5)
                .add(30, 30, 30)
                .add(jLabel3)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        alunoLayout.setVerticalGroup(
            alunoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(alunoLayout.createSequentialGroup()
                .add(15, 15, 15)
                .add(alunoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel5)
                    .add(jLabel3))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        cadastrarAluno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/iconmonstr-friend-2-24.png"))); // NOI18N
        cadastrarAluno1.setText("CADASTRAR SALA");

        sala1.setBackground(new java.awt.Color(54, 33, 89));
        sala1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sala1MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("SALAS");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/WhatsApp Image 2021-03-12 at 17.26.12.jpeg"))); // NOI18N

        org.jdesktop.layout.GroupLayout sala1Layout = new org.jdesktop.layout.GroupLayout(sala1);
        sala1.setLayout(sala1Layout);
        sala1Layout.setHorizontalGroup(
            sala1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, sala1Layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(jLabel8)
                .add(33, 33, 33)
                .add(jLabel7)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sala1Layout.setVerticalGroup(
            sala1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, sala1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .add(sala1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel7)
                    .add(jLabel8))
                .add(24, 24, 24))
        );

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(sala, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(aluno, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .add(cadastrarAluno1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 159, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(50, 50, 50))
            .add(sala1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(114, 114, 114)
                .add(sala1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(sala, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(aluno, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(120, 120, 120)
                .add(cadastrarAluno1)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 270, 610);

        tbjEspaco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME"
            }
        ));
        jScrollPane1.setViewportView(tbjEspaco);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(270, 0, 600, 300);

        espacoPesquisado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espacoPesquisadoActionPerformed(evt);
            }
        });
        getContentPane().add(espacoPesquisado);
        espacoPesquisado.setBounds(480, 400, 220, 30);

        btPesquisaEspaco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/lupaPreta (1).png"))); // NOI18N
        getContentPane().add(btPesquisaEspaco);
        btPesquisaEspaco.setBounds(720, 400, 40, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("NOME");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(410, 400, 50, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alunoMouseClicked
        // TODO add your handling code here:
        new Aluno().setVisible(true);
        dispose();
        
        
    }//GEN-LAST:event_alunoMouseClicked

    private void espacoPesquisadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espacoPesquisadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_espacoPesquisadoActionPerformed

    private void sala1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sala1MouseClicked
        // TODO add your handling code here:
        new UserView().setVisible(true);
        dispose();
    }//GEN-LAST:event_sala1MouseClicked
    
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
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels=javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx=0; idx<installedLookAndFeels.length; idx++)
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Find.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Find().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aluno;
    private javax.swing.JButton btPesquisaEspaco;
    private javax.swing.JButton cadastrarAluno1;
    private javax.swing.JTextField espacoPesquisado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel sala;
    private javax.swing.JPanel sala1;
    private javax.swing.JTable tbjEspaco;
    // End of variables declaration//GEN-END:variables
    
}
