/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GroupMembers;


import DatatoJtable.StudentView;
import EventLoginPage123.EloginPage;
import OriginalStudentLoginPage.OStudentLoginPage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ARFAH
 */
public class GroupMembPage extends javax.swing.JFrame {

    /**
     * Creates new form GroupMembPage
     */
    public GroupMembPage() {
        initComponents();
  show_user();
    }
 
    public ArrayList<User> userList() {
    ArrayList<User> userList = new ArrayList<>();
     try
               {
                    //EventNameL.setText(EventLoginPage123.EloginPage.EventIDTF.getText());
                   // Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MiniProject","postgres","***********");
 
                   String sql="Select rt.group_id,et.event_name,st.prn, st.name, st.branch,st.year \n" +
"From register_table rt INNER JOIN event_table et  \n" +
"ON rt.event_id=et.event_id  \n" +
"INNER JOIN student_table st ON rt.prn = st.prn \n" +
"where group_id in(select group_id from register_table where prn ='"+OStudentLoginPage.PRNT.getText()+"') \n" +
"and rt.event_id in(select event_id from register_table where prn ='"+OStudentLoginPage.PRNT.getText()+"') \n" +
"Order by group_id";
                    // JOptionPane.showMessageDialog(null,  sql );
System.out.println(sql);
 //JOptionPane.showMessageDialog(null,  EloginPage.EventIDTF.getText() );
                    Statement ps =con.createStatement();
                       //Statement ps = con.prepareStatement(sql);
                     // ps.setString(1,OStudentLoginPage.PRNT.getText() );
                      //ps.setString(2,OStudentLoginPage.PRNT.getText() );
                    ResultSet rs = ps.executeQuery(sql);
                   User user;
                   while(rs.next()) {
                        user=new User(rs.getString("group_id" ),rs.getString("event_name" ),rs.getString("prn" ),rs.getString("name" ),rs.getString("branch" ),rs.getString("year" ));
                        userList.add(user);  
                   }
               }
 catch(Exception e) {
               JOptionPane.showMessageDialog(null, e);
         }
         return userList;
    }
   
    public void show_user() {
    ArrayList<User> list = userList();
        DefaultTableModel model= (DefaultTableModel) GMTable.getModel();
        Object [] row = new Object[7];
    for(int i=0;i<list.size();i++){
     row[0]=i+1;   
     row[1]=list.get(i).getgroup_id();
       row[2]=list.get(i).getevent_name();
row[3]=list.get(i).getprn();
        row[4]=list.get(i).getname();
        row[5]=list.get(i).getbranch();
        row[6]=list.get(i).getyear();
        model.addRow(row);
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
        BackB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        GMTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackB.setText("Back");
        BackB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBActionPerformed(evt);
            }
        });

        GMTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S. No.", "Group ID", "Event Name", "PRN", "Member Name", "Branch", "Year"
            }
        ));
        jScrollPane1.setViewportView(GMTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(BackB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(BackB)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBActionPerformed
        // TODO add your handling code here:
          StudentView menu= new StudentView();
                        menu.setVisible(true);
                        setVisible(false);
    }//GEN-LAST:event_BackBActionPerformed

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
            java.util.logging.Logger.getLogger(GroupMembPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroupMembPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroupMembPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroupMembPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GroupMembPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackB;
    private javax.swing.JTable GMTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
