/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transport;

/**
 *
 * @author ARIFUL
 */
public class historydata {
    String name,sit,jdate,jtime,dis,mail,phone,idate,buslic;



    public historydata(String name, String sit, String jdate, String jtime, String dis, String mail, String phone, String idate, String buslic) {
        this.name = name;
        this.sit = sit;
        this.jdate = jdate;
        this.jtime = jtime;
        this.dis = dis;
        this.mail = mail;
        this.phone = phone;
        this.idate = idate;
        this.buslic=buslic;
    }

    public void setBuslic(String buslic) {
        this.buslic = buslic;
    }

    public String getBuslic() {
        return buslic;
    }

       public String getJdate() {
        return jdate;
    }
    public String getName() {
        return name;
    }

    public String getSit() {
        return sit;
    }

 

    public String getJtime() {
        return jtime;
    }

    public String getDis() {
        return dis;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getIdate() {
        return idate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSit(String sit) {
        this.sit = sit;
    }

    public void setJdate(String jdate) {
        this.jdate = jdate;
    }

    public void setJtime(String jtime) {
        this.jtime = jtime;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIdate(String idate) {
        this.idate = idate;
    }


    
    
}
