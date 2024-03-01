/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.torresdehanoi;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebastianholweger
 */
public class Grafico extends javax.swing.JFrame {

      int ContNumMov=0;
    Pila PilaTorreA;
    Pila PilaTorreB;
    Pila PilaTorreC;
    Pila PilaTorreD;
    
    DefaultTableModel ModeloTablaTorreA,ModeloTablaTorreB,ModeloTablaTorreC,ModeloTablaTorreD;
    int Objetivo=0;
    double NumMinMov=0;
    boolean Stop=false;
    
    /**
     * Creates new form Principal
     */
    public Grafico() {
        initComponents();
        ModeloTablaTorreA= (DefaultTableModel) TorreA.getModel();
        ModeloTablaTorreA.setRowCount(10);
        
        ModeloTablaTorreB= (DefaultTableModel) TorreB.getModel();
        ModeloTablaTorreB.setRowCount(10);
        
        ModeloTablaTorreC= (DefaultTableModel) TorreC.getModel();
        ModeloTablaTorreC.setRowCount(10);
        
        ModeloTablaTorreD= (DefaultTableModel) TorreD.getModel();
        ModeloTablaTorreD.setRowCount(10);
        
        DefaultTableCellRenderer renderA=new DefaultTableCellRenderer();
        renderA.setHorizontalAlignment(SwingConstants.CENTER);
        TorreA.getColumnModel().getColumn(0).setCellRenderer(renderA);
        
        DefaultTableCellRenderer renderB=new DefaultTableCellRenderer();
        renderB.setHorizontalAlignment(SwingConstants.CENTER);
        TorreB.getColumnModel().getColumn(0).setCellRenderer(renderB);
        
        DefaultTableCellRenderer renderC=new DefaultTableCellRenderer();
        renderC.setHorizontalAlignment(SwingConstants.CENTER);
        TorreC.getColumnModel().getColumn(0).setCellRenderer(renderC);
        
        DefaultTableCellRenderer renderD=new DefaultTableCellRenderer();
        renderD.setHorizontalAlignment(SwingConstants.CENTER);
        TorreD.getColumnModel().getColumn(0).setCellRenderer(renderD);
    }
    private void Limpiar(){
        
        ContNumMov=0;
        NumMinMov=0;
        CbNumDiscos.setSelectedItem(String.valueOf(Objetivo));
    }
    
