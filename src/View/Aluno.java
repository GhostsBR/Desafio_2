/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Administrador
 */
public class Aluno extends javax.swing.JFrame {

    /**
     * Creates new form Aluno
     */
    public Aluno() {
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
        tabelaAluno = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        sala3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_eventos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        aluno3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cadastrarAluno = new javax.swing.JButton();
        cadastrarAluno1 = new javax.swing.JButton();
        lupaPesquisarAluno = new javax.swing.JButton();
        nomePesquisado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMaximumSize(new java.awt.Dimension(873, 610));
        setMinimumSize(new java.awt.Dimension(873, 610));
        setPreferredSize(new java.awt.Dimension(873, 610));
        getContentPane().setLayout(null);

        tabelaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaAluno.setMaximumSize(new java.awt.Dimension(870, 610));
        tabelaAluno.setMinimumSize(new java.awt.Dimension(870, 610));
        jScrollPane1.setViewportView(tabelaAluno);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(270, 0, 600, 300);

        jPanel6.setBackground(new java.awt.Color(54, 33, 89));

        sala3.setBackground(new java.awt.Color(54, 33, 89));
        sala3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sala3MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("PESQUISAR ESPAÇO");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/LUPA.jpg"))); // NOI18N

        javax.swing.GroupLayout sala3Layout = new javax.swing.GroupLayout(sala3);
        sala3.setLayout(sala3Layout);
        sala3Layout.setHorizontalGroup(
            sala3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sala3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel13)
                .addGap(43, 43, 43)
                .addComponent(jLabel11)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        sala3Layout.setVerticalGroup(
            sala3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sala3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(sala3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11))
                .addGap(29, 29, 29))
        );

        btn_eventos.setBackground(new java.awt.Color(54, 33, 89));
        btn_eventos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_eventosMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("PESQUISA SALA");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/LUPA.jpg"))); // NOI18N

        javax.swing.GroupLayout btn_eventosLayout = new javax.swing.GroupLayout(btn_eventos);
        btn_eventos.setLayout(btn_eventosLayout);
        btn_eventosLayout.setHorizontalGroup(
            btn_eventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_eventosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel14)
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_eventosLayout.setVerticalGroup(
            btn_eventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_eventosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(btn_eventosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        aluno3.setBackground(new java.awt.Color(85, 65, 118));
        aluno3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aluno3MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("PESQUISAR ALUNO");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/LUPA.jpg"))); // NOI18N

        javax.swing.GroupLayout aluno3Layout = new javax.swing.GroupLayout(aluno3);
        aluno3.setLayout(aluno3Layout);
        aluno3Layout.setHorizontalGroup(
            aluno3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aluno3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addGap(42, 42, 42)
                .addComponent(jLabel15)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        aluno3Layout.setVerticalGroup(
            aluno3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aluno3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(aluno3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        cadastrarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/iconmonstr-friend-2-24.png"))); // NOI18N
        cadastrarAluno.setText("CADASTRAR ALUNO");
        cadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAlunoActionPerformed(evt);
            }
        });

        cadastrarAluno1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/iconmonstr-friend-2-24.png"))); // NOI18N
        cadastrarAluno1.setText("CADASTRAR SALA");
        cadastrarAluno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAluno1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sala3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_eventos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(aluno3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cadastrarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cadastrarAluno1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btn_eventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sala3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aluno3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(cadastrarAluno)
                .addGap(35, 35, 35)
                .addComponent(cadastrarAluno1)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(0, 0, 270, 610);

        lupaPesquisarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagenss/lupaPreta (1).png"))); // NOI18N
        lupaPesquisarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lupaPesquisarAlunoActionPerformed(evt);
            }
        });
        getContentPane().add(lupaPesquisarAluno);
        lupaPesquisarAluno.setBounds(430, 400, 30, 30);
        getContentPane().add(nomePesquisado);
        nomePesquisado.setBounds(520, 400, 220, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sala3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sala3MouseClicked
        // TODO add your handling code here:
        new Find().setVisible(true);
        dispose();
    }//GEN-LAST:event_sala3MouseClicked

    private void btn_eventosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eventosMouseClicked
        // TODO add your handling code here:
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_eventosMouseClicked

    private void aluno3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aluno3MouseClicked
        // TODO add your handling code here:
        new Aluno().setVisible(true);
        dispose();
    }//GEN-LAST:event_aluno3MouseClicked

    private void cadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAlunoActionPerformed
        // TODO add your handling code here:
        new CadastroNovoAluno().setVisible(true);
    }//GEN-LAST:event_cadastrarAlunoActionPerformed

    private void cadastrarAluno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAluno1ActionPerformed
        // TODO add your handling code here:
        new CadastroTotal().setVisible(true);
    }//GEN-LAST:event_cadastrarAluno1ActionPerformed

    private void lupaPesquisarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lupaPesquisarAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lupaPesquisarAlunoActionPerformed

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
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aluno3;
    private javax.swing.JPanel btn_eventos;
    private javax.swing.JButton cadastrarAluno;
    private javax.swing.JButton cadastrarAluno1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lupaPesquisarAluno;
    private javax.swing.JTextField nomePesquisado;
    private javax.swing.JPanel sala3;
    private javax.swing.JTable tabelaAluno;
    // End of variables declaration//GEN-END:variables
}
