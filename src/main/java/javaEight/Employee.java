package javaEight;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
  int id;
  String name;
  Date dob;
  String department;
}