    private void PresentarCantMov(){
        ContNumMov++;
        LblNumMov.setText(String.valueOf(ContNumMov));
    }
    private void Reiniciar(){
                
                Limpiar();
                Iniciar();
    }
    private void Iniciar() {
    try {
        PilaTorreA = new Pila();
        PilaTorreB = new Pila();
        PilaTorreC = new Pila();
        PilaTorreD = new Pila();
        Objetivo = Integer.parseInt(CbNumDiscos.getSelectedItem().toString());

        // Corregir el cálculo de NumMinMov
        NumMinMov = (int) Math.pow(2, Objetivo) - 1;

        LblNumMov.setText(String.valueOf(ContNumMov));
//        LblMinMov.setText(String.valueOf(NumMinMov));

        for (int x = Objetivo; x >= 1; x--) {
            Nodo Plataforma = new Nodo();
            String Disco = "";
            for (int y = x; y > 0; y--) {
                Disco += "#";
            }
            Plataforma.setDato(Disco);
            PilaTorreA.Push(Plataforma);
        }
        PresentarTorreA();
        PresentarTorreB();
        PresentarTorreC();
        PresentarTorreD();
    } catch (Exception E) {
        System.out.println("Error" + E.getMessage());
    }
}

    
    private void PresentarTorreA(){
        ((DefaultTableModel)TorreA.getModel()).setRowCount(0);
        ModeloTablaTorreA.setRowCount(10);
        Nodo K;
        int RowDisco=(10-PilaTorreA.getContNodo());
        if(PilaTorreA.getContNodo()>0){
            for(K=PilaTorreA.getCabeza();K.getAbajo()!=null;K=K.getAbajo()){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            if(K.getAbajo()==null){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreA.insertRow(RowDisco, VectorNormal);
            }
        }
        TorreA.setModel(ModeloTablaTorreA);
        ModeloTablaTorreA.setRowCount(10);
    }
    
    private void PresentarTorreB(){
        ((DefaultTableModel)TorreB.getModel()).setRowCount(0);
        ModeloTablaTorreB.setRowCount(10);
        Nodo K;
        int RowDisco=(10-PilaTorreB.getContNodo());
        if(PilaTorreB.getContNodo()>0){
            for(K=PilaTorreB.getCabeza();K.getAbajo()!=null;K=K.getAbajo()){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            if(K.getAbajo()==null){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreB.insertRow(RowDisco, VectorNormal);
            }
        }
        TorreB.setModel(ModeloTablaTorreB);
        ModeloTablaTorreB.setRowCount(10);
    }
    private void PresentarTorreC(){
        ((DefaultTableModel)TorreC.getModel()).setRowCount(0);
        ModeloTablaTorreC.setRowCount(10);
        Nodo K;
        int RowDisco=(10-PilaTorreC.getContNodo());
        if(PilaTorreC.getContNodo()>0){
            for(K=PilaTorreC.getCabeza();K.getAbajo()!=null;K=K.getAbajo()){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            if(K.getAbajo()==null){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreC.insertRow(RowDisco, VectorNormal);
            }
        }
        TorreC.setModel(ModeloTablaTorreC);
        ModeloTablaTorreC.setRowCount(10);
    }
    private void PresentarTorreD(){
        ((DefaultTableModel)TorreD.getModel()).setRowCount(0);
        ModeloTablaTorreD.setRowCount(10);
        Nodo K;
        int RowDisco=(10-PilaTorreD.getContNodo());
        if(PilaTorreD.getContNodo()>0){
            for(K=PilaTorreD.getCabeza();K.getAbajo()!=null;K=K.getAbajo()){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreD.insertRow(RowDisco, VectorNormal);
                RowDisco++;
            }
            if(K.getAbajo()==null){
                String[] VectorNormal={K.getDato()};
                ModeloTablaTorreD.insertRow(RowDisco, VectorNormal);
            }
        }
        TorreD.setModel(ModeloTablaTorreD);
        ModeloTablaTorreD.setRowCount(10);
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
        TorreC = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TorreB = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TorreD = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TorreA = new javax.swing.JTable();
        BtnA_B = new javax.swing.JButton();
        BtnA_D = new javax.swing.JButton();
        BtnA_C = new javax.swing.JButton();
        BtnB_A = new javax.swing.JButton();
        BtnB_C = new javax.swing.JButton();
        BtnB_D = new javax.swing.JButton();
        BtnC_D = new javax.swing.JButton();
        BtnC_B = new javax.swing.JButton();
        BtnC_A = new javax.swing.JButton();
        BtnD_C = new javax.swing.JButton();
        BtnD_B = new javax.swing.JButton();
        BtnD_A = new javax.swing.JButton();
        CbNumDiscos = new javax.swing.JComboBox<>();
        LblNumMov = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BtnResolver = new javax.swing.JButton();
        BtnIniciar = new javax.swing.JButton();
        BtnReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TorreC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre C"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreC.setAutoscrolls(false);
        TorreC.setFocusable(false);
        TorreC.setRowSelectionAllowed(false);
        TorreC.setShowGrid(false);
        jScrollPane1.setViewportView(TorreC);
        if (TorreC.getColumnModel().getColumnCount() > 0) {
            TorreC.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre B"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreB.setAutoscrolls(false);
        TorreB.setFocusable(false);
        TorreB.setRowSelectionAllowed(false);
        TorreB.setShowGrid(false);
        jScrollPane2.setViewportView(TorreB);
        if (TorreB.getColumnModel().getColumnCount() > 0) {
            TorreB.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre D"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreD.setAutoscrolls(false);
        TorreD.setFocusable(false);
        TorreD.setRowSelectionAllowed(false);
        TorreD.setShowGrid(false);
        jScrollPane3.setViewportView(TorreD);
        if (TorreD.getColumnModel().getColumnCount() > 0) {
            TorreD.getColumnModel().getColumn(0).setResizable(false);
        }

        TorreA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Torre A"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TorreA.setAutoscrolls(false);
        TorreA.setFocusable(false);
        TorreA.setRowSelectionAllowed(false);
        TorreA.setShowGrid(false);
        jScrollPane4.setViewportView(TorreA);
        if (TorreA.getColumnModel().getColumnCount() > 0) {
            TorreA.getColumnModel().getColumn(0).setResizable(false);
        }

        BtnA_B.setText("B");
        BtnA_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_BActionPerformed(evt);
            }
        });

        BtnA_D.setText("D");
        BtnA_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_DActionPerformed(evt);
            }
        });

