public class Employee {
private int id;
private String name, last_name;
private Position titlos;
public Employee(int id, String name, String last_name, Position
titlos) {
[10]
this.id = id;
this.name = name;
this.last_name = last_name;
this.titlos = titlos;
}
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getLast_name() {
return last_name;
}
public void setLast_name(String last_name) {
this.last_name = last_name;
}
public Position getTitlos() {
return titlos;
}
public void setTitlos(Position titlos) {
this.titlos = titlos;
}
}