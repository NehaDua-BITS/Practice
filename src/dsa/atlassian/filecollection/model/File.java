package dsa.atlassian.filecollection.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File extends Metadata {

    public File(String name, int size) {
        super(name, size);
    }

    public File(String name, int size, String directory) {
        super(name, size, directory);
    }
}