        BtnA_C.setText("C");
        BtnA_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnA_CActionPerformed(evt);
            }
        });

        BtnB_A.setText("A");
        BtnB_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_AActionPerformed(evt);
            }
        });

        BtnB_C.setText("C");
        BtnB_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_CActionPerformed(evt);
            }
        });

        BtnB_D.setText("D");
        BtnB_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnB_DActionPerformed(evt);
            }
        });

        BtnC_D.setText("D");
        BtnC_D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_DActionPerformed(evt);
            }
        });

        BtnC_B.setText("B");
        BtnC_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_BActionPerformed(evt);
            }
        });

        BtnC_A.setText("A");
        BtnC_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnC_AActionPerformed(evt);
            }
        });

        BtnD_C.setText("C");
        BtnD_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnD_CActionPerformed(evt);
            }
        });

        BtnD_B.setText("B");
        BtnD_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnD_BActionPerformed(evt);
            }
        });

        BtnD_A.setText("A");
        BtnD_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnD_AActionPerformed(evt);
            }
        });

        CbNumDiscos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10" }));
        CbNumDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbNumDiscosActionPerformed(evt);
            }
        });

        LblNumMov.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        LblNumMov.setForeground(new java.awt.Color(0, 204, 51));
        LblNumMov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblNumMov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Al Nile", 3, 13)); // NOI18N
        jLabel4.setText("No. de Discos");

        jLabel5.setFont(new java.awt.Font("Al Nile", 3, 13)); // NOI18N
        jLabel5.setText("Cant. Movimientos");

        BtnResolver.setFont(new java.awt.Font("Helvetica Neue", 3, 15)); // NOI18N
        BtnResolver.setText("Resolver");
        BtnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResolverActionPerformed(evt);
            }
        });

        BtnIniciar.setFont(new java.awt.Font("Helvetica Neue", 3, 15)); // NOI18N
        BtnIniciar.setText("Iniciar");
        BtnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarActionPerformed(evt);
            }
        });

        BtnReiniciar.setFont(new java.awt.Font("Helvetica Neue", 3, 15)); // NOI18N
        BtnReiniciar.setText("Reiniciar");
        BtnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BtnA_B, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnA_C, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(BtnA_D, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnB_A, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnB_C, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnB_D, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(BtnC_A, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(BtnC_B, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(12, 12, 12)
                                    .addComponent(BtnC_D, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnD_A, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnD_B, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnD_C, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(101, 101, 101))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(LblNumMov, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(80, 80, 80)
                                                .addComponent(CbNumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BtnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(BtnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnD_A, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnD_B, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnD_C, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnA_D, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnB_A, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnB_C, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnB_D, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnA_B, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BtnA_C, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnC_A, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnC_B, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnC_D, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbNumDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LblNumMov, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void MoverA_B(){
        try{
            if(PilaTorreA.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreB.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreB.Peek())>0){
                        return;
                    }
                }
                PilaTorreA.Pop();
                PilaTorreB.Push(Plataforma);
                PresentarTorreA();
                PresentarTorreB();
                PresentarCantMov();
            }
        }catch(Exception E){
            System.out.println("Error"+E.getMessage());
        }
    }
    private void BtnA_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_BActionPerformed
       MoverA_B();
    }//GEN-LAST:event_BtnA_BActionPerformed
private void MoverA_D(){
        try{
            if(PilaTorreA.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreD.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreD.Peek())>0){
                        return;
                    }
                }
                PilaTorreA.Pop();
                PilaTorreD.Push(Plataforma);
                PresentarTorreA();
                PresentarTorreD();
                PresentarCantMov();
                if(PilaTorreD.getContNodo()==Objetivo && ContNumMov==NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo minimo de Movimientos","Felicitaciones",JOptionPane.WARNING_MESSAGE);
                }else if(PilaTorreD.getContNodo()==Objetivo &&ContNumMov!=NumMinMov){
                    JOptionPane.showMessageDialog(null, "Felicidades has resuelto\n\nIntenta superar el objetivo minimo de movimientos","Felicitaciones",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    private void BtnA_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_DActionPerformed
       MoverA_D();
    }//GEN-LAST:event_BtnA_DActionPerformed
private void MoverA_C(){
        try{
            if(PilaTorreA.getContNodo()>0){
                Nodo Plataforma=new Nodo();
                
                Plataforma.setDato(PilaTorreA.Peek());
                
                if(PilaTorreC.getContNodo()>0){
                    
                    if(Plataforma.getDato().compareTo(PilaTorreC.Peek())>0){
                        return;
                    }
                }
                PilaTorreA.Pop();
                PilaTorreC.Push(Plataforma);
                PresentarTorreA();
                PresentarTorreC();
                PresentarCantMov();
               
            }
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
    }
    private void BtnA_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnA_CActionPerformed
       MoverA_C();
    }//GEN-LAST:event_BtnA_CActionPerformed
    private void MoverB_A() {
      try {
        if (PilaTorreB.getContNodo() > 0) {
          Nodo Plataforma = new Nodo();

          Plataforma.setDato(PilaTorreB.Peek());

          if (PilaTorreA.getContNodo() > 0) {

            if (Plataforma.getDato().compareTo(PilaTorreA.Peek()) > 0) {
              return;
            }
          }
          PilaTorreB.Pop();
          PilaTorreA.Push(Plataforma);
          PresentarTorreA();
          PresentarTorreB();
          PresentarCantMov();
        }
      } catch (Exception E) {
        System.out.println("Error" + E.getMessage());
      }
    }
    private void BtnB_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_AActionPerformed
        MoverB_A();
    }//GEN-LAST:event_BtnB_AActionPerformed
   private void MoverB_C() {
     try {
       if (PilaTorreB.getContNodo() > 0) {
         Nodo Plataforma = new Nodo();

         Plataforma.setDato(PilaTorreB.Peek());

         if (PilaTorreC.getContNodo() > 0) {

           if (Plataforma.getDato().compareTo(PilaTorreC.Peek()) > 0) {
             return;
           }
         }
         PilaTorreB.Pop();
         PilaTorreC.Push(Plataforma);
         PresentarTorreB();
         PresentarTorreC();
         PresentarCantMov();

       }
     } catch (Exception e) {
       System.out.println("Error" + e.getMessage());
     }
   }
    private void BtnB_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_CActionPerformed
        MoverB_C();
    }//GEN-LAST:event_BtnB_CActionPerformed
  private void MoverB_D() {
    try {
      if (PilaTorreB.getContNodo() > 0) {
        Nodo Plataforma = new Nodo();

        Plataforma.setDato(PilaTorreB.Peek());

        if (PilaTorreD.getContNodo() > 0) {

          if (Plataforma.getDato().compareTo(PilaTorreD.Peek()) > 0) {
            return;
          }
        }
        PilaTorreB.Pop();
        PilaTorreD.Push(Plataforma);
        PresentarTorreB();
        PresentarTorreD();
        PresentarCantMov();
        if (PilaTorreD.getContNodo() == Objetivo && ContNumMov == NumMinMov) {
          JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo minimo de Movimientos", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
        } else if (PilaTorreD.getContNodo() == Objetivo && ContNumMov != NumMinMov) {
          JOptionPane.showMessageDialog(null, "Felicidades has resuelto\n\nIntenta superar el objetivo minimo de movimientos", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
        }
      }
    } catch (Exception e) {
      System.out.println("Error" + e.getMessage());
    }
  }
    private void BtnB_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnB_DActionPerformed
        MoverB_D();
    }//GEN-LAST:event_BtnB_DActionPerformed
   private void MoverC_D() {
     try {
       if (PilaTorreC.getContNodo() > 0) {
         Nodo Plataforma = new Nodo();

         Plataforma.setDato(PilaTorreC.Peek());

         if (PilaTorreD.getContNodo() > 0) {

           if (Plataforma.getDato().compareTo(PilaTorreD.Peek()) > 0) {
             return;
           }
         }
         PilaTorreC.Pop();
         PilaTorreD.Push(Plataforma);
         PresentarTorreC();
         PresentarTorreD();
         PresentarCantMov();
         if (PilaTorreD.getContNodo() == Objetivo && ContNumMov == NumMinMov) {
           JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo minimo de Movimientos", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
         } else if (PilaTorreD.getContNodo() == Objetivo && ContNumMov != NumMinMov) {
           JOptionPane.showMessageDialog(null, "Felicidades has resuelto\n\nIntenta superar el objetivo minimo de movimientos", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
         }
       }
     } catch (Exception e) {
       System.out.println("Error" + e.getMessage());
     }
   }
    private void BtnC_DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_DActionPerformed
        MoverC_D();
    }//GEN-LAST:event_BtnC_DActionPerformed
private void MoverC_B() {
  try {
    if (PilaTorreC.getContNodo() > 0) {
      Nodo Plataforma = new Nodo();

      Plataforma.setDato(PilaTorreC.Peek());

      if (PilaTorreA.getContNodo() > 0) {

        if (Plataforma.getDato().compareTo(PilaTorreA.Peek()) > 0) {
          return;
        }
      }
      PilaTorreC.Pop();
      PilaTorreA.Push(Plataforma);
      PresentarTorreA();
      PresentarTorreC();
      PresentarCantMov();
    }
  } catch (Exception E) {
    System.out.println("Error" + E.getMessage());
  }
}
    private void BtnC_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_BActionPerformed
        MoverC_B();
    }//GEN-LAST:event_BtnC_BActionPerformed
    private void MoverC_A() {
      try {
        if (PilaTorreC.getContNodo() > 0) {
          Nodo Plataforma = new Nodo();

          Plataforma.setDato(PilaTorreC.Peek());

          if (PilaTorreA.getContNodo() > 0) {

            if (Plataforma.getDato().compareTo(PilaTorreA.Peek()) > 0) {
              return;
            }
          }
          PilaTorreC.Pop();
          PilaTorreA.Push(Plataforma);
          PresentarTorreA();
          PresentarTorreC();
          PresentarCantMov();
        }
      } catch (Exception E) {
        System.out.println("Error" + E.getMessage());
      }
    }
    private void BtnC_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnC_AActionPerformed
        MoverC_A();
    }//GEN-LAST:event_BtnC_AActionPerformed
