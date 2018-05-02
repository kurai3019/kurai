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
public class xephangpb {

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String mark;
    private String name;
     public xephangpb(){}
    public xephangpb(String mark, String name) {
        this.mark = mark;
        this.name = name;}
}
