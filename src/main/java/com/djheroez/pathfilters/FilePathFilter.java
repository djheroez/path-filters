package com.djheroez.pathfilters;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilePathFilter implements DirectoryStream.Filter<Path> {
    @Override
    public boolean accept(Path entry) throws IOException {
        return Files.isRegularFile(entry);
    }
}