package populationRegistry.registryApplication.services.dto;

import java.util.LinkedList;

public class FilterDataDTO {

  public boolean filter;
  public LinkedList<String> names = new LinkedList<>();
  public LinkedList<Integer> numbers = new LinkedList<>(); 
}