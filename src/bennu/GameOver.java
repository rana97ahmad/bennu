/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bennu;

import static bennu.Bennu.bennu;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This class is for outputting a gameover frame with buttons to
 * play again and exit the game and view scores for the fishmine game
 * @author Rana alahmadi
 */
public class GameOver extends javax.swing.JFrame {
private Clip clip;
    /**
     * Creates new form GameOver
     */
    public GameOver() {
        initComponents();
        setSize(800,660);
        setLocationRelativeTo(null);
        setVisible(true);
        try{
          File sound = new File("sounds//go.wav");
      AudioInputStream ais =AudioSystem.getAudioInputStream(sound);
      clip = AudioSystem.getClip();
      clip.open(ais);
      clip.start();
      }catch(Exception e){System.out.println(e);}
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
        jLabel_title = new javax.swing.JLabel();
        jButton_playagain = new javax.swing.JButton();
        jButton_exit = new javax.swing.JButton();
        jLabel_score = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel_title.setFont(new java.awt.Font("OCR A Std", 0, 60)); // NOI18N
        jLabel_title.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_title.setText("Game Over!");

        jButton_playagain.setFont(new java.awt.Font("OCR A Std", 0, 24)); // NOI18N
        jButton_playagain.setText("Play Again");
        jButton_playagain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_playagainActionPerformed(evt);
            }
        });

        jButton_exit.setFont(new java.awt.Font("OCR A Std", 0, 24)); // NOI18N
        jButton_exit.setText("Exit");
        jButton_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_exitActionPerformed(evt);
            }
        });

        jLabel_score.setFont(new java.awt.Font("OCR A Std", 0, 24)); // NOI18N
        jLabel_score.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_score.setText("Your score is:");

        jLabel1.setFont(new java.awt.Font("OCR A Std", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Feel the fear and do it any way");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jButton_playagain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(164, 164, 164))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel_title)
                        .addGap(229, 229, 229))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel_score)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel_title)
                .addGap(66, 66, 66)
                .addComponent(jLabel_score)
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_playagain)
                    .addComponent(jButton_exit))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-20, -10, 890, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_playagainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_playagainActionPerformed
       
        bennu = new Bennu();
         clip.stop();
        this.dispose();
    }//GEN-LAST:event_jButton_playagainActionPerformed

    private void jButton_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_exitActionPerformed

       clip.stop();
       this.dispose();
    }//GEN-LAST:event_jButton_exitActionPerformed

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
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameOver().setVisible(true);
            }
        });
    }
/**
 * sets the label with the score
 * @param score from the fish game
 */
    public void setjLabel_score(int score) {
         jLabel_score.setText("Your score is: "+score);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_exit;
    private javax.swing.JButton jButton_playagain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_score;
    private javax.swing.JLabel jLabel_title;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
