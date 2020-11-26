package br.edu.ifsp.arq.dsi.goliveiracod.view;

import br.edu.ifsp.arq.dsi.goliveiracod.controller.ContactController;
import br.edu.ifsp.arq.dsi.goliveiracod.exception.ValidateFieldException;
import br.edu.ifsp.arq.dsi.goliveiracod.helper.HelperView;
import br.edu.ifsp.arq.dsi.goliveiracod.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddContactView extends JFrame {
    private ContactController contactController;

    private JTextField textName;
    private JFormattedTextField formattedTextPrimaryCellphone;
    private JFormattedTextField formattedTextSecondaryCellphone;
    private JFormattedTextField formattedTextPrimaryPhone;
    private JFormattedTextField formattedTextSecondaryPhone;

    public AddContactView(ContactController contactController) {
        this.contactController = contactController;
        initComponents();
    }

    private void initComponents() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelName = new JLabel("Nome: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        painel.add(labelName, gridBagConstraints);

        textName = new JTextField("");
        textName.setHorizontalAlignment(JTextField.CENTER);
        textName.setColumns(20);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        painel.add(textName, gridBagConstraints);

        JLabel labelPrimaryCellphone = new JLabel("Celular principal (*): ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        painel.add(labelPrimaryCellphone, gridBagConstraints);

        formattedTextPrimaryCellphone = new JFormattedTextField(HelperView.mascara("(##) #####-####"));
        formattedTextPrimaryCellphone.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        painel.add(formattedTextPrimaryCellphone, gridBagConstraints);

        JLabel labelSecondaryCellphone = new JLabel("Celular secundário: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        painel.add(labelSecondaryCellphone, gridBagConstraints);

        formattedTextSecondaryCellphone = new JFormattedTextField(HelperView.mascara("(##) #####-####"));
        formattedTextSecondaryCellphone.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        painel.add(formattedTextSecondaryCellphone, gridBagConstraints);

        JLabel labelPrimaryPhone = new JLabel("Telefone primário: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        painel.add(labelPrimaryPhone, gridBagConstraints);

        formattedTextPrimaryPhone = new JFormattedTextField(HelperView.mascara("(##) ####-####"));
        formattedTextPrimaryPhone.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        painel.add(formattedTextPrimaryPhone, gridBagConstraints);

        JLabel labelSecondaryPhone = new JLabel("Telefone seucndário: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        painel.add(labelSecondaryPhone, gridBagConstraints);

        formattedTextSecondaryPhone = new JFormattedTextField(HelperView.mascara("(##) ####-####"));
        formattedTextSecondaryPhone.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        painel.add(formattedTextSecondaryPhone, gridBagConstraints);

        JButton btnSave = new JButton("Salvar contato");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        btnSave.addActionListener(this::save);
        painel.add(btnSave, gridBagConstraints);


        setTitle("Adicionar contato");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        add(painel);
    }

    private void save(ActionEvent actionEvent) {
        String name = textName.getText();
        String primaryCellphone = (String) formattedTextPrimaryCellphone.getValue();
        String secondaryCellphone = (String) formattedTextSecondaryCellphone.getValue();
        String primaryPhone = (String) formattedTextPrimaryPhone.getValue();
        String secondaryPhone = (String) formattedTextSecondaryPhone.getValue();

        try {
            validateFields(name, primaryCellphone, secondaryCellphone, primaryPhone, secondaryPhone);

            Contact contact = new Contact(name, primaryCellphone, secondaryCellphone, primaryPhone, secondaryPhone);

            this.contactController.save(contact);
            HelperView.mensagemInformativa("Contato salvo com sucesso!", "Contato adicionado");
        } catch (ValidateFieldException validateFieldException){
            HelperView.mensagemDeErro(validateFieldException.getMessage(), "Erro");
        } catch (Exception exception) {
            HelperView.mensagemDeErro("Erro desconhecido!", "Erro");
        }

    }

    private void validateFields(
            String name, String primaryCellphone, String secondaryCellphone, String primaryPhone, String secondaryPhone
    ) {
        if (name != null && name.length() < 3)
            throw new ValidateFieldException("Insira um com 3 ou mais characteres.");
        else if (primaryCellphone == null)
            throw new ValidateFieldException("O celular principal não pode ficar em branco.");
    }
}
