package com.jpm.sys.entity;

import org.hibernate.validator.constraints.Length;
import com.jpm.common.entity.DataEntity;
/**
 * 系统用户管理Entity
 * @author 李杰
 * @version 2018-08-20
 */
public class SysUserEntity extends DataEntity<SysUserEntity,String> {

	private static final long serialVersionUID = 1L;
	private String username;        // 账号
	private String password;        // 密码
	public SysUserEntity() {
		super();
	}

	public SysUserEntity(String id){
		super(id);
	}

		@Length(min=0, max=20, message="账号长度必须介于 0 和 20 之间")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
		@Length(min=0, max=100, message="密码长度必须介于 0 和 100 之间")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}