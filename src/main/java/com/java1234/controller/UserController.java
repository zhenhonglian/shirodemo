package com.java1234.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java1234.entity.User;
import com.java1234.service.UserService;




/**
 * 锟矫伙拷Controller锟斤拷
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	


	@Resource
	private UserService userservice;
	/**
	 * 锟矫伙拷锟斤拷录
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public String login(User user,HttpServletRequest request){
		Subject subject=SecurityUtils.getSubject();
		 String asd=new Md5Hash(user.getPassword(),"lalala").toString();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(), asd);
		try{
			subject.login(token);
			Session session=subject.getSession();
			System.out.println("sessionId:"+session.getId());
			System.out.println("sessionHost:"+session.getHost());
			System.out.println("sessionTimeout:"+session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "redirect:/success.jsp";
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "账号密码错误");
			return "index";
		}
	}
    @RequestMapping("/toAddUser")
    public String toAddUser() {
    	return"/addUser";
    }
    @RequestMapping("/addUser")
    public String addUser(User user,Model model) {
        int result = userservice.addUser(user.getUserName(), user.getPassword());
          
        if(result>0){  
            //将提示信息存入域中，用以前台显示  
            model.addAttribute("msg","恭喜您，注册成功！<br>注册名："+user.getUserName());  
            return "index";  
        }else{  
            model.addAttribute("msg","服务器异常，注册失败！");  
            return "WEB-INF/fail";  
        }  
    } 
	

	

}
