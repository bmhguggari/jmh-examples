package com.tavant.hanamant.benchmark.model;

import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@State(Scope.Benchmark)
public class SearchModel {

    private Integer searchKey;
    private List<Integer> searchList = new ArrayList<>();

    public SearchModel() {
        this.searchList = new Random().ints().limit(450).boxed().collect(Collectors.toList());
        Collections.sort(this.getSearchList());
        this.searchKey = this.searchList.get(new Random().nextInt(449));

    }

    public Integer getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(Integer searchKey) {
        this.searchKey = searchKey;
    }

    public List<Integer> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<Integer> searchList) {
        this.searchList = searchList;
    }
}
