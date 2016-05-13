package pub.iyu.androidclient.model;

/**
 * Created by tsinu on 2016/5/13.
 */
public class Student {

    private int id;
    private String name;
    private String classes;

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

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String toString(){
        return "Student [classes=" + classes + ",id=" + id + ",name=" + name + "]";
    }
}
