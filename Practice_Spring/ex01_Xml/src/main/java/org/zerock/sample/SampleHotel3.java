package org.zerock.sample;
//69
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
//@RequiredArgsConstructor: 특정 파라미터가 있는 생성자는 NonNull이나 final이 붙어있는 것에만 적용 

@Component
@ToString
@Getter
@RequiredArgsConstructor
public class SampleHotel3 {
	
	@NonNull
	private Chef chef;
	//단일생성자의 묵시적 자동주입(@Autowired 생략)
	//생성자 주입
//	public SampleHotel2(Chef chef) {
//		super();
//		this.chef = chef;
//	}
	
	
	
}
