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
import java.util.Random;
import java.util.UUID;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import phunglv.bean.Departs;
import phunglv.bean.Major;
import phunglv.bean.Student;
import phunglv.model.Student3Model;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import phunglv.bean.Mailer;
import phunglv.bean.Staffs;
import phunglv.bean.diem;
import phunglv.bean.xephangnv;
import phunglv.bean.xephangpb;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/student99")



public class Student3Controller {
    	@Autowired

        	JavaMailSender mailer;
                int i = 0;

              
    
    @RequestMapping("showall")
    public String showAll(ModelMap model){
        Student3Model st = new Student3Model();
        List<Student> list = new ArrayList<Student>();
        list = st.showStudent("");
        model.addAttribute("listStudent", list);
        
        Student sv = new Student();
        sv = list.get(0);
        model.addAttribute("student", sv);
        return "student99";
        
        
        
 
        
    }
    
        @RequestMapping("showall2")
        
    public String showAll2(ModelMap model){
        Student3Model st = new Student3Model();
        List<Departs> list = new ArrayList<Departs>();
        list = st.showStudent2("");
        model.addAttribute("listDeparts", list);
        
        Departs sv = new Departs();
        sv = list.get(0);
        model.addAttribute("departs", sv);
        return "table";
    }
          @RequestMapping("showall3")
        
    public String showAll3(ModelMap model){
        Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
                List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");
        model.addAttribute("listDeparts", listt);
        
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
        return "nhanvien";
    } 
              @RequestMapping("diem")

      public String showAll4(ModelMap model){
        Student3Model st = new Student3Model();
        List<xephangnv> listt2 = new ArrayList<xephangnv>();
         listt2 = st.xephangnv("");    
        model.addAttribute("xephangnv", listt2);        
      List<diem> listt = new ArrayList<diem>();
         listt = st.lichsudiem("");    
        model.addAttribute("lichsudiem", listt);             
                return "diem";

    }  
    
     @RequestMapping("index")
        
    public String index(ModelMap model){
      Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
                List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");    
        model.addAttribute("listDeparts", listt);
        
                        List<xephangnv> listt2 = new ArrayList<xephangnv>();
                        List<xephangpb> listt3 = new ArrayList<xephangpb>();

        listt2 = st.xephangnvngay("");    
        model.addAttribute("xephangnvngay", listt2);        

        listt2 = st.xephangnvtuan("");    
        model.addAttribute("xephangnvtuan", listt2);          
 
        listt2 = st.xephangnvthang("");    
        model.addAttribute("xephangnvthang", listt2);    
 
                listt3 = st.xephangpbngay("");    
        model.addAttribute("xephangpbngay", listt3);    

                 listt3 = st.xephangpbtuan("");    
        model.addAttribute("xephangpbtuan", listt3);          

                 listt3 = st.xephangpbthang("");    
        model.addAttribute("xephangpbthang", listt3);    
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
      
        return "index";
    }
    
        public String[] ten = new String[10];
    public String[] matkhau = new String[10];
    public String[] key = new String[50];

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
                key[i] = rs.getString("Maxacnhan");         