private void MoverD_C() {
  try {
    if (PilaTorreD.getContNodo() > 0) {
      Nodo Plataforma = new Nodo();

      Plataforma.setDato(PilaTorreD.Peek());

      if (PilaTorreC.getContNodo() > 0) {

        if (Plataforma.getDato().compareTo(PilaTorreC.Peek()) > 0) {
          return;
        }
      }
      PilaTorreD.Pop();
      PilaTorreC.Push(Plataforma);
      PresentarTorreC();
      PresentarTorreD();
      PresentarCantMov();
      if (PilaTorreD.getContNodo() == Objetivo && ContNumMov == NumMinMov) {
        JOptionPane.showMessageDialog(null, "Felicidades has alcanzado el objetivo minimo de Movimientos", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
      } else if (PilaTorreD.getContNodo() == Objetivo && ContNumMov != NumMinMov) {
        JOptionPane.showMessageDialog(null, "Felicidades has resuelto\n\nIntenta superar el objetivo minimo de movimientos", "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
      }
    }
  } catch (Exception e) {
    System.out.println("Error" + e.getMessage());
  }
}
    private void BtnD_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnD_CActionPerformed
        MoverD_C();
    }//GEN-LAST:event_BtnD_CActionPerformed
private void MoverD_B() {
  try {
    if (PilaTorreD.getContNodo() > 0) {
      Nodo Plataforma = new Nodo();

      Plataforma.setDato(PilaTorreD.Peek());

      if (PilaTorreB.getContNodo() > 0) {

        if (Plataforma.getDato().compareTo(PilaTorreB.Peek()) > 0) {
          return;
        }
      }
      PilaTorreD.Pop();
      PilaTorreB.Push(Plataforma);
      PresentarTorreD();
      PresentarTorreB();
      PresentarCantMov();
    }
  } catch (Exception E) {
    System.out.println("Error" + E.getMessage());
  }
}
    private void BtnD_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnD_BActionPerformed
        MoverD_B();
    }//GEN-LAST:event_BtnD_BActionPerformed
