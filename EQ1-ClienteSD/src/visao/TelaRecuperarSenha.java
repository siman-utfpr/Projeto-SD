/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

/**
 *
 * @author florentino-ariza
 */
public class TelaRecuperarSenha extends javax.swing.JFrame {

    /**
     * Creates new form RecuperarSenha
     */
    public TelaRecuperarSenha() {
        initComponents();
        
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

        jPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        novaSenhaTextField = new javax.swing.JTextField();
        salvarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recuperar Senha");

        jPanel.setBackground(new java.awt.Color(203, 210, 217));
        jPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 23, 22), 1, true));

        jLabel2.setFont(new java.awt.Font("Ubuntu Mono", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 23, 22));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Recuperar senha");

        emailTextField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(25, 23, 22));
        emailTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        emailTextField.setText("  E-mail");
        emailTextField.setToolTipText("E-mail");
        emailTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 210, 217), 1, true));
        emailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailTextFieldFocusGained(evt);
            }
        });
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        novaSenhaTextField.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        novaSenhaTextField.setForeground(new java.awt.Color(25, 23, 22));
        novaSenhaTextField.setText("  Nova Senha");
        novaSenhaTextField.setToolTipText("Nova Senha");
        novaSenhaTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 210, 217), 1, true));
        novaSenhaTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                novaSenhaTextFieldFocusGained(evt);
            }
        });
        novaSenhaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaSenhaTextFieldActionPerformed(evt);
            }
        });

        salvarButton.setBackground(new java.awt.Color(203, 210, 217));
        salvarButton.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        salvarButton.setForeground(new java.awt.Color(25, 23, 22));
        salvarButton.setText("Salvar");
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtondefinirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(novaSenhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(66, 66, 66)
                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(novaSenhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(salvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldFocusGained

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void novaSenhaTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_novaSenhaTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_novaSenhaTextFieldFocusGained

    private void novaSenhaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaSenhaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_novaSenhaTextFieldActionPerformed

    private void salvarButtondefinirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtondefinirButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salvarButtondefinirButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField novaSenhaTextField;
    private javax.swing.JButton salvarButton;
    // End of variables declaration//GEN-END:variables
}
