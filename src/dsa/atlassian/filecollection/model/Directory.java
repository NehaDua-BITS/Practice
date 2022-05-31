package dsa.atlassian.filecollection.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Directory extends Metadata {

    private Map<String, File> filesMap;

    public Directory(String name) {
        super(name);
        this.filesMap = new HashMap<>();
    }

    public void addFile(File file) {
        filesMap.put(file.getName(), file);
        size += file.getSize();
    }

    public List<File> getFiles() {
        return new ArrayList<>(filesMap.values());
    }

    public boolean hasFile(String fileName) {
        return filesMap.containsKey(fileName);
    }

    public File getFile(String fileName) {
        return filesMap.get(fileName);
    }

}
