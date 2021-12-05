package visao;

import java.io.IOException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.json.JSONException;
import visao.util.FabricaVisoes;
import visao.util.GerenciadorUsuario;
import visao.util.Logger;

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLocationRelativeTo(null);
        
        if(GerenciadorUsuario.getIpConexao() != null){
            this.jTextFieldIp.setText(GerenciadorUsuario.getIpConexao());
            this.jTextFieldPorta.setText(String.valueOf(GerenciadorUsuario.getPortaConexao()));
            this.definirButtonActionPerformed(null);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordFieldLogin = new javax.swing.JPasswordField();
        jButtonEsqueciSenha = new javax.swing.JButton();
        jButtonCadastro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldIp = new javax.swing.JTextField();
        jTextFieldPorta = new javax.swing.JTextField();
        jButtonDefinirServidor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonRedefinirServidor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(203, 210, 217));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(203, 210, 217));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 23, 22), 1, true));

        jLabel1.setFont(new java.awt.Font("Ubuntu Mono", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(25, 23, 22));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login");

        jTextFieldEmail.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextFieldEmail.setForeground(new java.awt.Color(25, 23, 22));
        jTextFieldEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldEmail.setToolTipText("  E-mail");
        jTextFieldEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 210, 217), 1, true));
        jTextFieldEmail.setEnabled(false);
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

        jButtonLogin.setBackground(new java.awt.Color(61, 63, 66));
        jButtonLogin.setFont(new java.awt.Font("Ubuntu Mono", 0, 24)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(235, 234, 213));
        jButtonLogin.setText("Login");
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonLogin.setEnabled(false);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Senha:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("E-mail:");

        jPasswordFieldLogin.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPasswordFieldLogin.setEnabled(false);
        jPasswordFieldLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldLoginKeyReleased(evt);
            }
        });

        jButtonEsqueciSenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonEsqueciSenha.setText("Esqueci minha senha");
        jButtonEsqueciSenha.setEnabled(false);
        jButtonEsqueciSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEsqueciSenhaActionPerformed(evt);
            }
        });

        jButtonCadastro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCadastro.setText("Cadastro");
        jButtonCadastro.setEnabled(false);
        jButtonCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldLogin))
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEsqueciSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(137, 137, 137)
                    .addComponent(jLabel6)
                    .addContainerGap(538, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEsqueciSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(109, 109, 109)
                    .addComponent(jLabel6)
                    .addContainerGap(210, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(203, 210, 217));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(25, 23, 22), 1, true));

        jLabel2.setFont(new java.awt.Font("Ubuntu Mono", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(25, 23, 22));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Conexão");

        jTextFieldIp.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jTextFieldIp.setForeground(new java.awt.Color(25, 23, 22));
        jTextFieldIp.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldIp.setToolTipText("IP");
        jTextFieldIp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(203, 210, 217), 1, true));
        jTextFieldIp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldIpFocusGained(evt);
            }
        });
        jTextFieldIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIpActionPerformed(evt);
            }
        });
        jTextFieldIp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldIpKeyReleased(evt);
            }
        });

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

        jButtonDefinirServidor.setBackground(new java.awt.Color(203, 210, 217));
        jButtonDefinirServidor.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButtonDefinirServidor.setForeground(new java.awt.Color(25, 23, 22));
        jButtonDefinirServidor.setText("Definir Servidor");
        jButtonDefinirServidor.setEnabled(false);
        jButtonDefinirServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                definirButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Porta:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Servidor: ");

        jButtonRedefinirServidor.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jButtonRedefinirServidor.setText("Redefinir");
        jButtonRedefinirServidor.setEnabled(false);
        jButtonRedefinirServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRedefinirServidorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonDefinirServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPorta))
                    .addComponent(jButtonRedefinirServidor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDefinirServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRedefinirServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailActionPerformed

    }//GEN-LAST:event_jTextFieldEmailActionPerformed

    private boolean conectarUsuario() {
        boolean erroNaConexao;
        try {
            erroNaConexao = !GerenciadorUsuario.conectarUsuario();
        } catch (IOException e) {
            erroNaConexao = true;
        } catch (NullPointerException e2) {
            JOptionPane.showMessageDialog(null, "Você não definiu o IP e/ou a porta.", "Erro", JOptionPane.ERROR_MESSAGE);
            erroNaConexao = true;
        }

        if (erroNaConexao) {
            JOptionPane.showMessageDialog(null, "Usuário não se conectou ao servidor !", "Erro", JOptionPane.ERROR_MESSAGE);
        } 

        return erroNaConexao;
    }

    private void loginUsuario() {
        boolean erroNoLogin
                = GerenciadorUsuario.fazerLoginUsuario(jTextFieldEmail.getText().strip(), String.valueOf(jPasswordFieldLogin.getPassword()).strip());

        if (!erroNoLogin) {
            
            FabricaVisoes.esconderTela("TelaLogin");
            FabricaVisoes.mostrarTelaHomePage();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciais inválidas!", "Erro", JOptionPane.ERROR_MESSAGE);

            GerenciadorUsuario.desconectar();

        }
    }

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed

        boolean erroNaConexao = conectarUsuario();
        if (erroNaConexao) {
            Logger.escreverMensagem("ERRO NA CONEXÃO");
            return;
        }
        // Realizando o login do usuário
        loginUsuario();

    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jTextFieldEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldEmailFocusGained

    }//GEN-LAST:event_jTextFieldEmailFocusGained

    private void jTextFieldIpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldIpFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIpFocusGained

    private void jTextFieldIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIpActionPerformed

    private void jTextFieldPortaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPortaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPortaFocusGained

    private void jTextFieldPortaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPortaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPortaActionPerformed

    private void definirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_definirButtonActionPerformed
        //validar servidor e porta          
        try {
            jTextFieldIp.setEnabled(false);
            jTextFieldPorta.setEnabled(false);
            jTextFieldEmail.setEnabled(true);
            jPasswordFieldLogin.setEnabled(true);
            jButtonRedefinirServidor.setEnabled(true);
            jButtonDefinirServidor.setEnabled(false);
            jButtonEsqueciSenha.setEnabled(true);
            jButtonCadastro.setEnabled(true);

            String ipConexao = jTextFieldIp.getText();
            int portaConexao = Integer.parseInt(jTextFieldPorta.getText());
            if (portaConexao < 20000 || portaConexao > 25000) {
                JOptionPane.showMessageDialog(null, "Escolhe uma porta entre 20000 e 25000", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            GerenciadorUsuario.setIpConexao(ipConexao);
            GerenciadorUsuario.setPortaConexao(portaConexao);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Porta inválida", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_definirButtonActionPerformed

    private void jTextFieldIpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIpKeyReleased
        // TODO add your handling code here:
        if (this.jTextFieldIp.getText().isBlank() || jTextFieldPorta.getText().isBlank()) {
            this.jButtonDefinirServidor.setEnabled(false);
        } else {
            this.jButtonDefinirServidor.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldIpKeyReleased

    private void jButtonRedefinirServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedefinirServidorActionPerformed
        // TODO add your handling code here:
        jTextFieldIp.setEnabled(true);
        jTextFieldPorta.setEnabled(true);
        jTextFieldEmail.setEnabled(false);
        jPasswordFieldLogin.setEnabled(false);
        jButtonRedefinirServidor.setEnabled(false);
        jButtonDefinirServidor.setEnabled(true);
        jButtonEsqueciSenha.setEnabled(false);
        jButtonCadastro.setEnabled(false);
    }//GEN-LAST:event_jButtonRedefinirServidorActionPerformed

    private void jTextFieldPortaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPortaKeyReleased
        // TODO add your handling code here:
        if (this.jTextFieldIp.getText().isBlank() || jTextFieldPorta.getText().isBlank()) {
            this.jButtonDefinirServidor.setEnabled(false);
        } else {
            this.jButtonDefinirServidor.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldPortaKeyReleased

    private void jTextFieldEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmailKeyReleased
        // TODO add your handling code here:
        if (this.jTextFieldEmail.getText().isBlank() || String.valueOf(jPasswordFieldLogin.getPassword()).isBlank()) {
            this.jButtonLogin.setEnabled(false);
        } else {
            this.jButtonLogin.setEnabled(true);
        }
    }//GEN-LAST:event_jTextFieldEmailKeyReleased

    private void jPasswordFieldLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldLoginKeyReleased
        // TODO add your handling code here:
        if (this.jTextFieldEmail.getText().isBlank() || String.valueOf(jPasswordFieldLogin.getPassword()).isBlank()) {
            this.jButtonLogin.setEnabled(false);
        } else {
            this.jButtonLogin.setEnabled(true);
        }
    }//GEN-LAST:event_jPasswordFieldLoginKeyReleased

    private void jButtonEsqueciSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEsqueciSenhaActionPerformed
        // TODO add your handling code here:

        String email = JOptionPane.showInputDialog("Insira seu endereço de email: ");
        if (email != null) {
            boolean erroNaConexao = conectarUsuario();

            if (erroNaConexao) {
                Logger.escreverMensagem("ERRO NA CONEXÃO");
                return;
            }
            try {
                if (GerenciadorUsuario.recuperarSenha(email)) {
                    JOptionPane.showMessageDialog(null, "Recuperação realizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Ocorreu um problema durante a recuperação da senha.");
                }
                GerenciadorUsuario.desconectar();
            } catch (JSONException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButtonEsqueciSenhaActionPerformed

    private void jButtonCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastroActionPerformed
        // TODO add your handling code here:
        FabricaVisoes.mostrarTelaCadastro();
        FabricaVisoes.esconderTela("TelaLogin");  
    }//GEN-LAST:event_jButtonCadastroActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastro;
    private javax.swing.JButton jButtonDefinirServidor;
    private javax.swing.JButton jButtonEsqueciSenha;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonRedefinirServidor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordFieldLogin;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldIp;
    private javax.swing.JTextField jTextFieldPorta;
    // End of variables declaration//GEN-END:variables

}
