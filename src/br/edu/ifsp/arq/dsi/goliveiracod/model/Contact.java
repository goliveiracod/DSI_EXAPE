package br.edu.ifsp.arq.dsi.goliveiracod.model;

public class Contact {
    private Integer id;
    private String name;
    private String primaryCellphone;
    private String secondaryCellphone;
    private String primaryPhone;
    private String secondaryPhone;


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

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryCellphone() {
        return primaryCellphone;
    }

    public void setPrimaryCellphone(String primaryCellphone) {
        this.primaryCellphone = primaryCellphone;
    }

    public String getSecondaryCellphone() {
        return secondaryCellphone;
    }

    public void setSecondaryCellphone(String secondaryCellphone) {
        this.secondaryCellphone = secondaryCellphone;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getSecondaryPhone() {
        return secondaryPhone;
    }

    public void setSecondaryPhone(String secondaryPhone) {
        this.secondaryPhone = secondaryPhone;
    }
}
