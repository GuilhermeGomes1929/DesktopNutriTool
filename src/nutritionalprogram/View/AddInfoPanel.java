/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutritionalprogram.View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import nutritionalprogram.Controller.AddInfoController;

/**
 *
 * @author Luana Franciele
 */
public class AddInfoPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddInfoPanel
     */
    
    private String patientName;
    private AddInfoController controller;
    private JScrollPane scrollPanel;
    
    
    public AddInfoPanel(String patientName, JScrollPane scrollPanel) {
        this.patientName = patientName;
        this.scrollPanel = scrollPanel;
        
        initComponents();
        controller = new AddInfoController(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientBaseInfos = new javax.swing.JPanel();
        jLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        patientWeightInfos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        currentWeightSpinner = new javax.swing.JSpinner();
        goalWeightSpinner = new javax.swing.JSpinner();
        bodyfatSpinner = new javax.swing.JSpinner();
        jLabel15 = new javax.swing.JLabel();
        patientMeasuresInfos = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        shouldersSpinner = new javax.swing.JSpinner();
        chestSpinner = new javax.swing.JSpinner();
        leftArmSpinner = new javax.swing.JSpinner();
        rightArmSpinner = new javax.swing.JSpinner();
        waistSpinner = new javax.swing.JSpinner();
        hipSpinner = new javax.swing.JSpinner();
        rightLegSpinner = new javax.swing.JSpinner();
        leftLegSpinner = new javax.swing.JSpinner();
        rightCalfSpinner = new javax.swing.JSpinner();
        leftCalfSpinner = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(115, 232, 255));
        setOpaque(false);

        patientBaseInfos.setBackground(new java.awt.Color(41, 182, 246));
        patientBaseInfos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel.setText("Nome:");

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        nameLabel.setText("Nome");

        javax.swing.GroupLayout patientBaseInfosLayout = new javax.swing.GroupLayout(patientBaseInfos);
        patientBaseInfos.setLayout(patientBaseInfosLayout);
        patientBaseInfosLayout.setHorizontalGroup(
            patientBaseInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientBaseInfosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        patientBaseInfosLayout.setVerticalGroup(
            patientBaseInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientBaseInfosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patientBaseInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        patientWeightInfos.setBackground(new java.awt.Color(115, 232, 255));
        patientWeightInfos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Atual:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Meta:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Taxa de gordura corporal:");

        double current = 0.0;
        double min = -100.0;
        double max = 100.0;
        double step = 0.01;

        currentWeightSpinner.setModel(new SpinnerNumberModel(current, min, max, step));

        goalWeightSpinner.setModel(new SpinnerNumberModel(current, min, max, step));

        bodyfatSpinner.setModel(new SpinnerNumberModel(current, min, max, step));

        jLabel15.setBackground(new java.awt.Color(41, 182, 246));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("     Composição corporal");
        jLabel15.setOpaque(true);

        javax.swing.GroupLayout patientWeightInfosLayout = new javax.swing.GroupLayout(patientWeightInfos);
        patientWeightInfos.setLayout(patientWeightInfosLayout);
        patientWeightInfosLayout.setHorizontalGroup(
            patientWeightInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
            .addGroup(patientWeightInfosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(patientWeightInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(patientWeightInfosLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(goalWeightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(patientWeightInfosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(currentWeightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(117, 117, 117)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bodyfatSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        patientWeightInfosLayout.setVerticalGroup(
            patientWeightInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientWeightInfosLayout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(patientWeightInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(currentWeightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(bodyfatSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(patientWeightInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(goalWeightSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        patientMeasuresInfos.setBackground(new java.awt.Color(115, 232, 255));
        patientMeasuresInfos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        patientMeasuresInfos.setPreferredSize(new java.awt.Dimension(0, 143));

        jLabel9.setBackground(new java.awt.Color(41, 182, 246));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("     Medidas");
        jLabel9.setOpaque(true);

        shouldersSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        chestSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        leftArmSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        rightArmSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        waistSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        hipSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        rightLegSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        leftLegSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        rightCalfSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        leftCalfSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Ombros:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Peitoral:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Braço e.:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Braço d.:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Cintura:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Perna d.:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Perna e.:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Panturrilha d.:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Panturrilha e.:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Quadril:");

        javax.swing.GroupLayout patientMeasuresInfosLayout = new javax.swing.GroupLayout(patientMeasuresInfos);
        patientMeasuresInfos.setLayout(patientMeasuresInfosLayout);
        patientMeasuresInfosLayout.setHorizontalGroup(
            patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientMeasuresInfosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chestSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(waistSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftArmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shouldersSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightArmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(patientMeasuresInfosLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel17))
                    .addGroup(patientMeasuresInfosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel21))
                    .addGroup(patientMeasuresInfosLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel18))
                    .addComponent(jLabel20)
                    .addGroup(patientMeasuresInfosLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftCalfSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightCalfSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftLegSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightLegSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hipSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        patientMeasuresInfosLayout.setVerticalGroup(
            patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patientMeasuresInfosLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shouldersSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hipSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chestSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightLegSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftArmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftLegSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightArmSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rightCalfSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(patientMeasuresInfosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(waistSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftCalfSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel20))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        saveBtn.setText("Salvar");

        cancelBtn.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientBaseInfos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientWeightInfos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(patientMeasuresInfos, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patientBaseInfos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(patientWeightInfos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(patientMeasuresInfos, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public String getPatientName(){
        return patientName;
    }
    
    
    public JScrollPane getScrollPanel(){
        return scrollPanel;
    }
    
    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }
    
    public JSpinner getBodyfatSpinner() {
        return bodyfatSpinner;
    }

    public JSpinner getChestSpinner() {
        return chestSpinner;
    }

    public JSpinner getCurrentWeightSpinner() {
        return currentWeightSpinner;
    }

    public JSpinner getGoalWeightSpinner() {
        return goalWeightSpinner;
    }

    public JSpinner getHipSpinner() {
        return hipSpinner;
    }

    public JSpinner getLeftArmSpinner() {
        return leftArmSpinner;
    }

    public JSpinner getLeftCalfSpinner() {
        return leftCalfSpinner;
    }

    public JSpinner getLeftLegSpinner() {
        return leftLegSpinner;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JSpinner getRightArmSpinner() {
        return rightArmSpinner;
    }

    public JSpinner getRightCalfSpinner() {
        return rightCalfSpinner;
    }

    public JSpinner getRightLegSpinner() {
        return rightLegSpinner;
    }

    public JSpinner getShouldersSpinner() {
        return shouldersSpinner;
    }

    public JSpinner getWaistSpinner() {
        return waistSpinner;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner bodyfatSpinner;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JSpinner chestSpinner;
    private javax.swing.JSpinner currentWeightSpinner;
    private javax.swing.JSpinner goalWeightSpinner;
    private javax.swing.JSpinner hipSpinner;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner leftArmSpinner;
    private javax.swing.JSpinner leftCalfSpinner;
    private javax.swing.JSpinner leftLegSpinner;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel patientBaseInfos;
    private javax.swing.JPanel patientMeasuresInfos;
    private javax.swing.JPanel patientWeightInfos;
    private javax.swing.JSpinner rightArmSpinner;
    private javax.swing.JSpinner rightCalfSpinner;
    private javax.swing.JSpinner rightLegSpinner;
    private javax.swing.JButton saveBtn;
    private javax.swing.JSpinner shouldersSpinner;
    private javax.swing.JSpinner waistSpinner;
    // End of variables declaration//GEN-END:variables
}
