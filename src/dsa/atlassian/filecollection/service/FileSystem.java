package dsa.atlassian.filecollection.service;

import dsa.atlassian.filecollection.model.Directory;
import dsa.atlassian.filecollection.model.File;

import java.util.List;

public interface FileSystem {

    File addFile(String fileName, int size);

    File addFile(String fileName, int size, String collectionName);

    Directory addCollection(String name);

    List<File> getFiles(String collection);

    List<Directory> getCollections();

    Directory getCollection(String collectionName);

    int getMemoryConsumed();
}
