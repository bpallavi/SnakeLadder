package MyStuff.SnakeLadderPackage;

public class Player {
    String name;
    Integer id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
