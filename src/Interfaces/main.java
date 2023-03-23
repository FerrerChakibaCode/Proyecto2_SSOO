/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.TLOU.ManagerTLOU;
import Classes.TLOU.QueueTLOU;
import GOT.AI;
import GOT.ManagerGOT;
import GOT.QueueGOT;

/**
 *
 * @author emilo
 */
public class main extends javax.swing.JFrame {

    // GOT
    public static QueueGOT firstQueueGOT;
    public static QueueGOT secondQueueGOT;
    public static QueueGOT thirdQueueGOT;
    public static QueueGOT strengthQueueGOT;
    public static ManagerGOT managerGOT;

    // TLOU
    public static QueueTLOU firstQueueTLOU;
    public static QueueTLOU secondQueueTLOU;
    public static QueueTLOU thirdQueueTLOU;
    public static QueueTLOU strengthQueueTLOU;
    public static ManagerTLOU managerTLOU;

    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        loadManagerGOT();
        loadManagerTLOU();
        loadAI();

    }

    public void loadManagerGOT() {
        this.managerGOT = new ManagerGOT();
        this.managerGOT.start();
    }
    
    public void loadManagerTLOU() {
        this.managerTLOU = new ManagerTLOU();
        this.managerTLOU.start();
    }
    
    public void loadAI() {
        AI ai = new AI(managerGOT, managerTLOU);
        ai.start();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        queue1GOTPanel = new javax.swing.JScrollPane();
        queue1GOT = new javax.swing.JTextArea();
        queue2GOTPanel = new javax.swing.JScrollPane();
        queue2GOT = new javax.swing.JTextArea();
        queue3GOTPanel = new javax.swing.JScrollPane();
        queue3GOT = new javax.swing.JTextArea();
        queueStrengthGOTPanel = new javax.swing.JScrollPane();
        queueStrengthGOT = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        winner = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        idFighterGOT = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        idFighterTLOU = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        qualFighterTLOU = new javax.swing.JLabel();
        qualFighterGOT = new javax.swing.JLabel();
        queue1TLOUPanel = new javax.swing.JScrollPane();
        queue1TLOU = new javax.swing.JTextArea();
        queue2TLOUPanel = new javax.swing.JScrollPane();
        queue2TLOU = new javax.swing.JTextArea();
        queue3TLOUPanel = new javax.swing.JScrollPane();
        queue3TLOU = new javax.swing.JTextArea();
        queue4TLOUPanel = new javax.swing.JScrollPane();
        queue4TLOU = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("The last of us");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, 220, -1));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel2.setText("HBO Max Vzla +");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 300, -1));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel4.setText("Game of Thrones");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 220, -1));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel9.setText("Queue Refuerzo");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 570, 220, -1));

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel10.setText("Queue prioridad 3");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 440, 220, -1));

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setText("Queue prioridad 2");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 290, 220, -1));

        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel12.setText("Queue prioridad 1");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 220, -1));

        jLabel13.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel13.setText("Queue Refuerzo");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, 220, -1));

        jLabel14.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel14.setText("Queue prioridad 3");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 220, -1));

        jLabel15.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel15.setText("Queue prioridad 2");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 220, -1));

        queue1GOT.setColumns(20);
        queue1GOT.setRows(5);
        queue1GOTPanel.setViewportView(queue1GOT);

        getContentPane().add(queue1GOTPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        queue2GOT.setColumns(20);
        queue2GOT.setRows(5);
        queue2GOTPanel.setViewportView(queue2GOT);

        getContentPane().add(queue2GOTPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        queue3GOT.setColumns(20);
        queue3GOT.setRows(5);
        queue3GOTPanel.setViewportView(queue3GOT);

        getContentPane().add(queue3GOTPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        queueStrengthGOT.setColumns(20);
        queueStrengthGOT.setRows(5);
        queueStrengthGOTPanel.setViewportView(queueStrengthGOT);

        getContentPane().add(queueStrengthGOTPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, -1, -1));

        jLabel17.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel17.setText("Queue prioridad 1");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 220, -1));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Inteligencia Artificial");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 210, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/rick.gif"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 170, 170));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/morty.gif"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 160, 280));

        winner.setBackground(new java.awt.Color(255, 0, 102));
        winner.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        winner.setForeground(new java.awt.Color(255, 0, 204));
        getContentPane().add(winner, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 670, 120, 30));

        jLabel21.setFont(new java.awt.Font("Chiller", 3, 18)); // NOI18N
        jLabel21.setText("AND THE WINNER IS... ");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 680, -1, -1));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel7.setText("FIGHTER DE GOT");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 140, -1));

        jLabel22.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel22.setText("ID:");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 40, -1));

        idFighterGOT.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(idFighterGOT, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 110, 20));

        jLabel23.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel23.setText("Calidad:");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 70, -1));

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel8.setText("FIGHTER DE TLOU");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 460, 140, -1));

        jLabel18.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel18.setText("ID:");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, 40, -1));

        idFighterTLOU.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(idFighterTLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, 70, 20));

        jLabel16.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel16.setText("Calidad:");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 540, 70, -1));

        qualFighterTLOU.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(qualFighterTLOU, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 540, 70, 20));

        qualFighterGOT.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        getContentPane().add(qualFighterGOT, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 70, 20));

        queue1TLOU.setColumns(20);
        queue1TLOU.setRows(5);
        queue1TLOUPanel.setViewportView(queue1TLOU);

        getContentPane().add(queue1TLOUPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 190, 270, -1));

        queue2TLOU.setColumns(20);
        queue2TLOU.setRows(5);
        queue2TLOUPanel.setViewportView(queue2TLOU);

        getContentPane().add(queue2TLOUPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 340, 270, -1));

        queue3TLOU.setColumns(20);
        queue3TLOU.setRows(5);
        queue3TLOUPanel.setViewportView(queue3TLOU);

        getContentPane().add(queue3TLOUPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(854, 470, 270, -1));

        queue4TLOU.setColumns(20);
        queue4TLOU.setRows(5);
        queue4TLOUPanel.setViewportView(queue4TLOU);

        getContentPane().add(queue4TLOUPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 600, 270, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel idFighterGOT;
    public static javax.swing.JLabel idFighterTLOU;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel qualFighterGOT;
    public static javax.swing.JLabel qualFighterTLOU;
    public static javax.swing.JTextArea queue1GOT;
    public static javax.swing.JScrollPane queue1GOTPanel;
    public static javax.swing.JTextArea queue1TLOU;
    public static javax.swing.JScrollPane queue1TLOUPanel;
    public static javax.swing.JTextArea queue2GOT;
    public static javax.swing.JScrollPane queue2GOTPanel;
    public static javax.swing.JTextArea queue2TLOU;
    public static javax.swing.JScrollPane queue2TLOUPanel;
    public static javax.swing.JTextArea queue3GOT;
    public static javax.swing.JScrollPane queue3GOTPanel;
    public static javax.swing.JTextArea queue3TLOU;
    public static javax.swing.JScrollPane queue3TLOUPanel;
    public static javax.swing.JTextArea queue4TLOU;
    public static javax.swing.JScrollPane queue4TLOUPanel;
    public static javax.swing.JTextArea queueStrengthGOT;
    public static javax.swing.JScrollPane queueStrengthGOTPanel;
    public static javax.swing.JLabel winner;
    // End of variables declaration//GEN-END:variables
}
