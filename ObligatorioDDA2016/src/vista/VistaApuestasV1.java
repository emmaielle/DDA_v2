/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorApuestas;
import controlador.VistaApuestas;
import java.util.ArrayList;
import modelo.Apuesta;
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
        getContentPane().setLayout(null);
        getContentPane().add(lbl_title);
        lbl_title.setBounds(266, 27, 193, 27);

        lista_Apuestas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lista_Apuestas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_ApuestasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista_Apuestas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(48, 102, 483, 206);

        lista_Apuestas_ENRONDA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(lista_Apuestas_ENRONDA);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(48, 369, 483, 206);

        jLabel1.setText("Apuestas en la ronda:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(48, 331, 106, 14);

        jLabel2.setText("Apuestas:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(48, 82, 49, 14);

        lbl_nroSorteado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_nroSorteado.setForeground(new java.awt.Color(255, 51, 51));
        lbl_nroSorteado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_nroSorteado);
        lbl_nroSorteado.setBounds(171, 331, 360, 26);

        setBounds(0, 0, 584, 628);
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
        lbl_nroSorteado.setText("Numero ganador: " + apuesta.getRonda().getNroGanador().getValor());
    }
}
