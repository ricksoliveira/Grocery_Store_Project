/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mercadinhodb;

import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Produto;
import model.bean.ProdutosDeletados;
import model.dao.ProdutoDAO;
import model.dao.ProdutosDeletadosDAODescontinuado;

/**
 *
 * @author Henrique Oliveira
 */
public class ViewProdutosDeletadosDB extends javax.swing.JFrame {

    /**
     * Creates new form ViewProdutosDeletadosDB
     */
    public ViewProdutosDeletadosDB() {
        initComponents();
        readTable();
        setUsuarioLogado();
    }
    
    public void readTable(){
        DefaultTableModel modelo = (DefaultTableModel) DeletedTable.getModel();
        
        modelo.setNumRows(0);
        
        ProdutoDAO pdao = new ProdutoDAO();
        
        for(Produto p : pdao.readDel()){
            modelo.addRow(new Object[]{p.getId(), p.getDescricao(), p.getQuantidade(), p.getPreco()});
        }
        
    }
    
    public void readSearch(String desc){
        DefaultTableModel modelo = (DefaultTableModel) DeletedTable.getModel();
        
        modelo.setNumRows(0);
        
        ProdutoDAO pdao = new ProdutoDAO();
        
        for(Produto p : pdao.searchDel(desc)){
            modelo.addRow(new Object[]{p.getId(), p.getDescricao(), p.getQuantidade(), p.getPreco()});
        }
        
    }
    
    public void setUsuarioLogado(){
        UsuarioLogadotxt.setText(ViewLauncherDB.Login_User);
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
        DeletedTable = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        BotaoHome = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        BotaoCadastrarProdutos = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscaDel = new javax.swing.JTextField();
        BotaoBuscarDel = new javax.swing.JButton();
        BotaResetarBuscaDel = new javax.swing.JButton();
        BotaoRestaurar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        UsuarioLogadotxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        DeletedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRICAO", "QUANTIDADE", "PREÇO (R$)", "RESPONSAVEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DeletedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DeletedTableMouseReleased(evt);
            }
        });
        DeletedTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DeletedTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(DeletedTable);
        if (DeletedTable.getColumnModel().getColumnCount() > 0) {
            DeletedTable.getColumnModel().getColumn(0).setMinWidth(70);
            DeletedTable.getColumnModel().getColumn(0).setMaxWidth(70);
            DeletedTable.getColumnModel().getColumn(1).setResizable(false);
            DeletedTable.getColumnModel().getColumn(2).setMinWidth(110);
            DeletedTable.getColumnModel().getColumn(2).setMaxWidth(110);
            DeletedTable.getColumnModel().getColumn(3).setMinWidth(90);
            DeletedTable.getColumnModel().getColumn(3).setMaxWidth(90);
            DeletedTable.getColumnModel().getColumn(4).setMinWidth(135);
            DeletedTable.getColumnModel().getColumn(4).setMaxWidth(135);
        }

        jToolBar1.setFloatable(false);
        jToolBar1.add(jSeparator1);

        BotaoHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/house.png"))); // NOI18N
        BotaoHome.setText("Home");
        BotaoHome.setFocusable(false);
        BotaoHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotaoHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoHomeActionPerformed(evt);
            }
        });
        jToolBar1.add(BotaoHome);
        jToolBar1.add(jSeparator2);

        BotaoCadastrarProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database_add.png"))); // NOI18N
        BotaoCadastrarProdutos.setText("Produtos");
        BotaoCadastrarProdutos.setFocusable(false);
        BotaoCadastrarProdutos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BotaoCadastrarProdutos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BotaoCadastrarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCadastrarProdutosActionPerformed(evt);
            }
        });
        jToolBar1.add(BotaoCadastrarProdutos);
        jToolBar1.add(jSeparator3);

        jPanel1.setBackground(new java.awt.Color(180, 205, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUTOS INATIVOS / EXCLUÍDOS");

        txtBuscaDel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtBuscaDel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaDelKeyPressed(evt);
            }
        });

        BotaoBuscarDel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BotaoBuscarDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        BotaoBuscarDel.setText("Buscar");
        BotaoBuscarDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscarDelActionPerformed(evt);
            }
        });

        BotaResetarBuscaDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cross.png"))); // NOI18N
        BotaResetarBuscaDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaResetarBuscaDelActionPerformed(evt);
            }
        });

        BotaoRestaurar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BotaoRestaurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/database_go.png"))); // NOI18N
        BotaoRestaurar.setText("Restaurar");
        BotaoRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRestaurarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/emoticon_grin.png"))); // NOI18N

        UsuarioLogadotxt.setEditable(false);
        UsuarioLogadotxt.setBackground(new java.awt.Color(202, 202, 211));
        UsuarioLogadotxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        UsuarioLogadotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioLogadotxtActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("LOGADO COMO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsuarioLogadotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoRestaurar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(BotaResetarBuscaDel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtBuscaDel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(BotaoBuscarDel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(UsuarioLogadotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoBuscarDel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscaDel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BotaResetarBuscaDel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addComponent(BotaoRestaurar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoCadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCadastrarProdutosActionPerformed
        this.dispose();
        new ViewCadastroProdutosDB().setVisible(true);   
    }//GEN-LAST:event_BotaoCadastrarProdutosActionPerformed

    private void BotaoHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoHomeActionPerformed
        this.dispose();
        new ViewDashboardDB().setVisible(true);
    }//GEN-LAST:event_BotaoHomeActionPerformed

    private void BotaoRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRestaurarActionPerformed
        
        if(DeletedTable.getSelectedRow() != -1){
            
            ProdutoDAO dao = new ProdutoDAO();
            Produto p = new Produto();
            
//            ProdutosDeletadosDAODescontinuado deldao = new ProdutosDeletadosDAODescontinuado();
//            ProdutosDeletados prodel = new ProdutosDeletados();
            
//            p.setDescricao(DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 1).toString());
//            p.setQuantidade((int) DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 2));
//            p.setPreco((double) DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 3));
            
            p.setCriacao(ViewLauncherDB.Login_User);
            p.setId((int) DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 0));

            dao.restaura(p);
            
            readTable();

        }
        else{
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir!");
        }
        
    }//GEN-LAST:event_BotaoRestaurarActionPerformed

    private void DeletedTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DeletedTableKeyReleased
        
