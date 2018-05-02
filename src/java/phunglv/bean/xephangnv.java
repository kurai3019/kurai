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
public class xephangnv {

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDeparts() {
        return departs;
    }

    public void setDeparts(String departs) {
        this.departs = departs;
    }
       private String photo;
       private String name; 
       private String mark; 
       private String departs; 
      public xephangnv() {}
      
        public xephangnv(String photo, String name, String mark, String departs) {
        this.photo = photo;
        this.name = name;
        this.mark = mark;
        this.departs = departs;
    }
}
