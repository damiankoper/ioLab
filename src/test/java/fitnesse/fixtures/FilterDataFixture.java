package fitnesse.fixtures;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

import populationRegistry.App;
import populationRegistry.registryApplication.services.dto.FilterDataDTO;
import populationRegistry.registryApplication.views.RegistryApplicationIndexView;

public class FilterDataFixture {
    private String input;

    public FilterDataFixture() {
    }

    public void setInput(String input) {
        this.input = input;
    }

    public boolean isFiltering() {
        return getFilterData().filter;
    }

    public List<String> names() {
        return getFilterData().names;
    }

    public List<String> pesels() {
        return getFilterData().pesels;
    }

    private FilterDataDTO getFilterData(){
        App.scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        RegistryApplicationIndexView view  = new RegistryApplicationIndexView();
        return view.getFilterData();
    }
}