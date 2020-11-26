package br.edu.ifsp.arq.dsi.goliveiracod;

import br.edu.ifsp.arq.dsi.goliveiracod.controller.ContactController;
import br.edu.ifsp.arq.dsi.goliveiracod.dao.ContactDAOImpl;
import br.edu.ifsp.arq.dsi.goliveiracod.factory.ConnectionFactory;
import br.edu.ifsp.arq.dsi.goliveiracod.model.Contact;
import br.edu.ifsp.arq.dsi.goliveiracod.view.MainView;

public class Main {

    public static void main(String[] args) {
        new MainView(new ContactController(new ContactDAOImpl(ConnectionFactory.getInstance().getConnection())));
//        ContactController contactController = new ContactController();
//
//        Contact thiago = new Contact(
//                "Thiago"
//                , "00000000000"
//                , null
//                , null
//                , null
//        );
//
//        Contact gabriel = new Contact(
//                "Gabriel"
//                , "00000000000"
//                , null
//                , null
//                , null
//        );
//
//        contactController.save(thiago);
//        contactController.save(gabriel);
//
//        System.out.println("All contacts");
//        contactController.findAll().ifPresent(contacts -> {
//            contacts.forEach(contact -> {
//                System.out.println(contact.getName());
//            });
//        });
//
//        System.out.println("All contacts by name");
//        contactController.findByName("bri").ifPresent(contacts -> {
//            contacts.forEach(contact -> {
//                System.out.println(contact.getName());
//            });
//        });
//
//        System.out.println("Contact by id");
//        contactController.findById(1).ifPresent(contact -> {
//            System.out.println(contact.getName());
//        });
//
//        // verify if contact exists
//        contactController.findById(1).ifPresent(contact -> {
//            // edit contact
//            contact.setName("Thiago Borges");
//            contact.setPrimaryCellphone("11111111111");
//            contactController.update(contact);
//        });
//
//        // verify if contact exists
//        contactController.findById(2).ifPresent(contact -> {
//            // delete contact
//            contactController.delete(contact.getId());
//        });
//
//        System.out.println("All contacts");
//        contactController.findAll().ifPresent(contacts -> {
//            contacts.forEach(contact -> {
//                System.out.println(contact.getName());
//            });
//        });
    }
}
