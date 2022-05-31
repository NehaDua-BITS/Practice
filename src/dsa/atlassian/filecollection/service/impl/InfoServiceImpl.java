package dsa.atlassian.filecollection.service.impl;

import dsa.atlassian.filecollection.model.Directory;
import dsa.atlassian.filecollection.service.FileSystem;
import dsa.atlassian.filecollection.service.InfoService;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class InfoServiceImpl implements InfoService {

    private final FileSystem fileSystem;

    public InfoServiceImpl(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    @Override
    public int getTotalSize() {
        return fileSystem.getMemoryConsumed();
    }

    @Override
    public List<Directory> getTopKCollectionsBySize(int k) {
        List<Directory> resultList = new ArrayList<>(k);
        PriorityQueue<Directory> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.getSize() - o1.getSize());
        priorityQueue.addAll(fileSystem.getCollections());

        for (int i = 0; i < k && !priorityQueue.isEmpty(); i++) {
            resultList.add(priorityQueue.poll());
        }

        return resultList;
    }

}
