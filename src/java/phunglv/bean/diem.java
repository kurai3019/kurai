/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phunglv.bean;

/**
 *
 * @author Administrator
 */
public class diem {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String type;
    private String reason;
    private String date;
    private String name;
    
        public diem(){}

       public diem(String type, String reason, String date, String name) {
        this.type = type;
        this.reason = reason;
        this.date = date;
        this.name = name;
    } 
    
}
