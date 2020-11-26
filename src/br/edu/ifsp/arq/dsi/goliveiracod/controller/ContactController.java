package br.edu.ifsp.arq.dsi.goliveiracod.controller;

import br.edu.ifsp.arq.dsi.goliveiracod.dao.ContactDAO;
import br.edu.ifsp.arq.dsi.goliveiracod.dao.ContactDAOImpl;
import br.edu.ifsp.arq.dsi.goliveiracod.model.Contact;

import java.util.List;
import java.util.Optional;

public class ContactController {
    private final ContactDAO contactDAO;

    public ContactController(ContactDAOImpl contactDAO) {
        this.contactDAO = contactDAO;
    }

    public void save(Contact contact) {
        this.contactDAO.save(contact);
    }

    public Optional<List<Contact>> findAll() {
        return this.contactDAO.findAll();
    }

    public Optional<List<Contact>> findByName(String name) {
        return this.contactDAO.findByName(name);
    }

    public Optional<Contact> findById(Integer id) {
        return this.contactDAO.findById(id);
    }

    public void update(Contact contact) {
        this.contactDAO.update(contact);
    }

    public void delete(Integer id) {
        this.contactDAO.delete(id);
    }
}
