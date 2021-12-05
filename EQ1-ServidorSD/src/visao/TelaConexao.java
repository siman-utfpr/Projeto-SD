package visao;

import controladores.ControllerServidor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import visao.util.FabricaVisoes;

public class TelaConexao extends javax.swing.JFrame {

    private ControllerServidor controller;
    
    public TelaConexao(ControllerServidor controller) {
        initComponents();
        this.controller = controller;
        this.setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabelConexao = new javax.swing.JLabel();
        jTextFieldPorta = new javax.swing.JTextField();
        jButtonConectar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelErro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Conexão");
        setBackground(new java.awt.Color(203, 210, 217));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(203, 210, 217));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 23, 22), 1, true));

        jLabelConexao.setFont(new java.awt.Font("Ubuntu Mono", 1, 48)); // NOI18N
        jLabelConexao.setForeground(new java.awt.Color(25, 23, 22));
        jLabelConexao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelConexao.setText("Conexão");

        jTextFieldPorta.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTextFieldPorta.setForeground(new java.awt.Color(25, 23, 22));
        jTextFieldPorta.setToolTipText("Porta");
        jTextFieldPorta.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 210, 217), 1, true));
        jTextFieldPorta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPortaFocusGained(evt);
            }
        });
        jTextFieldPorta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPortaActionPerformed(evt);
            }
        });
        jTextFieldPorta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPortaKeyReleased(evt);
            }
        });

        jButtonConectar.setBackground(new java.awt.Color(203, 210, 217));
        jButtonConectar.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jButtonConectar.setForeground(new java.awt.Color(25, 23, 22));
        jButtonConectar.setText("Iniciar servidor");
        jButtonConectar.setEnabled(false);
        jButtonConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                definirButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Porta:");

        jLabelErro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelErro.setForeground(new java.awt.Color(255, 51, 51));
        jLabelErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelErro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelConexao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(132, 132, 132))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelErro, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelConexao)
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelErro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jTextFieldPortaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPortaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPortaFocusGained

    private void jTextFieldPortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPortaActionPerformed
        // TODO add your handling code here:
        this.definirButtonActionPerformed(evt);
    }//GEN-LAST:event_jTextFieldPortaActionPerformed

    private void definirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_definirButtonActionPerformed
        String textoPorta = jTextFieldPorta.getText().strip();
        try {
            int porta = Integer.parseInt(textoPorta);
            this.inicializarServidor(porta);
        } catch (NumberFormatException e) {
            this.jLabelErro.setText("Porta inválida");
            //JOptionPane.showMessageDialog(null, "Porta inválida", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_definirButtonActionPerformed

    private void jTextFieldPortaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPortaKeyReleased
        // TODO add your handling code here:
        jButtonConectar.setEnabled(!jTextFieldPorta.getText().isBlank());
    }//GEN-LAST:event_jTextFieldPortaKeyReleased

    
    private void inicializarServidor(int porta) {
        if (porta < 20000 || porta > 25000) {
            this.jLabelErro.setText("Escolha uma porta entre 20000 e 25000");
            //JOptionPane.showMessageDialog(null, "Escolha uma porta entre 20000 e 25000", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            controller.inicializarServidor(porta);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelConexao;
    private javax.swing.JLabel jLabelErro;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldPorta;
    // End of variables declaration//GEN-END:variables

}