package br.edu.ifsp.arq.dsi.goliveiracod.view;

import br.edu.ifsp.arq.dsi.goliveiracod.controller.ContactController;
import br.edu.ifsp.arq.dsi.goliveiracod.dao.ContactDAOImpl;
import br.edu.ifsp.arq.dsi.goliveiracod.factory.ConnectionFactory;
import br.edu.ifsp.arq.dsi.goliveiracod.model.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MainView extends JFrame {
    private final ContactController contactController;

    private final String[] column =
            {"ID", "NAME", "PRIMARY CELLPHONE", "SECONDARY_CELLPHONE", "PRIMARY PHONE", "SECONDARY PHONE"};

    private JTextField textName;
    private DefaultTableModel modelTableContacts;

    public MainView(ContactController contactController) {
        this.contactController = contactController;
        initComponents();
        initTable();
    }

    private void initComponents() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuOption = new JMenu("Opções");
        menuOption.setMnemonic('O');
        menuBar.add(menuOption);

        JMenuItem menuAddContact = new JMenuItem("Adicionar contado");
        menuAddContact.addActionListener(actionEvent -> new AddContactView(new ContactController(
                new ContactDAOImpl(ConnectionFactory.getInstance().getConnection())
        )));
        menuAddContact.setMnemonic('c');
        menuOption.add(menuAddContact);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelName = new JLabel("Nome: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;
        panel.add(labelName, gridBagConstraints);

        textName = new JTextField("");
        textName.setHorizontalAlignment(JTextField.CENTER);
        textName.setColumns(30);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        panel.add(textName, gridBagConstraints);

        JButton btnSearch = new JButton("Buscar");
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        btnSearch.addActionListener(this::search);
        panel.add(btnSearch, gridBagConstraints);

        modelTableContacts = new DefaultTableModel();
        JTable tableContacts = new JTable(modelTableContacts);
        tableContacts.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPaneTableContacts = new JScrollPane(tableContacts);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(scrollPaneTableContacts, gridBagConstraints);

        JPanel panelBorderLayout = new JPanel(new BorderLayout());

        JButton btnRefresh = new JButton("Atualizar tabela");
        btnRefresh.addActionListener(this::refresh);
        panelBorderLayout.add(btnRefresh, BorderLayout.WEST);

        JButton btnDelete = new JButton("Remover contato");
        btnDelete.addActionListener(this::delete);
        panelBorderLayout.add(btnDelete, BorderLayout.EAST);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 0;
        panel.add(panelBorderLayout, gridBagConstraints);

        setTitle("Projeto prático");
        setSize(480, 540);
        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(panel);
    }

    private void initTable() {
        contactController.findAll().ifPresent(this::updateTable);
    }

    private void search(ActionEvent actionEvent) {
        contactController.findByName(textName.getText()).ifPresent(this::updateTable);
    }

    private void refresh(ActionEvent actionEvent) {
        initTable();
    }

    private void delete(ActionEvent actionEvent) {
        String id = JOptionPane.showInputDialog(
                null
                , "Digite o ID do contato: "
                , "Remover contato"
                , JOptionPane.INFORMATION_MESSAGE
        );

        if (id != null) {
            contactController.delete(Integer.valueOf(id));
            initTable();
        }
    }

    private void updateTable(List<Contact> contacts) {
        List<String[]> data = new ArrayList<>();
        contacts.forEach(contact -> {
            String[] row = {
                    String.valueOf(contact.getId())
                    , contact.getName()
                    , contact.getPrimaryCellphone()
                    , contact.getSecondaryCellphone()
                    , contact.getPrimaryPhone()
                    , contact.getSecondaryPhone()
            };
            data.add(row);
        });
        String[][] arrayOfRows = new String[data.size()][column.length];
        data.toArray(arrayOfRows);
        modelTableContacts.setDataVector(arrayOfRows, column);
    }
}