                i++;
            }

        } catch (Exception e) {
        }
        
    }
        public static Connection getConn(){
        try {
            String connectionUrl
                = "jdbc:sqlserver://ADMINISTRATOR:1433;databaseName=Personel;user=sa;password=123456";
                     
                  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con
                    = DriverManager.getConnection(connectionUrl);
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
        }
        return null;
    }

   @RequestMapping("user-form")
    public String showForm() {
        return "login";
    }
    @RequestMapping("login-user")
    
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
        List<Staffs> list = new ArrayList<Staffs>();
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
                List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");    
        model.addAttribute("listDeparts", listt);
        
                        List<xephangnv> listt2 = new ArrayList<xephangnv>();
                        List<xephangpb> listt3 = new ArrayList<xephangpb>();

        listt2 = st.xephangnvngay("");    
        model.addAttribute("xephangnvngay", listt2);        

        listt2 = st.xephangnvtuan("");    
        model.addAttribute("xephangnvtuan", listt2);          
 
        listt2 = st.xephangnvthang("");    
        model.addAttribute("xephangnvthang", listt2);    
 
                listt3 = st.xephangpbngay("");    
        model.addAttribute("xephangpbngay", listt3);    

                 listt3 = st.xephangpbtuan("");    
        model.addAttribute("xephangpbtuan", listt3);          

                 listt3 = st.xephangpbthang("");    
        model.addAttribute("xephangpbthang", listt3);    
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
      
        return "index";       
        
            }
        }
        model.addAttribute("message", "Sai thông tin đăng nhập!");
        return "login";

    }

        @RequestMapping("quenmatkhau")
    
    public String quenmk(@ModelAttribute("Student")Student student,  ModelMap model,HttpServletRequest request) throws InterruptedException {
        getDatabase();

        System.err.println(Arrays.deepToString(ten));
        String id = request.getParameter("id");
        for (int i = 0; i < ten.length; i++) {
            if (id.equals(ten[i])) {
                model.addAttribute("uid", id);
             Student3Model st = new Student3Model();
            String  a = UUID.randomUUID().toString();
            Student3Model.adkey(id,a);
            Student3Model.namphut(id);
            System.out.println("key: "+key[i]);
            model.addAttribute("ma", key[i]);
            getDatabase();
        
        	try{
                    String from = "Kurai";
			// Tạo mail
			MimeMessage mail =mailer.createMimeMessage();
			// Sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			
                        helper.setFrom(from, from);
			helper.setTo(id);
			helper.setReplyTo(from, from);
			helper.setSubject("Đổi mật khẩu");
			helper.setText("Bạn đã quên mật khẩu, để thiết lập lại mật khẩu, vui lòng nhấn vào đường link sau:\n                                                                                                http://localhost:8084/asmgd1_ps05549/student99/sosanhkey.html?id="+id+"&txtkey="+key[i], true);

			// Gửi mail
			mailer.send(mail);
                        model.addAttribute("message", "THÀNH CÔNG ! ");
			model.addAttribute("message1", "Đường dẫn đổi mật khẩu đã được gửi tới mail của bạn ! Đường dẫn sẽ hết hạn sau 5 phút");

			model.addAttribute("message2", "Cám ơn bạn đã sử dụng dịch vụ của chúng tôi !");
                                return "nhapmathanhcong";         

		}
		catch(Exception ex){
			model.addAttribute("message", "THẤT BẠI");
				model.addAttribute("message1", "Đường dẫn đổi mật khẩu vẫn chưa được gửi tới mail của bạn !");
			model.addAttribute("message2", "Xin lỗi vì sự bất tiện này !");
                                return "nhapma";         


                }
                
        
            }
        }
                  
        return "quenmk";


    }
    	@RequestMapping("form")
	public String index() {
		return "form";
	}
        	@Autowired
	ServletContext context;	
   @RequestMapping("send")
		public String send(ModelMap model, 
			@RequestParam("from") String from,
			@RequestParam("to") String to,
			@RequestParam("subject") String subject,
			@RequestParam("body") String body) {
		try{
			// Tạo mail
			MimeMessage mail =mailer.createMimeMessage();
			// Sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from, from);
			helper.setTo(to);
			helper.setReplyTo(from, from);
			helper.setSubject(subject);
			helper.setText(body, true);
                        
			// Gửi mail
			mailer.send(mail);
			
			model.addAttribute("message", "Gửi email thành công !");
		}
		catch(Exception ex){
			model.addAttribute("message", "Gửi email thất bại !");
		}
		return "form";
	}
      @RequestMapping("quayve")
    
    public String quayve(ModelMap model, HttpServletRequest request) {
    
            return "login";         

    }

       @RequestMapping("sosanhkey")
    
    public String sosanh(ModelMap model, HttpServletRequest request) throws SQLException {
        getDatabase();
        String ss = request.getParameter("txtkey");
                String id = request.getParameter("id");
                   for (int i = 0; i < ten.length; i++) {
            if (id.equals(ten[i])) {

         

            if (ss.equals(key[i])) {
                 Connection con = getConn();
                 PreparedStatement st = con.prepareStatement("Select * from USERS Where thoigian > getdate()"); 
                  ResultSet rs=st.executeQuery();
                            if(rs.next()){
                            
                                                                      model.addAttribute("uid", id);

                                    return "doimk";         

                            
                            }
     
       
        
                                          model.addAttribute("uid", id);
			model.addAttribute("message", "THẤT BẠI");
				model.addAttribute("message1", "Không thể thực hiện yêu cầu này!");
			model.addAttribute("message2", "Đường dẫn đã hết hạn");
        return "nhapma";       

        
            }
        

                model.addAttribute("uid", id);
			model.addAttribute("message", "THẤT BẠI");
				model.addAttribute("message1", "Không thể thực hiện yêu cầu này!");
			model.addAttribute("message2", "Đường dẫn đã hết hạn");
        return "nhapma";
        

    }
                   }
    
            return "login";

    }
    
    
       @RequestMapping(params="btnSearch")
    public String timkiem(ModelMap model, HttpServletRequest request){
        Student3Model st = new Student3Model();
        List<Student> list = new ArrayList<Student>();
        String tim = request.getParameter("tim");
        
        list = st.timkiem(tim);
        model.addAttribute("listStudent", list);
        
        Student sv = new Student();
        sv = list.get(0);
        model.addAttribute("student", sv);
        return "student99";
    }       
 @ModelAttribute("majors")

    public static List<Major> getMajors() {

        List<Major> majors = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select * from Major";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                majors.add(new Major(rs.getString(1), rs.getString(2)));

            }

        } catch (Exception e) {

        }
        return majors;
    }

     
    
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model){
        int masv = Integer.parseInt(request.getParameter("txtMasv"));
        String name = request.getParameter("txtName");
        double mark = Double.parseDouble(request.getParameter("txtMark"));
        String major = request.getParameter("txtMajor");
        Student sv = new Student(masv, name, mark, major);
        model.addAttribute("student", sv);
        
        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student99";
    }       
    
        @RequestMapping("edit2")
    public String edit2(HttpServletRequest request, ModelMap model){
        String id = request.getParameter("txtID");
        String name = request.getParameter("txtName");
        Departs sv = new Departs(id,name);
        model.addAttribute("departs", sv);     
              
        
   
        
        
        request.setAttribute("mess", 1);
        
        
        
        
        List<Departs> list = new ArrayList<Departs>();
        list = Student3Model.showStudent2("");      
        model.addAttribute("listDeparts", list);
                return "table";
                
              
                
    } 
            @RequestMapping("edit3")
    public String edit3(HttpServletRequest request, ModelMap model){
        String id = request.getParameter("txtID");
        String name = request.getParameter("txtName");
        String gender = request.getParameter("txtgender");
        String birthday = request.getParameter("txtbirthday");
        String photo = request.getParameter("txtphoto");
        String email = request.getParameter("txtemail");
        String phone = request.getParameter("txtphone");
        String salary = request.getParameter("txtsalary");
        String notes = request.getParameter("txtnotes");
        String departid = request.getParameter("txtdepartid");
        
        if(gender.equals("true")){
                model.addAttribute("nam", "checked");     
                model.addAttribute("nu", "");     

        
        }
        else {
                model.addAttribute("nu", "checked");     
                model.addAttribute("nam", "");     


        
        
        }
        
        model.addAttribute("id", id);     
        model.addAttribute("name", name);     
        model.addAttribute("gender", gender);     
        model.addAttribute("birthday", birthday);     
        model.addAttribute("photo", photo);     
        model.addAttribute("email", email);     
        model.addAttribute("phone", phone);     
        model.addAttribute("salary", salary);     
        model.addAttribute("notes", notes);     
        model.addAttribute("departid", departid);     
              
        
   
        
        
        request.setAttribute("messa", 1);
        
        
        
        
       Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
                List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");
        model.addAttribute("listDeparts", listt);
        
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
        return "nhanvien";
              
                
    }
    
    
          @RequestMapping("them")
    public String them(@ModelAttribute("departs") Departs departs,HttpServletRequest request, ModelMap model){
        String id = request.getParameter("rong");
        String name = request.getParameter("rong2");
        Departs sv = new Departs(id,name);
        model.addAttribute("departs", sv);     
              
        
   
        
        
        request.setAttribute("mess2", 1);
        List<Departs> list = new ArrayList<Departs>();
        list = Student3Model.showStudent2("");      
        model.addAttribute("listDeparts", list);
                return "table";
                
              
                
    } 
    
    
    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("student") Student student){
        int masv = Integer.parseInt(request.getParameter("txtMasv"));
        Student3Model.delete(masv);
        
        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student99";
    }
    
        @RequestMapping("delete2")
    public String delete2(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("departs") Departs departs){
        String id = request.getParameter("txtID");
        Student3Model.delete2(id);
        
            Student3Model st = new Student3Model();
        List<Departs> list = new ArrayList<Departs>();
        list = st.showStudent2("");
        model.addAttribute("listDeparts", list);
        return "table";
    }
         @RequestMapping("delete3")
    public String delete3(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("departs") Departs departs){
        String id = request.getParameter("txtID");
        Student3Model.delete3(id);
        
         Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
             List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");
        model.addAttribute("listDeparts", listt);
        return "nhanvien";
    }   
    
    @RequestMapping(params="btnUpdate2")
    public String update(@ModelAttribute("departs") Departs departs, ModelMap model) {       
        Student3Model.update2(departs);
        
        List<Departs> list = new ArrayList<Departs>();
        list = Student3Model.showStudent2("");
        
        model.addAttribute("listDeparts", list);
        return "table";
    }   
    
       @RequestMapping("btnUpdate3")
    public String update2(ModelMap model,
            HttpServletRequest request,
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
	    @RequestParam("birthday") String birthday,
	    @RequestParam("image") MultipartFile image,
	    @RequestParam("email") String email,
	    @RequestParam("phone") String phone,
	    @RequestParam("salary") String salary,
	    @RequestParam("notes") String notes,
	    @RequestParam("departid") String departid) throws SQLException{
    
    if (id.equals("") || name.equals("") || email.equals("") || salary.equals("")  ) {
                             model.addAttribute("uid","Bạn đã bỏ trống 1 số trường bắt buộc");
            
        } else { if (image.isEmpty() ) {
            Student3Model.update3k(id,name,gender,birthday,email,phone,salary,notes,departid);
                            
            
        }       
        else{
            try {
        

                Student3Model.update3(id,name,gender,birthday, "images/hinh/" + "hinh"+id+".jpg",email,phone,salary,notes,departid);
                String path = context.getRealPath("/images/hinh/" + "hinh"+id+".jpg");
                image.transferTo(new File(path));
                            sleep(5000);

            } catch (Exception e) {
                e.printStackTrace();

                    
            }
        
        }
    
    
    
    }
        Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
                List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");
        model.addAttribute("listDeparts", listt);
        
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
        return "nhanvien";
     }
    
    
    
      @RequestMapping(params="btnUpdate")
    public String update(@ModelAttribute("student") Student student, ModelMap model) {       
        Student3Model.update(student);
        
        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student99";
    }   
    
    @RequestMapping(params="btnInsert")
    public String insert(@ModelAttribute("student") Student student, ModelMap model){
        Student3Model.insert(student);
        
        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student99";
    }
      @RequestMapping(params="btnInsert2")
    public String insert2(@ModelAttribute("departs") Departs departs, ModelMap model){
        Student3Model.insert2(departs);
        
        
        
        List<Departs> list = new ArrayList<Departs>();
        list = Student3Model.showStudent2("");
        model.addAttribute("listDeparts", list);
        return "table";
    }
    
	
       @RequestMapping("btnInsert3")
    public String insert3(ModelMap model,
            HttpServletRequest request,
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
	    @RequestParam("birthday") String birthday,
	    @RequestParam("image") MultipartFile image,
	    @RequestParam("email") String email,
	    @RequestParam("phone") String phone,
	    @RequestParam("salary") String salary,
	    @RequestParam("notes") String notes,
	    @RequestParam("departid") String departid
            
            
            
            
            ) throws SQLException{
    
    if (id.equals("") || name.equals("") || email.equals("") || salary.equals("")  ) {
                             model.addAttribute("uid","Bạn đã bỏ trống 1 số trường bắt buộc");
            
        } else { if (image.isEmpty() ) {
            Student3Model.insert3(id,name,gender,birthday,"images/NoneIMG.png",email,phone,salary,notes,departid);
                            
            
        } else{
        
        
                        Connection con = getConn();
                 PreparedStatement st = con.prepareStatement("Select * from staffs Where id like'"+id+"'"); 
                  ResultSet rs=st.executeQuery();
                            if(rs.next()){
                            
                                                                      model.addAttribute("uid", id+" đã tồn tại");


                            
                            }
                            
                            else{
                            
                            
                        
            try {
        

                Student3Model.insert3(id,name,gender,birthday, "images/hinh/" + "hinh"+id+".jpg",email,phone,salary,notes,departid);
                String path = context.getRealPath("/images/hinh/" + "hinh"+id+".jpg");
                image.transferTo(new File(path));
                            sleep(5000);

            } catch (Exception e) {
                e.printStackTrace();

                    
            }
        }
    } }
    {
        
        
        
        
        
        
        
           Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
 
          List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");
        model.addAttribute("listDeparts", listt);
        return "nhanvien";


}
    }

  	        @RequestMapping("goidanhgia")
    public String goidanhgia(HttpServletRequest request, ModelMap model){
                    String id = request.getParameter("txtID");
                    String name = request.getParameter("txtName");
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();
                    model.addAttribute("date", dateFormat.format(date));
                    String email = request.getParameter("txtemail");

                    model.addAttribute("name", name);

                    model.addAttribute("id", id);
                    model.addAttribute("email", email);

        
   
        
        
        request.setAttribute("messa", 0);
        request.setAttribute("danhgia", 1);
        
        
        
        
              Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
 
          List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");
        model.addAttribute("listDeparts", listt);
        return "nhanvien";
              
                
    } 
 
      	        @RequestMapping("goidanhgia2")
    public String goidanhgia2(HttpServletRequest request, ModelMap model){
                String id = request.getParameter("txtID");
                String name = request.getParameter("txtName");
                
                String email = request.getParameter("txtemail");
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date();
                    model.addAttribute("date", dateFormat.format(date));
                        model.addAttribute("name", name);       
                        model.addAttribute("id", id);       
                        model.addAttribute("email", email);       
              
        
           request.setAttribute("messa", 0);
        request.setAttribute("danhgia", 0);
        request.setAttribute("danhgia2", 1);
        
        

        
        
        
        
              Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
 
          List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");
        model.addAttribute("listDeparts", listt);
        return "nhanvien";
              
                
    } 
    
    
    
    
    
    
    
           @RequestMapping("danhgia")
    public String danhgia(ModelMap model,    
            HttpServletRequest request,
            @RequestParam("lydo1") String lydo1,
            @RequestParam("lydo2") String lydo2,
            @RequestParam("id") String id,
            @RequestParam("email") String email,
            @RequestParam("name") String name,
            @RequestParam("check") String check,
            @RequestParam("ngay") String ngay
            
){
          String lydo;     

    if (lydo1.equals("")){
   lydo=lydo2;
    
    }else{
       lydo=lydo1;

    
    }
        if (check.equals("co")){
              	try{
                    String from = "Kurai";
			// Tạo mail
			MimeMessage mail =mailer.createMimeMessage();
			// Sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			
                        helper.setFrom(from, from);
			helper.setTo(email);
			helper.setReplyTo(from, from);
			helper.setSubject("Đánh giá nhân viên");
			helper.setText("Chào, "+name+" Vào ngày "+ngay+", Bạn đã được khen thưởng, lý do: "+lydo, true);

			// Gửi mail
			mailer.send(mail);
                        model.addAttribute("uid", "Mail đánh giá đã được gửi ! ");
	

		} catch(Exception e)      {
                                        model.addAttribute("uid", "Mail đánh giá vẫn chưa được gửi ! Khen thưởng nhân viên: "+name+" thành công ! ");

                
                }}
        else{
                                        model.addAttribute("uid", "Khen thưởng nhân viên: "+name+" thành công !");

        
        }
    
        Student3Model.danhgia(id,lydo,ngay);
        
        
        
             Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
 
          List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");
        model.addAttribute("listDeparts", listt);
        return "nhanvien";

    }
   
     @RequestMapping("danhgia2")
    public String danhgia2(ModelMap model,    
            HttpServletRequest request,
            @RequestParam("lydo1") String lydo1,
            @RequestParam("lydo2") String lydo2,
            @RequestParam("id") String id,
            @RequestParam("email") String email,
            @RequestParam("name") String name,
            @RequestParam("check2") String check,
            @RequestParam("ngay") String ngay
            
){
          String lydo;     

    if (lydo1.equals("")){
   lydo=lydo2;
    
    }else{
       lydo=lydo1;

    
    }
        if (check.equals("co")){
              	try{
                    String from = "Kurai";
			// Tạo mail
			MimeMessage mail =mailer.createMimeMessage();
			// Sử dụng lớp trợ giúp
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			
                        helper.setFrom(from, from);
			helper.setTo(email);
			helper.setReplyTo(from, from);
			helper.setSubject("Đánh giá nhân viên");
			helper.setText("Chào, "+name+" Vào ngày "+ngay+", Bạn đã bị khiển trách, lý do: "+lydo, true);

			// Gửi mail
			mailer.send(mail);
                        model.addAttribute("uid", "Mail đánh giá đã được gửi ! khiển trách nhân viên: "+name+" thành công ! ");
	

		} catch(Exception e)      {
                                        model.addAttribute("uid", "Mail đánh giá vẫn chưa được gửi ! ");

                
                }}
        else{
                                model.addAttribute("uid", "Khiển trách nhân viên: "+name+" thành công !");

        }
    
        Student3Model.danhgia2(id,lydo,ngay);
        
        
        
             Student3Model st = new Student3Model();
        List<Staffs> list = new ArrayList<Staffs>();
        
        list = st.showStudent3("");
        model.addAttribute("listStaffs", list);
        
        Staffs sv = new Staffs();
        sv = list.get(0);
        model.addAttribute("staffs", sv);
 
          List<Departs> listt = new ArrayList<Departs>();
        listt = st.showStudent2("");
        model.addAttribute("listDeparts", listt);
        return "nhanvien";

    }    
    
    
    
    
 	@RequestMapping("btnInsert3a")
	public String upload(ModelMap model, 
			@RequestParam("image") MultipartFile image) {
		if(image.isEmpty()){
			model.addAttribute("message", "Vui lòng chọn file !");
		}
		else{
			try {
				String path = context.getRealPath("/images/"+image.getOriginalFilename());
				image.transferTo(new File(path));
                                System.out.println(path);   
				model.addAttribute("name", image.getOriginalFilename());
				model.addAttribute("type", image.getContentType());
				model.addAttribute("size", image.getSize());
                                
				return "uploader/success";
                                                               

			} 
			catch (Exception e) {
				model.addAttribute("message", "Lỗi lưu file !");
			}
		}
		return "uploader/form";
	}
}
