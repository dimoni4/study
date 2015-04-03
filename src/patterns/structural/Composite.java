package patterns.structural;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dvetrov on 25/03/15.
 */
public class Composite {
    public static void main(String[] args) {
        Directory firstDir = new Directory("firstDir");
        firstDir.addFile(new File("1.img"));
        Directory secondDir = new Directory("secondDir");
        secondDir.addFile(new File("2.jpeg"));
        firstDir.addFile(secondDir);

        firstDir.ls();
    }
}


interface AbstractFile {
    void ls();
}

class File implements AbstractFile {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void ls() {
        System.out.println(name);
    }
}

class Directory implements AbstractFile {
    private String name;

    private List<AbstractFile> fileList;

    public Directory(String name) {
        this.name = name;
        fileList = new LinkedList<AbstractFile>();
    }

    public AbstractFile addFile(AbstractFile file) {
        fileList.add(file);
        return this;
    }

    public void ls() {
        System.out.println(name);
        for(AbstractFile file : fileList) {
            file.ls();
        }
    }
}