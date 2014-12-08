package com.demo.springmvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.springmvc.model.User;
import com.demo.springmvc.util.Log4jUtil;

/**
 * @author dreajay
 *
 */
@Controller
public class ResetfulController extends Context {

	/**
	 * 查询单个用户
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public User get(@PathVariable("userId") int userId) {
		Log4jUtil.debug(this, "获取用户userId=" + userId);
		User user = createUser(userId);
		return user;
	}

	/**
	 * 查询用户列表
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PATCH)
	@ResponseBody
	public List<User> getList(@RequestBody User user) {
		// 可以根据具体参数来查询所有符合的用户，比如查询用户名称为张三的人，username='张三'
		Log4jUtil.debug(this, "获取用户列表user=" + user);
		List<User> list = new ArrayList<User>();
		list.add(createUser(1));
		list.add(createUser(2));
		list.add(createUser(3));
		list.add(createUser(4));
		list.add(createUser(5));
		return list;
	}

	/***********************************************************************************************************************************
	 * 绑定对象的方式有两种： <br/>
	 * 表单方式：<br/>
	 * 客户端：表单中字段的名称对应对象属性 <br/>
	 * 服务端：服务端方法里面加入对象参数，即可绑定 <br/>
	 * ajax方式：<br/>
	 * 客户端：dataType:'json'，contentType:'application/json'，data:JSON.stringify(data)，JSON.stringify的作用为将data转化为json字符串 <br/>
	 * 服务端：服务端方法的参数使用注解@RequestBody,表明参数类型为json字符串,返回值使用@ResponseBody注解，
	 * 表明返回类型为json对象 <br/>
	 ***********************************************************************************************************************************/

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@RequestBody User user) {
		Log4jUtil.debug(this, "新增用户：" + user);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("user", user);
		dataMap.put("result", "新增用户成功");
		return dataMap;
	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
	@ResponseBody
	public Object update(@RequestBody User user) {
		User u = createUser(5);
		u.setUsername(user.getUsername());
		Log4jUtil.debug(this, "更新用户：" + user);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("user", user);
		dataMap.put("result", "更新用户成功");
		return dataMap;
	}

	/**
	 * 删除用户
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Object delete(@PathVariable("userId") int userId) {
		Log4jUtil.debug(this, "删除用户userId=" + userId);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("result", "删除用户成功");
		return dataMap;
	}

	/**
	 * 创建用户
	 * 
	 * @param userId
	 * @return
	 */
	private User createUser(int userId) {
		User user = new User();
		user.setUserId(userId);
		user.setUsername("user" + userId);
		user.setPassword("123456");
		user.setEmail("user" + userId + "@xxx.com");
		user.setSex("男");
		user.setTelephone("1234567");
		return user;
	}

}
