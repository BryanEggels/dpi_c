package Shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Report implements Serializable {

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  String id;
  public int repliesToReceive;
  String gebeurtenis;
  Date tijd;

  public List<String> getResponsetime() {
    return responsetime;
  }

  public void setResponsetime(List<String> responsetime) {
    this.responsetime = responsetime;
  }

  private List<String> responsetime;

  public Report(String gebeurtenis) {
    this.gebeurtenis = gebeurtenis;
    this.tijd = new Date();
    responsetime = new ArrayList<>();
  }

  public Report() {
  }


  public String getGebeurtenis() {
    return gebeurtenis;
  }

  public void setGebeurtenis(String gebeurtenis) {
    this.gebeurtenis = gebeurtenis;
  }

  public Date getTijd() {
    return tijd;
  }

  public void setTijd(Date tijd) {
    this.tijd = tijd;
  }

  @Override
  public String toString() {
    String responsString = "";
    for (String time: responsetime) {
      responsString += time + " minutes \n ";
    }
    if (responsetime.size() > 0){
      return gebeurtenis + " : " + responsString;
    }
    else {
      return gebeurtenis + " om :" + tijd;
    }

  }

  public void addResponseTime(String time){
    responsetime.add(time);
  }
}
