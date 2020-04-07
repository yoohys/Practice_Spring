package org.zerock.sample;
//69
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
//@AllArgsConstructor : 생성자 파라미터 작성을 대신

@Component
@ToString
@Getter
@AllArgsConstructor
public class SampleHotel2 {
	
	
	private Chef chef;
	//단일생성자의 묵시적 자동주입(@Autowired 생략)
	//생성자 주입
//	public SampleHotel2(Chef chef) {
//		super();
//		this.chef = chef;
//	}
	
	
	
}
