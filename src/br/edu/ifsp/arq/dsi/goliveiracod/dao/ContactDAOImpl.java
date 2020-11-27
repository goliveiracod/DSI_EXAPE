package br.edu.ifsp.arq.dsi.goliveiracod.dao;

import br.edu.ifsp.arq.dsi.goliveiracod.model.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactDAOImpl implements ContactDAO {

    private final Connection connection;

    public ContactDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(Contact contact) {
        String sql = "INSERT INTO contacts (name, primary_cellphone, secondary_cellphone, primary_phone, secondary_phone, address)" +
                " VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, contact.getName());
            pstm.setString(2, contact.getPrimaryCellphone());
            pstm.setString(3, contact.getSecondaryCellphone());
            pstm.setString(4, contact.getPrimaryPhone());
            pstm.setString(5, contact.getSecondaryPhone());
            pstm.setString(6, contact.getAddress());

            pstm.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    @Override
    public Optional<List<Contact>> findAll() {
        String sql = "SELECT id, name, primary_cellphone, secondary_cellphone, primary_phone, secondary_phone, address FROM contacts";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            return getContacts(pstm);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Contact>> findByName(String name) {
        String sql = "SELECT id, name, primary_cellphone, secondary_cellphone, primary_phone, secondary_phone, address FROM contacts " +
                "WHERE name LIKE ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, "%" + name + "%");
            return getContacts(pstm);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<Contact> findById(Integer id) {
        String sql = "SELECT id, name, primary_cellphone, secondary_cellphone, primary_phone, secondary_phone, address FROM contacts " +
                "WHERE id = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, id);
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                rst.first();

                return Optional.of(new Contact(
                        rst.getInt(1)
                        , rst.getString(2)
                        , rst.getString(3)
                        , rst.getString(4)
                        , rst.getString(5)
                        , rst.getString(6)
                        , rst.getString(7)
                ));
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public void update(Contact contact) {
        try (PreparedStatement pstm = connection.prepareStatement("UPDATE contacts " +
                "SET name = ?, primary_cellphone = ?, secondary_cellphone = ?, primary_phone = ?, " +
                "secondary_phone = ?, address = ? WHERE id = ?")) {

            pstm.setString(1, contact.getName());
            pstm.setString(2, contact.getPrimaryCellphone());
            pstm.setString(3, contact.getSecondaryCellphone());
            pstm.setString(4, contact.getPrimaryPhone());
            pstm.setString(5, contact.getSecondaryPhone());
            pstm.setString(6, contact.getAddress());
            pstm.setInt(7, contact.getId());

            pstm.execute();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println(sqlException.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM contacts WHERE ID = ?")) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    private Optional<List<Contact>> getContacts(PreparedStatement pstm) throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        pstm.execute();
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Contact contact = new Contact(
                        rst.getInt(1)
                        , rst.getString(2)
                        , rst.getString(3)
                        , rst.getString(4)
                        , rst.getString(5)
                        , rst.getString(6)
                        , rst.getString(7)
                );
                contacts.add(contact);
            }
        }
        if (contacts.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(contacts);
    }
}
