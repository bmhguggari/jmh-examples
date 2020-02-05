package com.tavant.hanamant.benchmark;

import com.tavant.hanamant.benchmark.service.AlgorithmService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.VerboseMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;


@SpringBootTest
class JmhBenchmarkApplicationTests {

	@Autowired
	AlgorithmService service;

	static Options option;

	@BeforeAll
	public static void setupOptions() {
		option = new OptionsBuilder()
				.include(AlgorithmService.class.getSimpleName())
				.forks(1)
				.resultFormat(ResultFormatType.JSON)
				.result("algo_benchmark_report.json")
				.verbosity(VerboseMode.EXTRA)
				.build();

	}


	@Test
	public void testServiceInstance() {
		Assert.notNull(service, "Service object is null");
		try {
			Runner runner = new Runner(option);
			runner.run();


		} catch(Exception ex) {}
	}

}
