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
public class Departs {
    private String id;
    private String name;
    
        public Departs(){}       
            public Departs(String id, String name) {
        this.id = id;
        this.name = name;
    }       
    public String getid() {
        return id;
    }
    public void setid(String id) {
        this.id = id;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }

}
