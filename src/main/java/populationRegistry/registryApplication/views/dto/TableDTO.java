package populationRegistry.registryApplication.views.dto;

import java.util.LinkedList;

public class TableDTO {
  public LinkedList<String> headerFormat = new LinkedList<>();
  public LinkedList<String> header = new LinkedList<>();
  public LinkedList<String> bodyFormat = new LinkedList<>();
  public LinkedList<LinkedList<String>> body = new LinkedList<>();
}