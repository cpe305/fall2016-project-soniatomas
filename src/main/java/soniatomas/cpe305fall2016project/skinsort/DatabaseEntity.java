package main.java.soniatomas.cpe305fall2016project.skinsort;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Version;
 
public abstract class DatabaseEntity {
 
    @Id
    @Property("id")
    protected ObjectId id;
 
    @Version
    @Property("version")
    private Long version;
 
    public DatabaseEntity() {
        super();
    }
 
    public ObjectId getId() {
        return id;
    }
 
    public void setId(ObjectId id) {
        this.id = id;
    }
 
    public Long getVersion() {
        return version;
    }
 
    public void setVersion(Long version) {
        this.version = version;
    }
 
}