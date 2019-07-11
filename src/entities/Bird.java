package entities;

/**
 * Bird.
 * <p>
 * Должны быть следущие свойства:
 * <p>
 * name  тип String
 * livingArea тип String
 * size – число с плавающей точкой, может быть незаполненным (Double).
 */
public class Bird {
    private Integer id;
    private String name;
    private String livingArea;
    private Double size;

    public Bird(Integer id, String name, String livingArea, Double size) {
        this.id = id;
        this.name = name;
        this.livingArea = livingArea;
        this.size = size;
    }


    public Bird() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bird{");
        sb.append("id='").append(id).append('\'');
        sb.append("name='").append(name).append('\'');
        sb.append(", livingArea='").append(livingArea).append('\'');
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}
