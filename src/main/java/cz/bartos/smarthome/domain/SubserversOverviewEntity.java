package cz.bartos.smarthome.domain;

/**
 *
 * @author Mira
 */
public class SubserversOverviewEntity {
    
    private String id;
    private String title;
    private String location;
    private String address;
    private String description;
    private String addDate;

    public SubserversOverviewEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    

    @Override
    public String toString() {
        return "SubserversOverview{" + "id=" + id + ", title=" + 
                title + ", location=" + location + ", address=" + 
                address + ", description=" + description + ", addDate=" + 
                addDate + '}';
    }
    
}
