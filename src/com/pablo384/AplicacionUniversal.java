package com.pablo384;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class AplicacionUniversal {

    public static void main(String[] args) {
        MarcoBBDD mimarco=new MarcoBBDD();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);


    }

}

class MarcoBBDD extends JFrame{

    public MarcoBBDD(){

        setBounds(300,20,700,700);

        LaminaBBDD milamina=new LaminaBBDD();

        add(milamina);

    }

}

class LaminaBBDD extends JPanel{

    public LaminaBBDD(){

        setLayout(new BorderLayout());

        comboTablas=new JComboBox();

        areaInformacion=new JTextArea();


        add(areaInformacion,BorderLayout.CENTER);

        conectarBBDD();
        obtenerTablas();
        comboTablas.addActionListener(e -> {
            String nombreTabla= (String)comboTablas.getSelectedItem();
            mostrarInfoTabla(nombreTabla);
        });

        add(comboTablas, BorderLayout.NORTH);





    }



    public void conectarBBDD(){
        miConexion=null;

        try {
            miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/cursosql", "root", "");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void obtenerTablas(){
        ResultSet miResulset=null;
        try {

            DatabaseMetaData datosBBDD=miConexion.getMetaData();
            miResulset=datosBBDD.getTables(null,null,null,null);

            while (miResulset.next()){
                comboTablas.addItem(miResulset.getString("TABLE_NAME"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void mostrarInfoTabla(String tabla) {



        ArrayList<String> campos=new ArrayList<String>();
        String consulta="SELECT * FROM "+tabla;

        try {

            areaInformacion.setText("");
            Statement miStatement=miConexion.createStatement();
            ResultSet miResulset=miStatement.executeQuery(consulta);

            ResultSetMetaData rsBBDD=miResulset.getMetaData();

            for (int i=1;i<=rsBBDD.getColumnCount();i++){
                campos.add(rsBBDD.getColumnLabel(i));
            }

            while (miResulset.next()){
                for (String nombreCampo:campos){
                    areaInformacion.append(miResulset.getString(nombreCampo)+" ");
                }
                areaInformacion.append("\n");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }





    private JComboBox comboTablas;

    private JTextArea areaInformacion;

    private Connection miConexion;



}