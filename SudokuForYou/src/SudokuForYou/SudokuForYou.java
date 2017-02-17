/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SudokuForYou;

import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;


/**
 *
 * @author Ayushi
 */
public class SudokuForYou extends javax.swing.JFrame {
   static int N = 9;
   static int row;
   static int col;  
   static int track[] = new int[2];
   static int grid[][] = new int[][] {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};  
       
                        
   
    public SudokuForYou(){
        initComponents();
        setLayout();
    }
    
   private void setLayout(){
       for(int i =0;i<N;i++){
           for(int j=0;j<N;j++){
           
               JLabel l = new JLabel("" +grid[i][j], JLabel.CENTER);
               
            l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            l.setFont(l.getFont().deriveFont(20f));
            jPanel1.add(l);
           }
       }
   }
   public void setSolutionLayout(int grid[][],int row,int col){
       if(solutionOfSudoku(grid,row,col)){
            for(int i =0;i<N;i++){
           for(int j=0;j<N;j++){
           
               JLabel m = new JLabel("" +grid[i][j], JLabel.CENTER);
               
            m.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            m.setFont(m.getFont().deriveFont(20f));
            jPanel2.add(m);
           }
       }
       }
       else
           JOptionPane.showMessageDialog(this.jFrame1, "Solution not found");
   }
   boolean solutionOfSudoku(int grid[][],int row,int col){
     
      if(!findUnassignedCell(grid,row,col,track))
          return true;
      row=track[0];
      col=track[1];
      for(int num =1;num<=9;num++){
          if(checkValidity(grid,row,col,num)){
              grid[row][col]=num;
          if(solutionOfSudoku(grid,row,col))
              return true;
          grid[row][col]=0;
          }
      }
      
      return false;
     
   }
   
   boolean findUnassignedCell(int grid[][],int row,int col,int track[]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(grid[i][j]==0){
                   row=track[0];
                   col=track[1];
                    return true;
               }
            }
        }
        return false;
   }
   boolean alreadyInRow(int [][]grid,int row,int num){
       for(int i=0;i<N;i++){
           if(grid[row][i]==num)
              return true;
       }
       return false;
   }
   boolean alreadyInCol(int [][]grid,int col,int num){
       for(int i=0;i<N;i++){
           if(grid[i][col]==num)
               return true;
       }
       return false;
   }
   boolean alreadyInBox(int grid[][],int boxRow,int boxCol,int num){
       for(int i=0;i<N;i++){
           for(int j=0;j<N;j++){
           if(grid[i+boxRow][j+boxCol]==num)
               return true;
           }
       }
       return false;
   }
   boolean checkValidity(int grid[][],int row,int col,int num){
       return(!alreadyInRow(num) && !alreadyInCol(num) && !(alreadyInBox(row-row%3,col-col%3,num)));
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        jPanel2.setLayout(new java.awt.GridLayout(9, 9, 2, 2));

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 600));

        jPanel1.setLayout(new java.awt.GridLayout(9, 9, 2, 2));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(285, 285, 285))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jButton1)
                .addGap(76, 76, 76))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jFrame1.setVisible(true);
        setSolutionLayout();
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SudokuForYou.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SudokuForYou.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SudokuForYou.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SudokuForYou.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SudokuForYou().setVisible(true);
               // new SudokuForYou(row,col).
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
