/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phunglv.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import phunglv.bean.Student;
import phunglv.model.Student3Model;

/**
 *
 * @author Administrator
 */
@org.springframework.stereotype.Controller
@RequestMapping("/student4")
public class Controller {
    public String[] ten = new String[10];
    public String[] matkhau = new String[10];
    /////////////////////////////////  

    public void getDatabase() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String username = "sa";
            String password = "123456";
            String sql = "jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(sql, username, password);
            Statement sml = con.createStatement();
            ResultSet rs = sml.executeQuery("select * from Users");
            int i = 0;
            while (rs.next()) {
                ten[i] =  rs.getString("Username");
                matkhau[i] = rs.getString("Password");         
                i++;
            }

        } catch (Exception e) {
        }
        
    }
   @RequestMapping("user-form")
    public String showForm() {
        return "login";
    }
    @RequestMapping("login")
    
    public String login2(ModelMap model, HttpServletRequest request) {
        getDatabase();
        
        System.err.println(Arrays.deepToString(ten));
        System.err.println(Arrays.deepToString(matkhau));
        String id = request.getParameter("id");
        String pw = request.getParameter("password");
        for (int i = 0; i < ten.length; i++) {
            if (id.equals(ten[i]) && pw.equals(matkhau[i])) {
                model.addAttribute("uid", id);
                model.addAttribute("pwd", pw);
        Student3Model st = new Student3Model();
        List<Student> list = new ArrayList<Student>();
        list = st.showStudent("");
        model.addAttribute("listStudent", list);

        Student sv = new Student();
        sv = list.get(0);
        model.addAttribute("student", sv);
        return "student3";              
            }
        }
      //  model.addAttribute("message", "Sai thông tin đăng nhập!");
        return "login";

    }

}
