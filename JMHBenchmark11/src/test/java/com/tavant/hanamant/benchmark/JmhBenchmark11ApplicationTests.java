package com.tavant.hanamant.benchmark;


import com.tavant.hanamant.benchmark.service.AlgorithmService;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class JmhBenchmark11ApplicationTests {



		@Autowired
		AlgorithmService service;


		@Test
		public void testServiceInstance() {

			try {
				Options option = new OptionsBuilder()
						.include(AlgorithmService.class.getSimpleName())
						.forks(0)
						.resultFormat(ResultFormatType.JSON)
						.result("algo_benchmark_report.json")
						.build();
				new Runner(option).run();




			} catch(Exception ex) {
				ex.printStackTrace();
			}
	}

}
