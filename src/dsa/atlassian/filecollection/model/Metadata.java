package dsa.atlassian.filecollection.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metadata {
    protected String name;
    protected int size;
    protected String parentDirectory;

    public Metadata(String name) {
        this(name, 0);
    }

    public Metadata(String name, int size) {
        this(name, size, null);
    }

    public Metadata(String name, int size, String directory) {
        this.name = name;
        this.size = size;
        this.parentDirectory = directory;
    }
}
