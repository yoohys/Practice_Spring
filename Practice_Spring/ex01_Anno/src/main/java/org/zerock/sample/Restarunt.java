package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;
//@Component:스프링에게 클래스가 관리해야될 대상임을 표시(객체생성,객체관리)
//@Data:lombok설치시 내장,setter()&getter(),constructor, toString등을 자동 생성
@Component
@Data
public class Restarunt {
//Setter()주입: spring5.0	
	@Setter(onMethod = @__({@Autowired}))
	private Chef chef;
	
	//Setter()주입: spring4.0		
//	public void setChef(Chef chef) {
//		this.chef=chef;
//	}
}
