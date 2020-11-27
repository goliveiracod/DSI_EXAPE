package br.edu.ifsp.arq.dsi.goliveiracod.model;

public class Contact {
    private final String name;
    private final String primaryCellphone;
    private final String secondaryCellphone;
    private final String primaryPhone;
    private final String secondaryPhone;
    private final String address;
    private Integer id;


    public Contact(
            String name
            , String primaryCellphone
            , String secondaryCellphone
            , String primaryPhone
            , String secondaryPhone
            , String address
    ) {
        this.name = name;
        this.primaryCellphone = primaryCellphone;
        this.secondaryCellphone = secondaryCellphone;
        this.primaryPhone = primaryPhone;
        this.secondaryPhone = secondaryPhone;
        this.address = address;
    }

    public Contact(
            Integer id
            , String name
            , String primaryCellphone
            , String secondaryCellphone
            , String primaryPhone
            , String secondaryPhone
            , String address
    ) {
        this(name, primaryCellphone, secondaryCellphone, primaryPhone, secondaryPhone, address);
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

    public String getAddress() {
        return address;
    }
}
