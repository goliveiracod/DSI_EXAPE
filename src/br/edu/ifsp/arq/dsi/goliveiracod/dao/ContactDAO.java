package br.edu.ifsp.arq.dsi.goliveiracod.dao;

import br.edu.ifsp.arq.dsi.goliveiracod.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDAO {
    void save(Contact contact);

    Optional<List<Contact>> findAll();

    Optional<List<Contact>> findByName(String name);

    Optional<Contact> findById(Integer id);

    void update(Contact contact);

    void delete(Integer id);
}
