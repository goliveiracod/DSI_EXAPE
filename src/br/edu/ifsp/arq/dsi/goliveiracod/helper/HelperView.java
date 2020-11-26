package br.edu.ifsp.arq.dsi.goliveiracod.helper;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class HelperView {
    private HelperView() {
    }

    public static MaskFormatter mascara(String Mascara) {

        MaskFormatter maskFormatter = new MaskFormatter();
        try {
            maskFormatter.setMask(Mascara);
            maskFormatter.setPlaceholderCharacter(' ');
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return maskFormatter;
    }

    public static void mensagemDeErro(String message, String title) {
        JOptionPane.showMessageDialog(
                null
                , message
                , title
                , JOptionPane.ERROR_MESSAGE
        );
    }

    public static void mensagemInformativa(String message, String title) {
        JOptionPane.showMessageDialog(
                null
                , message
                , title
                , JOptionPane.INFORMATION_MESSAGE
        );
    }
}
