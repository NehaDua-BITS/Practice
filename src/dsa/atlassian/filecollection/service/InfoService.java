package dsa.atlassian.filecollection.service;

import dsa.atlassian.filecollection.model.Directory;

import java.util.List;

public interface InfoService {

    int getTotalSize();

    List<Directory> getTopKCollectionsBySize(int k);
}
