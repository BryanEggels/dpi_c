package AmbuApplicatie;

import Shared.Report;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmbuMain {

  public static Scanner scanner;
  public static List<Report> reports;
  public static MeldkamerGateway gateway;

  public static void main(String[] args) {
    reports = new ArrayList<>();
    gateway = new MeldkamerGateway();
    gateway.registerListener(new EmergencyListener());
    scanner = new Scanner(System.in);
    showReports();
  }


  public static void showReports() {
    System.out.println("These are all the reports for the ambulance station: \n");


  }

  public static void addReport(Report report){
    reports.add(report);
    System.out.println(reports.size() + ": " + report.toString());
    processReport(report);
  }

  public static void processReport(Report report){
    System.out.println("do you wish to respond to the emergency call?");
    String answer = scanner.nextLine();

    if (answer.equals("y")){
      System.out.println("within how much time can you be on location?");
      String responstime = "ambulance: " + scanner.nextLine();
      report.addResponseTime(responstime);
      gateway.sender.sendReport(report);
    }

  }


}
