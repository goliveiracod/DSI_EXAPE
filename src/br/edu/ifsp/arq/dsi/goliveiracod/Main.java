package br.edu.ifsp.arq.dsi.goliveiracod;

import br.edu.ifsp.arq.dsi.goliveiracod.controller.ContactController;
import br.edu.ifsp.arq.dsi.goliveiracod.dao.ContactDAOImpl;
import br.edu.ifsp.arq.dsi.goliveiracod.factory.ConnectionFactory;
import br.edu.ifsp.arq.dsi.goliveiracod.view.MainView;

public class Main {

    public static void main(String[] args) {
        new MainView(new ContactController(new ContactDAOImpl(ConnectionFactory.getInstance().getConnection())));
    }
}
