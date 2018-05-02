/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phunglv.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import phunglv.bean.Departs;
import phunglv.bean.Staffs;
import phunglv.bean.Student;
import phunglv.bean.diem;
import phunglv.bean.xephangnv;
import phunglv.bean.xephangpb;

/**
 *
 * @author Administrator
 */
public class Student3Model {



    public Student3Model() {
    }
    
    public static List<Student> showStudent(String tensp){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select * from Students";
            if(tensp.length() > 0){
                sql += " where Name like '%"+tensp+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Student> list = new ArrayList<Student>();
            while(rs.next()){
                int masv = rs.getInt("masv");
                String name = rs.getString("name");
                double mark = rs.getDouble("mark");
                String major = rs.getString("major");
                Student sp = new Student(masv,name, mark, major);
                list.add(sp);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
        public static List<Departs> showStudent2(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select * from Departs";
            if(tenpb.length() > 0){
                sql += " where ID like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Departs> list = new ArrayList<Departs>();
            while(rs.next()){
                String ID = rs.getString("ID");
                String Namee = rs.getString("Name");
                Departs spa = new Departs(ID,Namee);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
        public static List<Staffs> showStudent3(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "SELECT id,name,gender,convert(varchar, Birthday, 103) as 'Birthday',photo,email,phone,salary,notes,DepartId\n" +
" from staffs ";
            if(tenpb.length() > 0){
                sql += " where ID like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Staffs> list = new ArrayList<Staffs>();
            while(rs.next()){
                String ID = rs.getString("ID");
                String Name = rs.getString("Name");
                Boolean Gender = rs.getBoolean("Gender");
                String Birthday = rs.getString("Birthday");
                String Photo = rs.getString("Photo");
                String Email = rs.getString("Email");
                String Phone = rs.getString("Phone");
                float Salary = rs.getFloat("Salary");
                String Notes = rs.getString("Notes");
                String DepartId = rs.getString("DepartId");
                
                
                
                
                
                Staffs spa = new Staffs(ID,Name,Gender,Birthday,Photo,Email,Phone,Salary,Notes,DepartId);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }    
        public static List<xephangnv> xephangnvngay(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select top 5 Staffs.Photo,Staffs.Name,sum(type)as 'Mark',Departs.Name as departs from records,Staffs,Departs\n" +
"where Records.StaffId=Staffs.id and Departs.Id=Staffs.DepartId and date=convert(varchar,getdate(),110)\n" +
"group by Staffs.Name,Records.StaffId,Staffs.Photo,Departs.Name\n" +
"order by Mark DESC";
            if(tenpb.length() > 0){
                sql += " where Name like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<xephangnv> list = new ArrayList<xephangnv>();
            while(rs.next()){
                String Photo = rs.getString("Photo");
                String Name = rs.getString("Name");
                String Mark = rs.getString("Mark");
                String departs = rs.getString("departs");
                
                xephangnv spa = new xephangnv(Photo,Name,Mark,departs);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
            public static List<xephangnv> xephangnvtuan(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select top 5 Staffs.Photo,Staffs.Name,sum(type)as 'Mark',Departs.Name as departs from records,Staffs,Departs\n" +
"where Records.StaffId=Staffs.id and Departs.Id=Staffs.DepartId and date BETWEEN CONVERT(DATE,DATEADD(day,\n" +
"                - (DATEPART(weekday, GETDATE()) + @@DATEFIRST - 2) % 7,\n" +
"               GETDATE())) AND CONVERT(DATE,DATEADD(day,\n" +
"               +6 - (DATEPART(weekday, GETDATE()) + @@DATEFIRST - 2) % 7,\n" +
"               GETDATE()\n" +
"              ))\n" +
"              \n" +
"group by Staffs.Name,Records.StaffId,Staffs.Photo,Departs.Name\n" +
"order by Mark DESC";
            if(tenpb.length() > 0){
                sql += " where Name like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<xephangnv> list = new ArrayList<xephangnv>();
            while(rs.next()){
                String Photo = rs.getString("Photo");
                String Name = rs.getString("Name");
                String Mark = rs.getString("Mark");
                String departs = rs.getString("departs");
                
                xephangnv spa = new xephangnv(Photo,Name,Mark,departs);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }       
        
            public static List<xephangnv> xephangnvthang(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select top 5 Staffs.Photo,Staffs.Name,sum(type)as 'Mark',Departs.Name as departs from records,Staffs,Departs\n" +
"where Records.StaffId=Staffs.id and Departs.Id=Staffs.DepartId and date between CONVERT(date,DATEADD(DAY,1,GETDATE())- day(DATEADD(MONTH,1,GETDATE()))) and EOMONTH (GETDATE())\n" +
"group by Staffs.Name,Records.StaffId,Staffs.Photo,Departs.Name\n" +
"order by Mark DESC";
            if(tenpb.length() > 0){
                sql += " where Name like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<xephangnv> list = new ArrayList<xephangnv>();
            while(rs.next()){
                String Photo = rs.getString("Photo");
                String Name = rs.getString("Name");
                String Mark = rs.getString("Mark");
                String departs = rs.getString("departs");
                
                xephangnv spa = new xephangnv(Photo,Name,Mark,departs);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }   
            public static List<xephangnv> xephangnv(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select Staffs.Photo,Staffs.Name,sum(type)as 'Mark',Departs.Name as departs from records,Staffs,Departs\n" +
"where Records.StaffId=Staffs.id and Departs.Id=Staffs.DepartId \n" +
"group by Staffs.Name,Records.StaffId,Staffs.Photo,Departs.Name\n" +
"order by Mark DESC";
            if(tenpb.length() > 0){
                sql += " where Name like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<xephangnv> list = new ArrayList<xephangnv>();
            while(rs.next()){
                String Photo = rs.getString("Photo");
                String Name = rs.getString("Name");
                String Mark = rs.getString("Mark");
                String departs = rs.getString("departs");
                
                xephangnv spa = new xephangnv(Photo,Name,Mark,departs);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }      
           public static List<diem> lichsudiem(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select type,reason,date=convert(varchar,date,103),staffs.name from Records,Staffs\n" +
"where Records.StaffId=Staffs.Id\n" +
"order by records.id desc";
            if(tenpb.length() > 0){
                sql += " where Name like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<diem> list = new ArrayList<diem>();
            while(rs.next()){
                String type = rs.getString("type");
                String reason = rs.getString("reason");
                String date = rs.getString("date");
                String name = rs.getString("name");
                
                diem spa = new diem(type,reason,date,name);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }               
            
            
             public static List<xephangpb> xephangpbngay(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select top 5 sum(type)as 'Mark',Departs.Name from records,Staffs,Departs\n" +
"where Records.StaffId=Staffs.id and Departs.Id=Staffs.DepartId and date=convert(varchar,getdate(),110)\n" +
"group by Departs.Name\n" +
"order by Mark DESC";
            if(tenpb.length() > 0){
                sql += " where Name like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<xephangpb> list = new ArrayList<xephangpb>();
            while(rs.next()){
                String Mark = rs.getString("Mark");
                String Name = rs.getString("name");
                
                xephangpb spa = new xephangpb(Mark,Name);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }             
             public static List<xephangpb> xephangpbtuan(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select top 5 sum(type)as 'Mark',Departs.Name from records,Staffs,Departs\n" +
"where Records.StaffId=Staffs.id and Departs.Id=Staffs.DepartId and date BETWEEN CONVERT(DATE,DATEADD(day,\n" +
"                - (DATEPART(weekday, GETDATE()) + @@DATEFIRST - 2) % 7,\n" +
"               GETDATE())) AND CONVERT(DATE,DATEADD(day,\n" +
"               +6 - (DATEPART(weekday, GETDATE()) + @@DATEFIRST - 2) % 7,\n" +
"               GETDATE()\n" +
"              ))\n" +
"              \n" +
"group by Departs.Name\n" +
"order by Mark DESC";
            if(tenpb.length() > 0){
                sql += " where Name like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<xephangpb> list = new ArrayList<xephangpb>();
            while(rs.next()){
                String Mark = rs.getString("Mark");
                String Name = rs.getString("name");
                
                xephangpb spa = new xephangpb(Mark,Name);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }    
             public static List<xephangpb> xephangpbthang(String tenpb){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select top 5 sum(type)as 'Mark',Departs.Name from records,Staffs,Departs\n" +
"where Records.StaffId=Staffs.id and Departs.Id=Staffs.DepartId and date between CONVERT(date,DATEADD(DAY,1,GETDATE())- day(DATEADD(MONTH,1,GETDATE()))) and EOMONTH (GETDATE())\n" +
"group by Departs.Name\n" +
"order by Mark DESC";
            if(tenpb.length() > 0){
                sql += " where Name like '%"+tenpb+"%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<xephangpb> list = new ArrayList<xephangpb>();
            while(rs.next()){
                String Mark = rs.getString("Mark");
                String Name = rs.getString("name");
                
                xephangpb spa = new xephangpb(Mark,Name);
                list.add(spa);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }              
             
    public static List<Student> timkiem(String tim){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "select * from Students";
            if(tim.length() > 0){
                sql += " where Name like N'%"+tim+"%' or mark like '%"+tim+"%' or major like '"+tim+"'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Student> list = new ArrayList<Student>();
            while(rs.next()){
                int masv = rs.getInt("masv");
                String name = rs.getString("name");
                double mark = rs.getDouble("mark");
                String major = rs.getString("major");
                Student sp = new Student(masv,name, mark, major);
                list.add(sp);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
        
    public static void delete(int masv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "delete from Students where masv=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, masv);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
       public static void delete2(String id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "delete from departs where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
         public static void delete3(String id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "delete from Records where StaffId=?\n" +
"delete from Staffs where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, id);            
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }  
    public static void insert(Student sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "insert into Students values(?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getName());
            stm.setDouble(2, sv.getMark());
            stm.setString(3, sv.getMajor());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public static void insert2 (Departs sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "insert into Departs values (?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getid());
            stm.setString(2, sv.getname());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
       public static void insert3 (String id, String name,String gender,String birthday,String image,String email,String phone,String salary,String notes,String departid){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");

            String sql = "insert into Staffs values (?,?,?,?,?,?,?,?,?,?)";
           if (image.length() > 0 ){
           } else {
               image ="images/EB.jpg";
           
           }
           
            
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, name);
            stm.setString(3, gender);
            stm.setString(4, birthday);
            stm.setString(5, image);
            stm.setString(6, email);
            stm.setString(7, phone);
            stm.setString(8, salary);
            stm.setString(9, notes);
            stm.setString(10, departid);
            
            
            
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
       
         public static void danhgia (String id, String lydo,String ngay){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");

            String sql = "insert into Records values (1,?,?,?)";

           
            
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(3, id);
            
            stm.setString(2, ngay);
            
            stm.setString(1, lydo);

            
            
            
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }     
   
         
   public static void danhgia2 (String id, String lydo,String ngay){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");

            String sql = "insert into Records values (-1,?,?,?)";

           
            
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(3, id);
            stm.setString(2, ngay);
            stm.setString(1, lydo);

            
            
            
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }             
         
         
    public static void update(Student sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "update Students set name=?, mark=?, major=? where masv=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, sv.getName());
            stm.setDouble(2, sv.getMark());
            stm.setString(3, sv.getMajor());
            stm.setInt(4, sv.getMasv());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     public static void adkey(String id,String key){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "update Users set Maxacnhan=? where username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(2, id);
            stm.setString(1, key);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
         public static void namphut(String id){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "update Users set thoigian=DATEADD(minute,5,getdate()) where username=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    public static void update2(Departs sv){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");
            String sql = "update Departs set name=? where id=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(2, sv.getid());
            stm.setString(1, sv.getname());
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
           public static void update3 (String id, String name,String gender,String birthday,String image,String email,String phone,String salary,String notes,String departid){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");

            String sql = "update Staffs set name=?,gender=?,birthday=?,photo=?,email=?,phone=?,salary=?,notes=?,departid=? where id=?";
           if (image.length() > 0 ){
           } else {
               image ="images/EB.jpg";
           
           }
           
            
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(10, id);
            stm.setString(1, name);
            stm.setString(2, gender);
            stm.setString(3, birthday);
            stm.setString(4, image);
            stm.setString(5, email);
            stm.setString(6, phone);
            stm.setString(7, salary);
            stm.setString(8, notes);
            stm.setString(9, departid);
            
            
            
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
           public static void update3k (String id, String name,String gender,String birthday,String email,String phone,String salary,String notes,String departid){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://ADMINISTRATOR\\KURAI:1433;databaseName=Personel";
            Connection con = DriverManager.getConnection(url, "sa", "123456");

            String sql = "update Staffs set name=?,gender=?,birthday=?,email=?,phone=?,salary=?,notes=?,departid=? where id=?";

           
            
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(9, id);
            stm.setString(1, name);
            stm.setString(2, gender);
            stm.setString(3, birthday);
            stm.setString(4, email);
            stm.setString(5, phone);
            stm.setString(6, salary);
            stm.setString(7, notes);
            stm.setString(8, departid);
            
            
            
            stm.executeUpdate();
            stm.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}