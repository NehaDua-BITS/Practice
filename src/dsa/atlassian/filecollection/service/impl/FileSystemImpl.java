package dsa.atlassian.filecollection.service.impl;

import dsa.atlassian.filecollection.exceptions.FileNotFoundException;
import dsa.atlassian.filecollection.exceptions.InvalidInputException;
import dsa.atlassian.filecollection.model.Directory;
import dsa.atlassian.filecollection.model.File;
import dsa.atlassian.filecollection.service.FileSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileSystemImpl implements FileSystem {

    public static final String DEFAULT_DIRECTORY = "default";

    private Map<String, Directory> directoryMap;

    private int memoryConsumed;

    public FileSystemImpl() {
        this.directoryMap = new HashMap<>();
        this.directoryMap.put(DEFAULT_DIRECTORY, new Directory(DEFAULT_DIRECTORY));
    }

    @Override
    public File addFile(String fileName, int size) {
        Directory defaultDir = directoryMap.get(DEFAULT_DIRECTORY);
        checkIfFileAlreadyExists(fileName, defaultDir);
        File file = new File(fileName, size);
        defaultDir.addFile(file);
        memoryConsumed += size;
        return file;
    }

    @Override
    public File addFile(String fileName, int size, String collectionName) {
        Directory directory = getCollection(collectionName);
        if (directory == null) {
            throw new InvalidInputException("Directory does not exist");
        }
        checkIfFileAlreadyExists(fileName, directory);
        File file = new File(fileName, size, collectionName);
        directory.addFile(file);
        memoryConsumed += size;
        return file;
    }

    private void checkIfFileAlreadyExists(String fileName, Directory directory) {
        if (directory.hasFile(fileName)) {
            throw new InvalidInputException("File already exists in the collection = " + directory.getName());
        }
    }

    @Override
    public Directory addCollection(String name) {
        Directory directory = getCollection(name);
        if (directory != null) {
            throw new InvalidInputException("Collection already exists");
        }
        directory = new Directory(name);
        directoryMap.put(name, directory);
        return directory;
    }

    @Override
    public List<File> getFiles(String collectionName) {
        Directory directory = getCollection(collectionName);
        if (directory == null) {
            throw new FileNotFoundException("Collection doesn't exist");
        }
        return directory.getFiles();
    }

    @Override
    public int getMemoryConsumed() {
        return this.memoryConsumed;
    }

    @Override
    public List<Directory> getCollections() {
        return new ArrayList<>(directoryMap.values());
    }

    @Override
    public Directory getCollection(String collectionName) {
        return directoryMap.get(collectionName);
    }
}
