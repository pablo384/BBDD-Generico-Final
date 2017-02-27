package com.pablo384;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class borrar {

    public static void main (String [] arg){

        marc marco=new marc();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);


    }

}

class marc extends JFrame{
    public marc (){
        setBounds(300,300,300,300);

        lam lamina= new lam();
        add(lamina);

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "TXT File", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getAbsolutePath());
        }
    }

}
class lam extends JPanel{
    public lam(){

    }
}
