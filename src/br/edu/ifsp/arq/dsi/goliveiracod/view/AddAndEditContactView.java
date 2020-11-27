package br.edu.ifsp.arq.dsi.goliveiracod.view;

import br.edu.ifsp.arq.dsi.goliveiracod.controller.ContactController;
import br.edu.ifsp.arq.dsi.goliveiracod.exception.ValidateFieldException;
import br.edu.ifsp.arq.dsi.goliveiracod.helper.HelperView;
import br.edu.ifsp.arq.dsi.goliveiracod.model.Contact;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Optional;

public class AddAndEditContactView extends JFrame {
    private final ContactController contactController;

    private Contact contact;

    private JTextField textId;
    private JTextField textName;
    private JFormattedTextField formattedTextPrimaryCellphone;
    private JFormattedTextField formattedTextSecondaryCellphone;
    private JFormattedTextField formattedTextPrimaryPhone;
    private JFormattedTextField formattedTextSecondaryPhone;
    private JTextField textAddress;
    private JRadioButton radioBtnAdd;
    private JRadioButton radioBtnEdit;
    private JButton btnSave;
    private JButton btnSearch;

    public AddAndEditContactView(ContactController contactController) {
        this.contactController = contactController;
        initComponents();
        updateUI(1);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel labelName = new JLabel("Nome: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panel.add(labelName, gridBagConstraints);

        textName = new JTextField("");
        textName.setHorizontalAlignment(JTextField.CENTER);
        textName.setColumns(20);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        panel.add(textName, gridBagConstraints);

        JLabel labelPrimaryCellphone = new JLabel("Celular principal (*): ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        panel.add(labelPrimaryCellphone, gridBagConstraints);

        formattedTextPrimaryCellphone = new JFormattedTextField(HelperView.mascara("(##) #####-####"));
        formattedTextPrimaryCellphone.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        panel.add(formattedTextPrimaryCellphone, gridBagConstraints);

        JLabel labelSecondaryCellphone = new JLabel("Celular secundário: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panel.add(labelSecondaryCellphone, gridBagConstraints);

        formattedTextSecondaryCellphone = new JFormattedTextField(HelperView.mascara("(##) #####-####"));
        formattedTextSecondaryCellphone.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        panel.add(formattedTextSecondaryCellphone, gridBagConstraints);

        JLabel labelPrimaryPhone = new JLabel("Telefone primário: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        panel.add(labelPrimaryPhone, gridBagConstraints);

        formattedTextPrimaryPhone = new JFormattedTextField(HelperView.mascara("(##) ####-####"));
        formattedTextPrimaryPhone.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        panel.add(formattedTextPrimaryPhone, gridBagConstraints);

        JLabel labelSecondaryPhone = new JLabel("Telefone secundário: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        panel.add(labelSecondaryPhone, gridBagConstraints);

        formattedTextSecondaryPhone = new JFormattedTextField(HelperView.mascara("(##) ####-####"));
        formattedTextSecondaryPhone.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        panel.add(formattedTextSecondaryPhone, gridBagConstraints);

        JLabel labelAddress = new JLabel("Endereço: ");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        panel.add(labelAddress, gridBagConstraints);

        textAddress = new JTextField("");
        textAddress.setHorizontalAlignment(JTextField.CENTER);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        panel.add(textAddress, gridBagConstraints);

        btnSave = new JButton("Salvar contato");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        btnSave.addActionListener(this::save);
        panel.add(btnSave, gridBagConstraints);

        JPanel panelFlowLayoutOptions = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonGroup buttonGroup = new ButtonGroup();
        radioBtnAdd = new JRadioButton("Adicionar");
        buttonGroup.add(radioBtnAdd);
        radioBtnAdd.addActionListener(this::optionAdd);
        radioBtnAdd.setSelected(true);
        panelFlowLayoutOptions.add(radioBtnAdd);

        radioBtnEdit = new JRadioButton("Editar");
        buttonGroup.add(radioBtnEdit);
        radioBtnEdit.addActionListener(this::optionEdit);
        panelFlowLayoutOptions.add(radioBtnEdit);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        panel.add(panelFlowLayoutOptions, gridBagConstraints);

        JPanel panelFlowLayoutSearchContact = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelId = new JLabel("Informe o ID: ");
        panelFlowLayoutSearchContact.add(labelId);

        textId = new JTextField("");
        textId.setHorizontalAlignment(JTextField.CENTER);
        textId.setColumns(10);
        panelFlowLayoutSearchContact.add(textId);

        btnSearch = new JButton("Buscar contato");
        btnSearch.setPreferredSize(new Dimension(150, 18));
        btnSearch.addActionListener(this::searchById);
        panelFlowLayoutSearchContact.add(btnSearch);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        panel.add(panelFlowLayoutSearchContact, gridBagConstraints);

        setTitle("Adicionar/editar contato");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(panel);
    }

    private void save(ActionEvent actionEvent) {
        String id = textId.getText();
        String name = textName.getText();
        String primaryCellphone = (String) formattedTextPrimaryCellphone.getValue();
        String secondaryCellphone = (String) formattedTextSecondaryCellphone.getValue();
        String primaryPhone = (String) formattedTextPrimaryPhone.getValue();
        String secondaryPhone = (String) formattedTextSecondaryPhone.getValue();
        String address = textAddress.getText();

        try {
            validateFields(name, primaryCellphone, id, address);

            if (radioBtnAdd.isSelected()) {
                this.contactController.save(
                        new Contact(name, primaryCellphone, secondaryCellphone, primaryPhone, secondaryPhone, address)
                );
                HelperView.mensagemInformativa("Contato salvo com sucesso!", "Contato adicionado");
            } else {
                this.contactController.update(
                        new Contact(
                                contact.getId()
                                , name
                                , primaryCellphone
                                , secondaryCellphone
                                , primaryPhone
                                , secondaryPhone
                                , address
                        )
                );
                HelperView.mensagemInformativa("Contato editado com sucesso!", "Contato editado");
            }
            updateUI(1);

        } catch (ValidateFieldException validateFieldException) {
            HelperView.mensagemDeErro(validateFieldException.getMessage(), "Erro");
        } catch (Exception exception) {
            HelperView.mensagemDeErro("Erro desconhecido!", "Erro");
        }

    }

    private void validateFields(String name, String primaryCellphone, String id, String address) {
        if (name != null && name.length() < 3)
            throw new ValidateFieldException("Insira um nome com 3 ou mais letras.");
        else if (primaryCellphone == null)
            throw new ValidateFieldException("O celular principal não pode ficar em branco.");
        else if (radioBtnEdit.isSelected() && id == null) {
            throw new ValidateFieldException("Digite um id para prosseguir com a edição");
        } else if (address != null && address.length() < 11)
            throw new ValidateFieldException("Para o endereço ser válido ele precisar ter mais que 10 letras");
    }

    private void updateUI(int option) {
        switch (option) {
            case 1:
                textId.setEnabled(false);
                textId.setText("");
                textName.setEnabled(true);
                textName.setText("");
                formattedTextPrimaryCellphone.setEnabled(true);
                formattedTextPrimaryCellphone.setText("");
                formattedTextPrimaryCellphone.setValue("");
                formattedTextSecondaryCellphone.setEnabled(true);
                formattedTextSecondaryCellphone.setText("");
                formattedTextSecondaryCellphone.setValue("");
                formattedTextPrimaryPhone.setEnabled(true);
                formattedTextPrimaryPhone.setText("");
                formattedTextPrimaryPhone.setValue("");
                formattedTextSecondaryPhone.setEnabled(true);
                formattedTextSecondaryPhone.setText("");
                formattedTextSecondaryPhone.setValue("");
                textAddress.setEnabled(true);
                textAddress.setText("");
                btnSave.setEnabled(true);
                btnSearch.setEnabled(false);
                radioBtnAdd.setSelected(true);
                break;
            case 2:
                textId.setEnabled(true);
                textName.setEnabled(false);
                formattedTextPrimaryCellphone.setEnabled(false);
                formattedTextSecondaryCellphone.setEnabled(false);
                formattedTextPrimaryPhone.setEnabled(false);
                formattedTextSecondaryPhone.setEnabled(false);
                textAddress.setEnabled(false);
                btnSave.setEnabled(false);
                btnSearch.setEnabled(true);
                radioBtnEdit.setSelected(true);
                break;
            case 3:
                textId.setEnabled(true);
                textName.setEnabled(true);
                formattedTextPrimaryCellphone.setEnabled(true);
                formattedTextSecondaryCellphone.setEnabled(true);
                formattedTextPrimaryPhone.setEnabled(true);
                formattedTextSecondaryPhone.setEnabled(true);
                textAddress.setEnabled(true);
                btnSave.setEnabled(true);
                btnSearch.setEnabled(false);
                radioBtnEdit.setSelected(true);
                break;
        }
    }

    private void searchById(ActionEvent actionEvent) {
        updateUI(3);

        if (textId.getText().isEmpty()) {
            HelperView.mensagemDeErro("Digite um id para efetuar a busca", "Erro");
        } else  {
            Optional<Contact> contactOptional = contactController.findById(Integer.valueOf(textId.getText()));

            if (contactOptional.isPresent()) {
                contact = contactOptional.get();
                textId.setText(String.valueOf(contact.getId()));
                textName.setText(contact.getName());
                formattedTextPrimaryCellphone.setText(contact.getPrimaryCellphone());
                formattedTextPrimaryCellphone.setValue(contact.getPrimaryCellphone());
                formattedTextSecondaryCellphone.setText(contact.getSecondaryCellphone());
                formattedTextSecondaryCellphone.setValue(contact.getSecondaryCellphone());
                formattedTextPrimaryPhone.setText(contact.getPrimaryPhone());
                formattedTextPrimaryPhone.setValue(contact.getPrimaryPhone());
                formattedTextSecondaryPhone.setText(contact.getSecondaryPhone());
                formattedTextSecondaryPhone.setValue(contact.getSecondaryPhone());
                textAddress.setText(contact.getAddress());
            } else {
                updateUI(2);
                HelperView.mensagemDeErro("Id não encontrado", "Erro");
            }
        }
    }

    private void optionEdit(ActionEvent actionEvent) {
        updateUI(2);
    }

    private void optionAdd(ActionEvent actionEvent) {
        updateUI(1);
    }
}
