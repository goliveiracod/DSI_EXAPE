package br.edu.ifsp.arq.dsi.goliveiracod.view;

import br.edu.ifsp.arq.dsi.goliveiracod.controller.ContactController;

import javax.swing.*;

public class MainView extends JFrame {
    public MainView() {
        initComponents();
    }

    private void initComponents(){
        JMenuBar menuBar = new JMenuBar();

        JMenu menuOption = new JMenu("Opções");
        menuOption.setMnemonic('O');
        menuBar.add(menuOption);

        JMenu menuExit = new JMenu("Sair");
        menuExit.setMnemonic('S');
        menuBar.add(menuExit);


        JMenuItem menuAddContact = new JMenuItem("Adicionar contado");
        menuAddContact.addActionListener(actionEvent -> new AddContactView(new ContactController()));
        menuAddContact.setMnemonic('c');
        menuOption.add(menuAddContact);


        setTitle("Projeto prático");
        setSize(600, 400);
        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
