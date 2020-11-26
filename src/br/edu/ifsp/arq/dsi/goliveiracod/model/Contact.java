package br.edu.ifsp.arq.dsi.goliveiracod.model;

public class Contact {
    private Integer id;
    private final String name;
    private final String primaryCellphone;
    private final String secondaryCellphone;
    private final String primaryPhone;
    private final String secondaryPhone;


    public Contact(String name, String primaryCellphone, String secondaryCellphone, String primaryPhone, String secondaryPhone) {
        this.name = name;
        this.primaryCellphone = primaryCellphone;
        this.secondaryCellphone = secondaryCellphone;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
    }

    public Contact(Integer id, String name, String primaryCellphone, String secondaryCellphone, String primaryPhone, String secondaryPhone) {
        this(name, primaryCellphone, secondaryCellphone, primaryPhone, secondaryPhone);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryCellphone() {
        return primaryCellphone;
    }

    public String getSecondaryCellphone() {
        return secondaryCellphone;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }
}
