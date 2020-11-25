package br.edu.ifsp.arq.dsi.goliveiracod;

import br.edu.ifsp.arq.dsi.goliveiracod.dao.ContactDAO;
import br.edu.ifsp.arq.dsi.goliveiracod.dao.ContactDAOImpl;
import br.edu.ifsp.arq.dsi.goliveiracod.factory.ConnectionFactory;
import br.edu.ifsp.arq.dsi.goliveiracod.model.Contact;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        ContactDAO contactDAO = new ContactDAOImpl(connection);
        if (connection != null) {
//            contactDAO.save(
//                    new Contact(
//                            "Thiago"
//                            , "00000000000"
//                            , null
//                            , null
//                            , null
//                    )
//            );

//            contactDAO.delete(1);

            contactDAO.findById(2).ifPresent(contact -> {
                contact.setName("Teste");
                contact.setPrimaryCellphone("1111111111");
                contactDAO.update(contact);
            });

            Optional<List<Contact>> optionalContacts = contactDAO.findAll();

            optionalContacts.ifPresent(contacts -> {
                contacts.forEach(contact -> {
                    System.out.println(contact.getName());
                });
            });


//            contacts = contactDAO.findByName("GAB");
//
//            if (contacts != null){
//                contacts.forEach(contact -> {
//                    System.out.println(contact.getName());
//                });
//            }

        }


    }
}
