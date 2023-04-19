package com.kaapo.ostoslista;

public class Item {
    protected String ostos;
    protected String extraTxt;

    protected int id;

    protected boolean isChecked;

    public Item(String Ostos, String extraTxt, boolean isChecked, int id) {
        this.ostos = Ostos;
        this.extraTxt = extraTxt;
        this.isChecked = isChecked;
        this.id = id;
    }

    public String getOstos() {
        return ostos;
    }

    public boolean isItChecked() {
        return isChecked;
    }

    public void setOstos(String teksti) {
        this.ostos = teksti;
    }
    public void setExtraTxt(String extraTxt) {
        this.extraTxt = extraTxt;
    }

    public String getExtraTxt(){
        return extraTxt;
    }

}
