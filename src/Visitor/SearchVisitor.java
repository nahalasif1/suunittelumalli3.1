package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String pattern;
    private final List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(String pattern) {
        this.pattern = pattern;
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(pattern)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // No action for directories, just traverses
    }
}

