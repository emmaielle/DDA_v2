/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorMesa;
import exceptions.InvalidUserActionException;
import java.awt.Color;
import java.util.ArrayList;
import modelo.JugadorRuleta;

/**
 *
 * @author Euge
 */
public class PanelDatos extends javax.swing.JPanel {

    ControladorMesa controlador;
    
    public PanelDatos(ControladorMesa c) {
        initComponents();
        controlador = c;
        txt_valorApuesta.setText("0");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaJugadores = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        nroSorteado = new javax.swing.JLabel();
        txt_valorApuesta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_finalizarA = new javax.swing.JButton();
        lbl_saldo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_total_apostado = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        lbl_mensajes = new javax.swing.JLabel();
        lbl_total_apostado1 = new javax.swing.JLabel();
        lbl_totalApostadoRonda = new javax.swing.JLabel();
        lbl_color = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Numero Sorteado: ");
        add(jLabel1);
        jLabel1.setBounds(10, 20, 120, 14);

        jScrollPane1.setViewportView(listaJugadores);

        add(jScrollPane1);
        jScrollPane1.setBounds(350, 40, 220, 80);

        jLabel2.setText("Jugadores en mesa:");
        add(jLabel2);
        jLabel2.setBounds(350, 20, 140, 14);

        nroSorteado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add(nroSorteado);
        nroSorteado.setBounds(140, 10, 50, 30);

        txt_valorApuesta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_valorApuestaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_valorApuestaFocusLost(evt);
            }
        });
        add(txt_valorApuesta);
        txt_valorApuesta.setBounds(160, 150, 70, 20);

        jLabel3.setText("Ingrese valor a apostar:");
        add(jLabel3);
        jLabel3.setBounds(10, 150, 130, 20);

        btn_finalizarA.setText("Finalizar Apuestas");
        btn_finalizarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_finalizarAActionPerformed(evt);
            }
        });
        add(btn_finalizarA);
        btn_finalizarA.setBounds(420, 130, 150, 40);
        add(lbl_saldo);
        lbl_saldo.setBounds(10, 50, 160, 30);

        jLabel4.setText("(Para desapostar elegir el numero apostado)");
        add(jLabel4);
        jLabel4.setBounds(10, 120, 430, 30);

        jLabel5.setText("Total apostado :");
        add(jLabel5);
        jLabel5.setBounds(10, 100, 90, 14);
        add(lbl_total_apostado);
        lbl_total_apostado.setBounds(110, 100, 0, 0);
        add(lbl_total);
        lbl_total.setBounds(150, 90, 0, 0);

        lbl_mensajes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbl_mensajes.setForeground(new java.awt.Color(255, 0, 0));
        lbl_mensajes.setText(".");
        add(lbl_mensajes);
        lbl_mensajes.setBounds(220, 20, 110, 14);
        add(lbl_total_apostado1);
        lbl_total_apostado1.setBounds(110, 100, 0, 0);

        lbl_totalApostadoRonda.setText("0");
        add(lbl_totalApostadoRonda);
        lbl_totalApostadoRonda.setBounds(110, 94, 40, 20);

        lbl_color.setText("Mi Color");
        add(lbl_color);
        lbl_color.setBounds(490, 20, 70, 14);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_finalizarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_finalizarAActionPerformed
        habilitar(false);
        finalizarApuesta();
    }//GEN-LAST:event_btn_finalizarAActionPerformed

    private void txt_valorApuestaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorApuestaFocusGained
        txt_valorApuesta.setText("");
    }//GEN-LAST:event_txt_valorApuestaFocusGained

    private void txt_valorApuestaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_valorApuestaFocusLost
        
    }//GEN-LAST:event_txt_valorApuestaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_finalizarA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_color;
    private javax.swing.JLabel lbl_mensajes;
    private javax.swing.JLabel lbl_saldo;
    private javax.swing.JLabel lbl_total;
    private javax.swing.JLabel lbl_totalApostadoRonda;
    private javax.swing.JLabel lbl_total_apostado;
    private javax.swing.JLabel lbl_total_apostado1;
    private javax.swing.JList listaJugadores;
    private javax.swing.JLabel nroSorteado;
    private javax.swing.JTextField txt_valorApuesta;
    // End of variables declaration//GEN-END:variables
    
    public void mostrarJugadores(ArrayList<JugadorRuleta> j) {
       ArrayList<String> listado = new ArrayList<>();
       for (JugadorRuleta ju : j){
           listado.add(ju.getJugador().getNombreCompleto());
       }
       listaJugadores.setListData(listado.toArray());
    }
    
    public void mostrarNumeroSorteado(int num){
        if (num == -1) nroSorteado.setText("");
        else nroSorteado.setText(String.valueOf(num));
    }

    public String obtenerApuesta() throws InvalidUserActionException{
        String montoIngresado = txt_valorApuesta.getText();
        // [\\s\\d]* permite empty strings tambien, porque lo uso para desapostar, y filtra mas adelante
        if (!montoIngresado.matches("[\\s\\d]*")) throw new InvalidUserActionException("El valor apostado debe contener solo numeros");
        return montoIngresado;
    }

    public void exito() {
        txt_valorApuesta.setText("0");
        txt_valorApuesta.requestFocus();
    }

    public void mostrarSaldo(long saldo){
        lbl_saldo.setText("Saldo actual: " + String.valueOf(saldo));
    }

    private void finalizarApuesta() {
        mensajesRonda("Apuesta realizada...");
        controlador.finalizarApuesta();
    }

    public void habilitar(boolean b) {
        btn_finalizarA.setEnabled(b);
    }

    public void mostrarTotalApostado(long total) {
        lbl_totalApostadoRonda.setText(String.valueOf(total));
    }

    public void mensajesRonda(String msj) {
        lbl_mensajes.setText(msj);
    }

    public void colorSaldo(Color color) {
        lbl_saldo.setForeground(color);
    }

    public void colorJugador(Color color) {
        lbl_color.setForeground(color);
    }

}
