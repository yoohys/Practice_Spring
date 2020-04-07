package org.zerock.service;

import org.springframework.stereotype.Service;

@Service //@service:스프링에서 빈으로 사용할수있게함
public class SampleServiceImpl implements SampleService {

	@Override
	public Integer doAdd(String str1, String str2) throws Exception {
		//log.info()를 생략함. 
		//로그 기록은 반복적이면서 핵심로직도 아니고 필요하기는 한 기능이기 때문에 관심사로 간주 가능.
		return Integer.parseInt(str1)+Integer.parseInt(str2);
	}

}