//        if(DeletedTable.getSelectedRow() != -1){
//            txtDescDel.setText(DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 2).toString());
//            txtQuantidadeDel.setText(DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 3).toString());
//            txtPrecoDel.setText(DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 4).toString());
//        }
        
    }//GEN-LAST:event_DeletedTableKeyReleased

    private void DeletedTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeletedTableMouseReleased
        
//        if(DeletedTable.getSelectedRow() != -1){
//            txtDescDel.setText(DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 2).toString());
//            txtQuantidadeDel.setText(DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 3).toString());
//            txtPrecoDel.setText(DeletedTable.getValueAt(DeletedTable.getSelectedRow(), 4).toString());
//        }
        
    }//GEN-LAST:event_DeletedTableMouseReleased

    private void BotaoBuscarDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarDelActionPerformed
        
        readSearch(txtBuscaDel.getText());
        
    }//GEN-LAST:event_BotaoBuscarDelActionPerformed

    private void BotaResetarBuscaDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaResetarBuscaDelActionPerformed
        
        txtBuscaDel.setText("");
        readTable();
        
    }//GEN-LAST:event_BotaResetarBuscaDelActionPerformed

    private void txtBuscaDelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaDelKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            readSearch(txtBuscaDel.getText());
        }
        
    }//GEN-LAST:event_txtBuscaDelKeyPressed

    private void UsuarioLogadotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioLogadotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioLogadotxtActionPerformed

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
            java.util.logging.Logger.getLogger(ViewProdutosDeletadosDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewProdutosDeletadosDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewProdutosDeletadosDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewProdutosDeletadosDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewProdutosDeletadosDB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaResetarBuscaDel;
    private javax.swing.JButton BotaoBuscarDel;
    private javax.swing.JButton BotaoCadastrarProdutos;
    private javax.swing.JButton BotaoHome;
    private javax.swing.JButton BotaoRestaurar;
    private javax.swing.JTable DeletedTable;
    private javax.swing.JTextField UsuarioLogadotxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtBuscaDel;
    // End of variables declaration//GEN-END:variables
}
