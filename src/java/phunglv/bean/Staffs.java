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
public class Staffs {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birtday) {
        this.birthday = birtday;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDepartid() {
        return departid;
    }

    public void setDepartid(String departid) {
        this.departid = departid;
    }
    private String id;
    private String name;
    private Boolean gender;
    private String birthday;
    private String photo;
    private String email;
    private String phone;
    private Float salary;
    private String notes;
    private String departid;
    public Staffs(){}
     public Staffs(String id,String name, Boolean gender,String birthday, String photo,String email, String phone, Float salary, String notes, String departid)
     {
         
         this.id=id;
         this.name = name;
         this.gender = gender;
         this.birthday = birthday;
         this.photo=photo;
         this.email=email;
         this.phone=phone;
         this.salary=salary;
         this.notes=notes;
         this.departid=departid;
     
     
     
     }
   

}
