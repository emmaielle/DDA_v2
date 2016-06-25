/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorApuestas;
import controlador.VistaApuestas;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Jugador;
import modelo.JugadorRuleta;

/**
 *
 * @author Moi
 */
public class VistaApuestasV1 extends javax.swing.JDialog implements VistaApuestas{

    private ControladorApuestas controlador;
    
    public VistaApuestasV1(JugadorRuleta j) {
        initComponents();
        controlador = new ControladorApuestas(j);
        lbl_title.setText("Apuestas de " + j.getJugador().getNombreCompleto());
        mostrarApuestas(controlador.cargarApuestas());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_Apuestas = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_Apuestas_ENRONDA = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_nroSorteado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lista_Apuestas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lista_Apuestas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_ApuestasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista_Apuestas);

        lista_Apuestas_ENRONDA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(lista_Apuestas_ENRONDA);

        jLabel1.setText("Apuestas en la ronda:");

        jLabel2.setText("Apuestas:");

        lbl_nroSorteado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_nroSorteado.setForeground(new java.awt.Color(255, 51, 51));
        lbl_nroSorteado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_nroSorteado, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbl_title, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_nroSorteado, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lista_ApuestasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_ApuestasValueChanged
        mostrarApuestasPorRonda(controlador.cargarApuestasPorRonda((Apuesta)lista_Apuestas.getSelectedValue()));
        mostrarNumeroSorteado((Apuesta)lista_Apuestas.getSelectedValue());
    }//GEN-LAST:event_lista_ApuestasValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_nroSorteado;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JList lista_Apuestas;
    private javax.swing.JList lista_Apuestas_ENRONDA;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarApuestas(ArrayList<Apuesta> apuestas) {
        ArrayList<String> formateado = new ArrayList<>();
//        if (apuestas != null && !apuestas.isEmpty()){
//           
//                formateado.add(tmp);
//            }
//        }
        lista_Apuestas.setListData(apuestas.toArray());
    }


    @Override
    public void mostrarApuestasPorRonda(ArrayList<Apuesta> apuestas) {
        ArrayList<String> apuestasString = formatApuestas(apuestas);
        lista_Apuestas_ENRONDA.setListData(apuestasString.toArray());
    }

    private ArrayList<String> formatApuestas(ArrayList<Apuesta> apuestas) {
        ArrayList<String> out = new ArrayList<>();
        for (Apuesta a: apuestas){
            String tmp = "Jugador: " + a.getJugador().getJugador().getNombreCompleto() + 
                    "; Apuesta: " + a.getNumero() + 
                    "; Monto ganado: " + a.getMontoGanado();
            out.add(tmp);
        }
        return out;
    }

    private void mostrarNumeroSorteado(Apuesta apuesta) {
        lbl_nroSorteado.setText("Numero ganador: " + apuesta.getRonda().getNroGanador());
    }
}
