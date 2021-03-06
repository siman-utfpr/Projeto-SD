package visao;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Usuario;
import org.json.JSONException;
import util.Digest;
import util.HashGenerationException;
import visao.util.FabricaVisoes;
import visao.util.GerenciadorUsuario;

public class TelaAtualizacaoUsuario extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastro
     */
    public TelaAtualizacaoUsuario() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.jTextFieldEmail.setText(GerenciadorUsuario.getUsuarioLogado().getEmail());
        jTextFieldNomeUsuario.setText(GerenciadorUsuario.getUsuarioLogado().getNomeUsuario());
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
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonAtualizar = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextFieldNomeUsuario = new javax.swing.JTextField();
        jButtonVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atualização do cadastro");

        jPanel.setBackground(new java.awt.Color(203, 210, 217));
        jPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 23, 22), 1, true));

        jLabel2.setFont(new java.awt.Font("Ubuntu Mono", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 23, 22));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Atualizar Dados");

        jTextFieldEmail.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(25, 23, 22));
        jTextFieldEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldEmail.setToolTipText("E-mail");
        jTextFieldEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 210, 217), 1, true));
        jTextFieldEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldEmailFocusGained(evt);
            }
        });
        jTextFieldEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailActionPerformed(evt);
            }
        });
        jTextFieldEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldEmailKeyReleased(evt);
            }
        });

        jButtonAtualizar.setBackground(new java.awt.Color(203, 210, 217));
        jButtonAtualizar.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jButtonAtualizar.setForeground(new java.awt.Color(25, 23, 22));
        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.setEnabled(false);
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizardefinirButtonActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
        });

        jTextFieldNomeUsuario.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTextFieldNomeUsuario.setForeground(new java.awt.Color(25, 23, 22));
        jTextFieldNomeUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldNomeUsuario.setToolTipText("E-mail");
        jTextFieldNomeUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 210, 217), 1, true));
        jTextFieldNomeUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldNomeUsuarioFocusGained(evt);
            }
        });
        jTextFieldNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeUsuarioActionPerformed(evt);
            }
        });
        jTextFieldNomeUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldNomeUsuarioKeyReleased(evt);
            }
        });

        jButtonVoltar.setBackground(new java.awt.Color(203, 210, 217));
        jButtonVoltar.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(25, 23, 22));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltardefinirButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("E-mail:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Senha:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nome de usuário:");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)))
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(174, 174, 174))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(29, 29, 29)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailFocusGained

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private void jButtonAtualizardefinirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizardefinirButtonActionPerformed
        try {
            // TODO add your handling code here:
            String nomeUsuario = jTextFieldNomeUsuario.getText().trim();
            String email = jTextFieldEmail.getText().trim();
            String senha = Digest.hashString(String.valueOf(jPasswordField1.getPassword()).trim(), "SHA-256");

            if (GerenciadorUsuario.fazerAtualizacaoUsuario(email, nomeUsuario, senha)) {
                JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso");
                Usuario usuarioAtualizado = new Usuario(GerenciadorUsuario.getUsuarioLogado().getUuid(), 
                        nomeUsuario, email, "");
                
                GerenciadorUsuario.setUsuarioLogado(usuarioAtualizado);
            } else {
                JOptionPane.showMessageDialog(null, "Erro na atualização do usuario");
            }

            FabricaVisoes.mostrarTelaHomePage();
            FabricaVisoes.esconderTela("TelaAtualizacaoUsuario");

        } catch (HashGenerationException ex) {
            ex.printStackTrace();
            //Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(TelaAtualizacaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaAtualizacaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAtualizardefinirButtonActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jTextFieldNomeUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNomeUsuarioFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeUsuarioFocusGained

    private void jTextFieldNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeUsuarioActionPerformed

    private void jButtonVoltardefinirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltardefinirButtonActionPerformed
        // TODO add your handling code here:
        FabricaVisoes.mostrarTelaHomePage();
        FabricaVisoes.esconderTela("TelaAtualizacaoUsuario");
    }//GEN-LAST:event_jButtonVoltardefinirButtonActionPerformed

    private void jTextFieldEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyReleased
        // TODO add your handling code here:
        if (jTextFieldEmail.getText().isBlank() || jTextFieldNomeUsuario.getText().isBlank()
                || String.valueOf(jPasswordField1.getPassword()).isBlank()) {
            jButtonAtualizar.setEnabled(false);
        } else {
            jButtonAtualizar.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldEmailKeyReleased

    private void jTextFieldNomeUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeUsuarioKeyReleased
        // TODO add your handling code here:
        if (jTextFieldEmail.getText().isBlank() || jTextFieldNomeUsuario.getText().isBlank()
                || String.valueOf(jPasswordField1.getPassword()).isBlank()) {
            jButtonAtualizar.setEnabled(false);
        } else {
            jButtonAtualizar.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldNomeUsuarioKeyReleased

    private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyReleased
        // TODO add your handling code here:
        if (jTextFieldEmail.getText().isBlank() || jTextFieldNomeUsuario.getText().isBlank()
                || String.valueOf(jPasswordField1.getPassword()).isBlank()) {
            jButtonAtualizar.setEnabled(false);
        } else {
            jButtonAtualizar.setEnabled(true);
        }
    }//GEN-LAST:event_jPasswordField1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNomeUsuario;
    // End of variables declaration//GEN-END:variables
}
