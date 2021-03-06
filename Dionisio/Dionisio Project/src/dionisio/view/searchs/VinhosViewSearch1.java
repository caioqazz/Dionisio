/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dionisio.view.searchs;

import dionisio.model.bean.Vinho;
import dionisio.model.dao.VinhoDAO;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Caio
 */
public class VinhosViewSearch1 extends javax.swing.JInternalFrame {

    ArrayList<byte[]> rotulos;

    /**
     * Creates new form VinhosViewSearch1
     */
    public VinhosViewSearch1() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTVinhos.getModel();
        jTVinhos.setRowSorter(new TableRowSorter(modelo));
        readJTable();
        setImage();
    }

    public void setImage() {

        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/dionisio/icon/wine_1.png")));
    }

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTVinhos.getModel();
        modelo.setNumRows(0);
        VinhoDAO vdao = new VinhoDAO();
        ArrayList<Vinho> lista = vdao.read();
        for (int i = 0; i < lista.size(); i++) {
            modelo.addRow(new Object[]{
                lista.get(i).getId(),
                lista.get(i).getNome(),
                lista.get(i).getClassificacao(),});
        }
        rotulos = new ArrayList<byte[]>();
        for (int i = 0; i < lista.size(); i++) {

            rotulos.add(lista.get(i).getRotulo());
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVinhos = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Todos os vinhos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "Todos os vinhos produzidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jTVinhos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Classificação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTVinhos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTVinhosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTVinhos);

        jLabel11.setText("Rotulo");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Selecione para visualizar");
        jLabel12.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTVinhosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVinhosMouseClicked
        if (jTVinhos.getSelectedRow() >= 0) {

            setImage(jTVinhos.getSelectedRow());

        }
    }//GEN-LAST:event_jTVinhosMouseClicked
    void setImage(int index) {

        if (rotulos.get(index) != null) {
            ImageIcon icone = new ImageIcon(rotulos.get(index));

            icone.setImage(icone.getImage().getScaledInstance(jLabel12.getWidth() - 5, jLabel12.getHeight() - 10, 100));
            jLabel12.setText("");
            jLabel12.setIcon(icone);
        } else {
            jLabel12.setIcon(null);
            jLabel12.setText("Não possui");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTVinhos;
    // End of variables declaration//GEN-END:variables
}