private void MoverD_A() {
  try {
    if (PilaTorreD.getContNodo() > 0) {
      Nodo Plataforma = new Nodo();

      Plataforma.setDato(PilaTorreD.Peek());

      if (PilaTorreA.getContNodo() > 0) {

        if (Plataforma.getDato().compareTo(PilaTorreA.Peek()) > 0) {
          return;
        }
      }
      PilaTorreD.Pop();
      PilaTorreA.Push(Plataforma);
      PresentarTorreA();
      PresentarTorreD();
      PresentarCantMov();
    }
  } catch (Exception E) {
    System.out.println("Error" + E.getMessage());
  }
}
    private void BtnD_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnD_AActionPerformed
        MoverD_A();
    }//GEN-LAST:event_BtnD_AActionPerformed

    private void CbNumDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbNumDiscosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbNumDiscosActionPerformed

    private void BtnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarActionPerformed
        ContNumMov=0;
        Iniciar();
    }//GEN-LAST:event_BtnIniciarActionPerformed

    private void BtnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReiniciarActionPerformed
        Reiniciar();
    }//GEN-LAST:event_BtnReiniciarActionPerformed
 private void MoverPlataforma(Pila Origen, Pila Destino) {
   if (!Stop) {
     Nodo Plataforma = new Nodo();
     Plataforma.setDato(Origen.Peek());
     Origen.Pop();
     Destino.Push(Plataforma);
     PresentarTorreA();
     PresentarTorreB();
     PresentarTorreC();
     PresentarTorreD();

     PresentarCantMov();
     JOptionPane pane = new JOptionPane("Paso #" + LblNumMov.getText() + "\n\n¿Continuar?", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
     JDialog dialog = pane.createDialog("Numero de pasos");
     dialog.setLocation(600, 400);
     dialog.setVisible(true);
     int op = (int) pane.getValue();
     if (op == JOptionPane.NO_OPTION) {
       Stop = true;
     }
   }
 }

 private void ResolverHanoi(int n, Pila Origen, Pila Auxiliar1, Pila Auxiliar2, Pila Destino) {
   if (n == 1) {
     MoverPlataforma(Origen, Destino);
   } else if (n == 2) {
     MoverPlataforma(Origen, Auxiliar1);
     MoverPlataforma(Origen, Destino);
     MoverPlataforma(Auxiliar1, Destino);
   } else {
     ResolverHanoi(n - 2, Origen, Auxiliar2, Destino, Auxiliar1);
     MoverPlataforma(Origen, Auxiliar2);
     MoverPlataforma(Origen, Destino);
     MoverPlataforma(Auxiliar2, Destino);
     ResolverHanoi(n - 2, Auxiliar1, Origen, Auxiliar2, Destino);
   }
 }
    private void BtnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResolverActionPerformed
           Reiniciar();
           Stop=false;
           ResolverHanoi(Objetivo,PilaTorreA,PilaTorreB,PilaTorreC,PilaTorreD);
    }//GEN-LAST:event_BtnResolverActionPerformed

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
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grafico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grafico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnA_B;
    private javax.swing.JButton BtnA_C;
    private javax.swing.JButton BtnA_D;
    private javax.swing.JButton BtnB_A;
    private javax.swing.JButton BtnB_C;
    private javax.swing.JButton BtnB_D;
    private javax.swing.JButton BtnC_A;
    private javax.swing.JButton BtnC_B;
    private javax.swing.JButton BtnC_D;
    private javax.swing.JButton BtnD_A;
    private javax.swing.JButton BtnD_B;
    private javax.swing.JButton BtnD_C;
    private javax.swing.JButton BtnIniciar;
    private javax.swing.JButton BtnReiniciar;
    private javax.swing.JButton BtnResolver;
    private javax.swing.JComboBox<String> CbNumDiscos;
    private javax.swing.JLabel LblNumMov;
    private javax.swing.JTable TorreA;
    private javax.swing.JTable TorreB;
    private javax.swing.JTable TorreC;
    private javax.swing.JTable TorreD;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
