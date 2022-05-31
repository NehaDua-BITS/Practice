package src;

import dsa.atlassian.filecollection.model.Directory;
import dsa.atlassian.filecollection.model.File;
import dsa.atlassian.filecollection.service.FileSystem;
import dsa.atlassian.filecollection.service.InfoService;
import dsa.atlassian.filecollection.service.impl.FileSystemImpl;
import dsa.atlassian.filecollection.service.impl.InfoServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestFileSystem {

    @Test
    public void testSizeForEmptyCollection() {
        FileSystem fileSystem = new FileSystemImpl();
        InfoService infoService = new InfoServiceImpl(fileSystem);
        fileSystem.addCollection("collection1");
        int size = infoService.getTotalSize();
        Assert.assertEquals(0, size);
    }

    @Test
    public void testSizeForFilledCollection() {
        FileSystem fileSystem = new FileSystemImpl();
        InfoService infoService = new InfoServiceImpl(fileSystem);
        fileSystem.addCollection("collection1");
        int fileSize = 10;
        fileSystem.addFile("file1", fileSize, "collection1");
        int actualSize = infoService.getTotalSize();
        Assert.assertEquals(fileSize, actualSize);
    }

    @Test
    public void testSizeForCollectionWithMultipleFiles() {
        FileSystem fileSystem = new FileSystemImpl();
        InfoService infoService = new InfoServiceImpl(fileSystem);
        fileSystem.addCollection("collection1");
        int fileSize1 = 10;
        int fileSize2 = 20;
        fileSystem.addFile("file1", fileSize1, "collection1");
        fileSystem.addFile("file2", fileSize2, "collection1");
        int actualSize = infoService.getTotalSize();
        Assert.assertEquals(fileSize1 + fileSize2, actualSize);
    }

    @Test
    public void testAddFile() {
        FileSystem fileSystem = new FileSystemImpl();
        fileSystem.addCollection("collection1");
        int fileSize1 = 10;
        fileSystem.addFile("file1", fileSize1, "collection1");
        List<File> files = fileSystem.getFiles("collection1");
        Assert.assertEquals(1, files.size());
        Assert.assertEquals("file1", files.get(0).getName());
        Assert.assertEquals(fileSize1, files.get(0).getSize());
        Assert.assertEquals("collection1", files.get(0).getParentDirectory());
    }

    @Test
    public void testTopCollection() {
        FileSystem fileSystem = new FileSystemImpl();
        InfoService infoService = new InfoServiceImpl(fileSystem);

        fileSystem.addCollection("collection1");
        fileSystem.addCollection("collection2");

        fileSystem.addFile("file1", 100, "collection1");
        fileSystem.addFile("file2", 200, "collection1");
        fileSystem.addFile("file3", 300, "collection2");
        fileSystem.addFile("file4", 400, "collection2");

        List<Directory> topK = infoService.getTopKCollectionsBySize(1);
        Assert.assertNotNull(topK);
        Assert.assertEquals(1, topK.size());
        Assert.assertEquals("collection2", topK.get(0).getName());
        Assert.assertEquals(700, topK.get(0).getSize());
    }

    @Test
    public void testTopKCollection() {
        FileSystem fileSystem = new FileSystemImpl();
        InfoService infoService = new InfoServiceImpl(fileSystem);

        fileSystem.addCollection("collection1");
        fileSystem.addCollection("collection2");
        fileSystem.addCollection("collection3");
        fileSystem.addCollection("collection4");
        fileSystem.addCollection("collection5");

        fileSystem.addFile("file1", 100, "collection1");
        fileSystem.addFile("file2", 200, "collection1"); //300
        fileSystem.addFile("file3", 500, "collection2");//500
        fileSystem.addFile("file4", 50, "collection3");//50
        fileSystem.addFile("file5", 30, "collection4");//330
        fileSystem.addFile("file6", 300, "collection4");
        fileSystem.addFile("file7", 100, "collection5");//200
        fileSystem.addFile("file8", 100, "collection5");

        int k = 3;
        List<Directory> topK = infoService.getTopKCollectionsBySize(k);
        Assert.assertNotNull(topK);
        Assert.assertEquals(k, topK.size());
        Assert.assertEquals("collection2", topK.get(0).getName());
        Assert.assertEquals("collection4", topK.get(1).getName());
        Assert.assertEquals("collection1", topK.get(2).getName());
        Assert.assertEquals(500, topK.get(0).getSize());
        Assert.assertEquals(330, topK.get(1).getSize());
        Assert.assertEquals(300, topK.get(2).getSize());
    }

}
