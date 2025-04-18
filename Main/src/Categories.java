public class Categories {

    private String name;

    Categories(){
        this.name = "General";
    }
    Categories(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
