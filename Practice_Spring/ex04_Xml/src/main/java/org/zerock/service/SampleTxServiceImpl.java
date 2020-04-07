package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.mapper.Sample1Mapper;
import org.zerock.mapper.Sample2Mapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Transactional //트랜잭션처리를 하면 모두 정상적으로 완료한 경우에만 commit하게 함.
@Service
@Log4j
public class SampleTxServiceImpl implements SampleTxService {

	@Setter(onMethod_ = @Autowired)
	private Sample1Mapper mapper1;
	
	@Setter(onMethod_ = @Autowired)
	private Sample2Mapper mapper2;	
	
	@Override
	public void addData(String value) { //같은 데이터를 mapper1,2에 동시 주입
		log.info("mapper1.....................");
		mapper1.insertCol1(value);
		log.info("mapper2.....................");
		mapper2.insertCol2(value);
		log.info("end.....................");

	}

}
