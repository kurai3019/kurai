package phunglv.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import phunglv.bean.Major;
import phunglv.bean.Student;

@Controller
@RequestMapping("/student2/")
public class Student2Controller {
	
	@RequestMapping("edit")
	public String edit(ModelMap model) {
		Student sv = new Student("Nguyễn Thị Tám", 8.3, "WEB");
		model.addAttribute("student", sv);
		return "student2";
	}
	
	@RequestMapping("update")
	public String update(@ModelAttribute("student") Student student) {
		return "student2";
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
	/*
	 * Xử dụng mảng
	 *	
	*/
//	@ModelAttribute("majors")
//	public String[] getMajors() {
//		String[] majors = {
//				"Ứng dụng phần mềm",
//				"Thiết kế trang web"
//		};
//		return majors;
//	}
	/*
	 * Xử dụng List<String>
	 *
	@ModelAttribute("majors")
	public List<String> getMajors() {
		List<String> majors = new ArrayList<>();
		majors.add("Ứng dụng phần mềm");
		majors.add("Thiết kế trang web");
		return majors;
	}
	*/
	
	/*
	 * Xử dụng Map<String, String>
	 *
	*/
//        @ModelAttribute("majors")
//	public Map<String, String> getMajors() {
//		Map<String, String> majors = new HashMap<>();
//		majors.put("APP", "Ứng dụng phần mềm");
//		majors.put("WEB", "Thiết kế trang web");
//		return majors;
//	}
}
