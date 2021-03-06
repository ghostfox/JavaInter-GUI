/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ser.jint.javainterui.gui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ser.jint.actions.AllItemsTableAction;
import ser.jint.actions.SelectedItemComboAction;
import ser.jint.bo.Items;
import ser.jint.bo.Order;
import ser.jint.bo.OrderDetail;
import ser.jint.bo.Validator;
import ser.jint.facade.OrderFacadeSubject;
import ser.jint.models.AllItemsTableModel;
import ser.jint.models.OtherModels;
import ser.jint.models.SelectedItemsTableModel;

/**
 *
 * @author Razor15
 */
public class CreateNewOrder extends javax.swing.JFrame {

    /**
     * Creates new form CreateNewOrder
     */
    private AllItemsTableModel allItemsTableModel;
    private SelectedItemsTableModel selectedItemsTableModel;
    private SelectedItemComboAction comboAction;
    private FocusListener listFocusListener;
    private AllItemsTableAction allItemsTableAction;

    public CreateNewOrder() {
        initComponents();
        centrarPantalla();
        initOtherElements();
    }

    private void initTable() {
        this.tblAllItems.setColumnModel(OtherModels.createColumnModelAll());

        Iterator<Items> itemsIterator = OrderFacadeSubject.getInstance()
                .getItemList().iterator();

        while (itemsIterator.hasNext()) {
            Items aux = itemsIterator.next();
            allItemsTableModel.addItems(aux.getItemDescription(), false);
        }

        this.tblAllItems.setModel(allItemsTableModel);
    }

    private void initOtherElements() {
        listFocusListener = new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                JComponent c = (JComponent) e.getComponent();
                c.scrollRectToVisible(
                        new Rectangle(0, 0, c.getWidth(), c.getHeight()));
            }
        };

        selectedItemsTableModel = new SelectedItemsTableModel();
        allItemsTableModel = new AllItemsTableModel();

        this.comboAction = new SelectedItemComboAction(
                selectedItemsTableModel,
                this.listFocusListener, allItemsTableModel);

        this.allItemsTableAction = new AllItemsTableAction(
                allItemsTableModel,
                selectedItemsTableModel);

        tblAllItems.addMouseListener(this.allItemsTableAction);
        tblSelectedItems.setModel(selectedItemsTableModel);
        tblSelectedItems.setColumnModel(OtherModels.createColumnModel());
        cmbSelected.addActionListener(this.comboAction);

        initTable();

        this.txtCreationDate.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                .format(new Date(System.currentTimeMillis())));
    }

    private void centrarPantalla() {
        Dimension tamFrame = this.getSize();//para obtener las dimensiones del frame
        Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();//para obtener el tamaño de la pantalla
        setLocation((tamPantalla.width - tamFrame.width) / 2, (tamPantalla.height - tamFrame.height) / 2);//para posicionar
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
        txtClientName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        cmbTipoDNI = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtOrderAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtOrderZipAddress = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCreationDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCrearOrden = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAllItems = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSelectedItems = new javax.swing.JTable();
        cmbSelected = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Creacion de Nueva Orden");
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Orden"));

        jLabel1.setText("Nombre Cliente");

        jLabel2.setText("DNI Cliente");

        cmbTipoDNI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DNI", "LE", "Pasaporte", "LC" }));

        jLabel3.setText("Direccion de Entrega");

        jLabel4.setText("Codigo Postal");

        jLabel5.setText("Fecha Creacion");

        txtCreationDate.setEditable(false);

        jLabel6.setText("Tipo DNI");

        btnCrearOrden.setText("Crear Orden");
        btnCrearOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearOrdenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrderAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTipoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtOrderZipAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(btnCrearOrden)))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtOrderAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtOrderZipAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCrearOrden))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTipoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tblAllItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAllItems);

        tblSelectedItems.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblSelectedItems);

        cmbSelected.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Libros", "Musica", "Electronica" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(cmbSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbSelected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createOrder() {
        String errors = "";
        int errorCount = 0;

        if (!Validator.isValidDNI(txtDNI.getText())) {
            errors = errors + "DNI incorrecto;";
            errorCount += 1;
        }

        if (Validator.isTextEmpty(txtClientName.getText())) {
            errors = errors + "Nombre Cliente;";
            errorCount += 1;
        }

        if (Validator.isTextEmpty(txtOrderAddress.getText())) {
            errors = errors + "Direccion de entrega;";
            errorCount += 1;
        }

        if (!Validator.isValidZipCode(txtOrderZipAddress.getText())) {
            errors = errors + "Codigo Postal Argentino;";
            errorCount += 1;
        }

        if (errorCount > 0) {
            JOptionPane.showMessageDialog(this, "Se encontraron los siguientes errores: " + "\n"
                                                + errors, "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Order newOrder = new Order();

            newOrder.setClientName(txtClientName.getText());
            newOrder.setClientIdentificationNumber(
                    new Integer(txtDNI.getText()));
            newOrder.setClientIdentificationType(
                    (String) cmbTipoDNI.getSelectedItem());

            newOrder.setOrderAddress(txtOrderAddress.getText());
            newOrder.setOrderZipAddress(txtOrderZipAddress.getText().toUpperCase());
            try {
                newOrder.setCreationDate(
                        new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
                        .parse(txtCreationDate.getText()));
            } catch (ParseException e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage(),
                        "Error en fecha", JOptionPane.ERROR_MESSAGE);
            }

            Iterator<String> iterator = selectedItemsTableModel.getItemsSelected();
            List<OrderDetail> details = new LinkedList<>();
            List<Items> buyItems;

            while (iterator.hasNext()) {
                String aux = iterator.next();
                buyItems = OrderFacadeSubject.getInstance()
                        .itemDescriptionSearch(aux);

                System.out.println("Item: " + aux + " = " + buyItems.size());

                if (buyItems.size() == 1) {
                    Items input = buyItems.get(0);
                    OrderDetail detail = new OrderDetail();
                    detail.setItem(input);
                    detail.setQuantity(selectedItemsTableModel.getValue(aux));
                    details.add(detail);
                }
            }

            OrderFacadeSubject.getInstance().updateData(newOrder, details);
        }
    }
    
    private void clear(){
        this.txtClientName.setText("");
        this.txtCreationDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
        this.txtDNI.setText("");
        this.txtOrderAddress.setText("");
        this.txtOrderZipAddress.setText("");
        allItemsTableModel = new AllItemsTableModel();
        this.tblSelectedItems.setModel(allItemsTableModel);
    }
    
    private void btnCrearOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearOrdenActionPerformed
        // TODO add your handling code here:
        createOrder();
        clear();
    }//GEN-LAST:event_btnCrearOrdenActionPerformed

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
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error cargando UI", JOptionPane.ERROR_MESSAGE);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateNewOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearOrden;
    private javax.swing.JComboBox cmbSelected;
    private javax.swing.JComboBox cmbTipoDNI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAllItems;
    private javax.swing.JTable tblSelectedItems;
    private javax.swing.JTextField txtClientName;
    private javax.swing.JTextField txtCreationDate;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtOrderAddress;
    private javax.swing.JTextField txtOrderZipAddress;
    // End of variables declaration//GEN-END:variables
}
