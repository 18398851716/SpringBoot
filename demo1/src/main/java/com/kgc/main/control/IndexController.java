package com.kgc.main.control;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kgc.main.annotation.NoRepeatSubmit;
import com.kgc.main.pojo.User;
import com.kgc.main.service.UserService;
import com.kgc.main.validatecode.ValidateCodeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 * @Api：用在请求的类上，表示对类的说明
    tags="说明该类的作用，可以在UI界面上看到的注解"
    value="该参数没什么意义，在UI界面上也看到，所以不需要配置"
 * @author Y.S.K
 *
 */
@Controller
@Api(value="/test",tags="测试接口模块")
public class IndexController {
	@Autowired
	private UserService us;
	/**
     * @ApiOperation：用在请求的方法上，说明方法的用途、作用
    		value="说明方法的用途、作用"
    	notes="方法的备注说明"
	@ApiImplicitParams：用在请求的方法上，表示一组参数说明
    @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
        name：参数名
        value：参数的汉字说明、解释
        required：参数是否必须传
        paramType：参数放在哪个地方
            · header --> 请求参数的获取：@RequestHeader
            · query --> 请求参数的获取：@RequestParam
            · path（用于restful接口）--> 请求参数的获取：@PathVariable
            · body（不常用）
            · form（不常用）    
        dataType：参数类型，默认String，其它值dataType="Integer"       
        defaultValue：参数的默认值

@ApiResponses：用在请求的方法上，表示一组响应
    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
        code：数字，例如400
        message：信息，例如"请求参数没填好"
        response：抛出异常的类

@ApiModel：用于响应类上，表示一个返回响应数据的信息
            （这种一般用在post创建的时候，使用@RequestBody这样的场景，
            请求参数无法使用@ApiImplicitParam注解进行描述的时候）
    @ApiModelProperty：用在属性上，描述响应类的属性
     * @return
     */
	//自带的页面显示字符串
	@NoRepeatSubmit
	@RequestMapping("/login")
	@ApiOperation(value="查询用户信息", notes = "查询用户信息")
	@ApiImplicitParams(value = { @ApiImplicitParam(name="tel", value="tel", required = true, dataType = "String")})
	public String say(@RequestParam String tel,@RequestParam String pwd,@RequestParam String yzm,Model model,HttpServletRequest req) {
		User user = us.getUserById(Integer.parseInt(tel));
		HttpSession session = req.getSession();
		String code = (String) session.getAttribute("validatecodekey");
		if(!(code.toLowerCase()).equals(yzm.toLowerCase())) {
			model.addAttribute("msg", "验证码错误");
			return "error";
		}
		//System.out.println(code);		
		if(user!=null) {
			//System.out.println(user);
			if(user.getPassword().equals(pwd)) {
				//us.deleteCache();
				return "index";
			}
			else {
				model.addAttribute("msg", "账号或密码错误");
				return "error";
			}
		}else {		
			model.addAttribute("msg", "账号或密码错误");
			return "error";
		}
	}
	@NoRepeatSubmit
	@RequestMapping("/i")
	@ApiOperation(value="展示首页信息", notes = "展示首页信息")
	public String say() {	
		return "index";
	}
	//返回一个页面，并打开该页面（转发）
	@NoRepeatSubmit
	@RequestMapping("/index")
	public ModelAndView say1() {
		//System.out.println("123456");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
   //重定向
	@RequestMapping("/a")
	public void say3(HttpServletResponse resp) {
		try {
			resp.sendRedirect("http://www.runoob.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//验证码
	@RequestMapping("/code")
	public void say4(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
			//response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
			response.setHeader("Cache-Control", "no-cache");
			//response.setDateHeader("Expire", 0);
			ValidateCodeUtil randomValidateCode = new ValidateCodeUtil();
			//ValidateCodeUtil randomValidateCode = new ValidateCodeUtil(60, 20, 20, 3);
			randomValidateCode.getRandcode(request, response);//输出验证码图片方法
			//String code = (String) request.getSession().getAttribute(ValidateCodeUtil.RANDOMCODEKEY);
			//System.out.println(code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
