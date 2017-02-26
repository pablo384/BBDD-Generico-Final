package com.pablo384;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AplicacionUniversal {

    public static void main(String[] args) {
        MarcoBBDD mimarco=new MarcoBBDD();

        mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mimarco.setVisible(true);

    }

}

class MarcoBBDD extends JFrame{

    public MarcoBBDD(){

        setBounds(300,300,700,700);

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

        add(comboTablas, BorderLayout.NORTH);



    }





    private JComboBox comboTablas;

    private JTextArea areaInformacion;

    private Connection miConexion=null;



}