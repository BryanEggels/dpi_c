package Shared;

import java.util.ArrayList;
import java.util.List;

public final class MessageStorage {
  private static MessageStorage INSTANCE;

  private static List<Report> reports;

  private MessageStorage() {
    reports = new ArrayList();
  }

  public static MessageStorage getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new MessageStorage();
    }

    return INSTANCE;
  }

  public List<Report> getReports() {
    return reports;
  }

  public void addReport(Report report){
    reports.add(report);
  }
}
