/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpleManager;

/**
 *
 * @author PLRAD2SIU
 */
public class PrintersList {
    
    
    private Integer idprinters;
    private String dzial;
    private String model;
    private String rodzaj_tuszu;
    private String ip;
    private String info;

    public PrintersList(Integer idprinters, String dzial, String model, String rodzaj_tuszu, String ip, String info) {
        this.idprinters = idprinters;
        this.dzial = dzial;
        this.model = model;
        this.rodzaj_tuszu = rodzaj_tuszu;
        this.ip = ip;
        this.info = info;
    }

    public Integer getIdprinters() {
        return idprinters;
    }

    public void setIdprinters(Integer idprinters) {
        this.idprinters = idprinters;
    }

    public String getDzial() {
        return dzial;
    }

    public void setDzial(String dzial) {
        this.dzial = dzial;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRodzaj_tuszu() {
        return rodzaj_tuszu;
    }

    public void setRodzaj_tuszu(String rodzaj_tuszu) {
        this.rodzaj_tuszu = rodzaj_tuszu;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    
    
    
}
