package com.tavant.hanamant.benchmark.service;

import com.tavant.hanamant.benchmark.model.SearchModel;
import org.openjdk.jmh.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.IntStream;

@Service
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 0)
@Measurement(iterations = 2, time = 10, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.SECONDS)
public class AlgorithmService {

    @Benchmark
    public Integer linearSearch(SearchModel model) {
        System.out.println("Linear search has been called" + model.getSearchList() +"\n key :"+ model.getSearchKey());
        Integer keyIndex = -1;
        List<Integer> list = model.getSearchList();
        Integer searchKey = model.getSearchKey();
        if(list != null && !list.isEmpty()) {
            keyIndex = IntStream.range(0, list.size()).filter(i -> searchKey.intValue() == list.get(i).intValue()).findFirst().orElse(-1);
        }
        return keyIndex;
    }


    @Benchmark
    public Integer binarySearch(SearchModel model) {
        System.out.println("Binary search has been called" + model.getSearchList() +"\n key :"+ model.getSearchKey());
        Integer keyIndex = -1;
        List<Integer> list = model.getSearchList();
        Integer searchKey = model.getSearchKey();
        if(list != null && !list.isEmpty()) {
            keyIndex = binarySearch(list.toArray(new Integer[0]), 0, list.size() -1, searchKey);
        }
        return keyIndex;
    }

    private int binarySearch(Integer[] arr, int left, int right, int searchKey)
    {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            if (arr[mid].intValue() == searchKey) {
                return mid;
            }
            if (arr[mid] > searchKey) {
                return binarySearch(arr, left, mid - 1, searchKey);
            }

            return binarySearch(arr, mid + 1, right, searchKey);
        }
        //At the end of search
        return -1;
    }
}
