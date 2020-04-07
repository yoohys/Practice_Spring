package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.ToString;

@Component
@ToString
@Getter
public class SampleHotel {
	
	
	private Chef chef;
	//단일생성자의 묵시적 자동주입(@Autowired 생략)
	//생성자 주입
	public SampleHotel(Chef chef) {
		super();
		this.chef = chef;
	}
	
	
	
}
